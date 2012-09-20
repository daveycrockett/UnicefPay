package org.un.salaries;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

public class WebScraper {

    public static String SALARIES_BASE_URL = "http://www.un.org/Depts/OHRM/salaries_allowances/salaries/";
    public static String SALARY_PAGE = "gs.htm";
    public static int CURRENCY_ROW = 8;
    
    public static int SALARY_ROW = 16;
    public static int SALARY_COLUMN = 3;
 
    public static String getText(String url) throws IOException, MalformedURLException {
        URL website = new URL(url);
        return getText(website);
    }
    
    public static String getText(URL website) throws IOException {
        URLConnection connection = website.openConnection();
        BufferedReader in = new BufferedReader(
                                new InputStreamReader(
                                    connection.getInputStream()));

        StringBuilder response = new StringBuilder();
        String inputLine;

        while ((inputLine = in.readLine()) != null) 
            response.append(inputLine);

        in.close();

        return response.toString();
    }
    
    public static void parseCurrencyValue(String s, Country country) {
        s = s.replace("(", "");
        int i = s.indexOf(")");
        if (i >= 0) {
            s = s.substring(0, i);
        }
        s = s.trim();
        if (s.toLowerCase().startsWith("in ")) {
            s = s.substring(3);
        }
        if (s.trim().length() > 0) {
            if (s.trim().toLowerCase().startsWith("thousands of")) {
                country.setMultiplier(1000);
                s = s.trim().substring("thousands of".length()).trim();
            }
            if (s.trim().toLowerCase().startsWith("millions of")) {
                country.setMultiplier(1000000);
                s = s.trim().substring("millions of".length()).trim();
            }
            if (Currency.commonLookup.containsKey(s.toLowerCase())) {
                country.setCurrencyCode(Currency.commonLookup.get(s.toLowerCase()));
            } else if (Currency.countryLookup.containsKey(country.getName())) {
                 country.setCurrencyCode(Currency.countryLookup.get(country.getName()));
            } else {
                System.err.println("Couldn't find currency for country " + country.getName() + ": " + s + "\n\n");
            }
        } else if (Currency.countryLookup.containsKey(country.getName())) {
            country.setCurrencyCode(Currency.countryLookup.get(country.getName()));
        } else {
            System.err.println("Couldn't find currency for country " + country.getName() + "\n\n");
        }
    }

    private static Object coerceCell(HSSFCell cell) {
        try {
            return cell.getStringCellValue();
        } catch (IllegalStateException e) {
            try {
                return new Double(cell.getNumericCellValue());
            } catch (IllegalStateException f) {
                return "";
            }
        }
    }
    
    private static String findCurrencyValue(ArrayList<ArrayList<Object>> sheetData) {
        for (int i = 0; i < sheetData.size(); i++) {
            for (int j = 0; j < sheetData.get(i).size(); j++) {
                String obj = sheetData.get(i).get(j).toString();
                if (obj.trim().toLowerCase().startsWith("(") && obj.toLowerCase().contains("in")) {
                    return obj.toString();
                }
            }
        }
        return "";
    }
    
    private static Point findTextValue(ArrayList<ArrayList<Object>> sheetData, String toFind) {
        for (int i = 0; i < sheetData.size(); i++) {
            for (int j = 0; j < sheetData.get(i).size(); j++) {
                String obj = sheetData.get(i).get(j).toString();
                if (obj.trim().equalsIgnoreCase(toFind)) {
                    return new Point(i, j);
                }
            }
        }
        return new Point(-1, -1);
    }
    
    private static int findTextValueInColumn(ArrayList<ArrayList<Object>> sheetData, String toFind, int column) {
        for (int i = 0; i < sheetData.size(); i++) {
            if (sheetData.get(i).size() > column) {
                if (sheetData.get(i).get(column).toString().trim().equalsIgnoreCase(toFind)) {
                    return i;
                }
            }
        }
        return Integer.MAX_VALUE;
    }
    
    private static int findSalaryRow(ArrayList<ArrayList<Object>> sheetData, int column) {
        int a = findTextValueInColumn(sheetData, "1", column);
        int b = findTextValueInColumn(sheetData, "1-A", column);
        int c = findTextValueInColumn(sheetData, "(gross)", column);
        int toRet = Math.min(a, Math.min(b, c));
        if (toRet == Integer.MAX_VALUE) {
            return -1;
        }
        return toRet;
    }
    
    public static void scrapeExcel(URL website, Country country) throws IOException, MalformedURLException {
        URLConnection connection = website.openConnection();

        HSSFWorkbook workbook = new HSSFWorkbook(connection.getInputStream());
        HSSFSheet sheet = workbook.getSheetAt(0);

        ArrayList<ArrayList<Object>> sheetData = new ArrayList<ArrayList<Object>>();
        
        Iterator<Row> rows = sheet.rowIterator();
        while (rows.hasNext()) {
            ArrayList<Object> rowData = new ArrayList<Object>();
            HSSFRow row = (HSSFRow) rows.next();
            Iterator<Cell> cells = row.cellIterator();
            while (cells.hasNext()) {
                HSSFCell cell = (HSSFCell) cells.next();
                rowData.add(coerceCell(cell));
            }
            sheetData.add(rowData);
        }
        
        String s = findCurrencyValue(sheetData);
        if (s.equals("")) { 
            return;
        } else {
            parseCurrencyValue(s, country);
        }

        Point findLevel = findTextValue(sheetData, "level");
        int levelColumn = (int)findLevel.getY();
        if (levelColumn == -1) {
            System.out.println("couldn't find level for " + country.getName());
            return;
        }
        int salaryRow = findSalaryRow(sheetData, levelColumn);
        if (salaryRow == -1) {
            System.out.println("couldn't find level 1 for " + country.getName());
            return;
        }

        int salaryColumn = (int)findTextValue(sheetData, "I").getY();
        if (salaryColumn == -1) {
            System.out.println("couldn't find salaryColumn for " + country.getName());
            return;
        }
        try {
            // this spreadsheet template has jagged columns, as there are some hidden cells at the top
            // hence the off-by-one in the column
            country.setSalary((Double)sheetData.get(salaryRow).get(salaryColumn - 1));
        } catch (ClassCastException e) {
            // of course, there are a couple exceptions where people messed with the
            // file format.
            country.setSalary((Double)sheetData.get(salaryRow).get(salaryColumn));
        }
    }
    
    public static ArrayList<Country> scrapeCountryPages(String html) throws MalformedURLException {
        ArrayList<Country> toRet = new ArrayList<Country>();
        String htmlLower = html.toLowerCase();
        int found = htmlLower.indexOf("<option");
        int offset = 0;
        while (found >= 0) {
            offset = found + 1;
            int valueStart = htmlLower.indexOf("value=\"", offset);
            int valueEnd = htmlLower.indexOf("\"", valueStart+"value=\"".length());
            int tagStart = htmlLower.indexOf(">", offset);
            int tagEnd = htmlLower.indexOf("<", tagStart+1);
            if (valueStart < tagStart) {
                String page = html.substring(valueStart + "value=\"".length(), valueEnd);
                String pageName = html.substring(tagStart + 1, tagEnd);
                
                if (!page.startsWith("salaryscale/")) {
                    Country c = new Country();
                    c.setSource(new URL(SALARIES_BASE_URL + page));
                    c.setName(pageName);
                    toRet.add(c);
                }
            }
            found = htmlLower.indexOf("<option", offset);
        }
        return toRet;
    }
    
    public static String stripExcessWhiteSpace(String s) {
        String[] tokens = s.split("\\s");
        if (tokens.length == 0) {
            return "";
        }
        String toRet = tokens[0];
        for (String token: tokens) {
            if (token.trim().length() > 0) {
                toRet += " " + token.trim();
            }
        }
        return toRet;
    }
    
    public static String[] scrapeCountryPage(String html) {
        String[] toRet = new String[2];
        String htmlLower = html.toLowerCase();
        int start = htmlLower.indexOf("href=\"salaryscale");
        int end = htmlLower.indexOf("\"", start + "href=\"salaryscale".length());
        toRet[0] = html.substring(start+"href=\"".length(), end);
        
        start = htmlLower.indexOf(">", end);
        end = htmlLower.indexOf("<", start);
        toRet[1] = stripExcessWhiteSpace(html.substring(start + 1, end));
        
        return toRet;
    }
    
    public static void main(String[] argv) {
        System.out.println("Scraping UNICEF's spreadsheets, this will take a few minutes...");
        // The UN is not a fan of scrapers, apparently.  Let's pretend to be a casual chrome browser
        System.setProperty("http.agent", "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.1 (KHTML, like Gecko) Chrome/22.0.1207.1 Safari/537.1");
        ArrayList<Country> countries = new ArrayList<Country>();
        try {
            countries = scrapeCountryPages(getText(SALARIES_BASE_URL + SALARY_PAGE));
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(1);
        }
        for (Country c: countries) {
            try {
                String[] arr = scrapeCountryPage(getText(c.getSource()));
                c.setSpreadsheetTitle(arr[1]);
                c.setSpreadsheet(new URL(SALARIES_BASE_URL + arr[0]));
                scrapeExcel(c.getSpreadsheet(), c);
                
            } catch (MalformedURLException e) {
                System.out.println(c.getName() + " failed");
                e.printStackTrace();
                continue;
            } catch (IOException e) {
                System.out.println(c.getName() + " failed");
                e.printStackTrace();
                continue;
            } catch (IllegalStateException e) {
                System.out.println(c.getName() + " failed");
                System.out.println(e);
                continue;
            }
        }
        for (Country c: countries) {
            try {
                if (c.getCurrencyCode() == null) {
                    continue;
                }
                double exchg = 1.0;
                if (!c.getCurrencyCode().equals("USD")) {
                    exchg = Currency.getExchange(c.getCurrencyCode());
                }
                System.out.println(c.getName() + "\t" + c.getCurrencyCode() + "\t" + (c.getSalary() * c.getMultiplier()) + "\t" + exchg + "\t" + (Country.unicefCountries.contains(c.getName()) ? "x" : ""));
            } catch (MalformedURLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        System.out.println("\n\n\n\n");
        for (Country c: countries) {
            System.out.println("" + c.getSource() + "\t" + c.getSpreadsheetTitle() + "\t" + c.getSpreadsheet());
        }
    }
    
}
