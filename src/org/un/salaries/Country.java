package org.un.salaries;

import java.net.URL;
import java.util.ArrayList;

public class Country {

    // from http://www.unicef.org/infobycountry/
    public static ArrayList<String> unicefCountries = new ArrayList<String>();
    static {
        unicefCountries.add("Afghanistan");
        unicefCountries.add("Albania");
        unicefCountries.add("Algeria");
        unicefCountries.add("Andorra");
        unicefCountries.add("Angola");
        unicefCountries.add("Argentina");
        unicefCountries.add("Armenia");
        unicefCountries.add("Australia");
        unicefCountries.add("Austria");
        unicefCountries.add("Azerbaijan");
        unicefCountries.add("Bahrain");
        unicefCountries.add("Bangladesh");
        unicefCountries.add("Barbados");
        unicefCountries.add("Belarus");
        unicefCountries.add("Belgium");
        unicefCountries.add("Belize");
        unicefCountries.add("Benin");
        unicefCountries.add("Bhutan");
        unicefCountries.add("Bolivia");
        unicefCountries.add("Botswana");
        unicefCountries.add("Brazil");
        unicefCountries.add("Bulgaria");
        unicefCountries.add("Burkina Faso");
        unicefCountries.add("Burundi");
        unicefCountries.add("Cambodia");
        unicefCountries.add("Cameroon");
        unicefCountries.add("Canada");
        unicefCountries.add("Cape Verde");
        unicefCountries.add("Chad");
        unicefCountries.add("Central African Republic");
        unicefCountries.add("Chile");
        unicefCountries.add("China");
        unicefCountries.add("Colombia");
        unicefCountries.add("Costa Rica");
        unicefCountries.add("Cote D'Ivoire");
        unicefCountries.add("Croatia");
        unicefCountries.add("Cuba");
        unicefCountries.add("Cyprus");
        unicefCountries.add("Czech Republic");
        unicefCountries.add("Congo, Dem. Rep. of");
        unicefCountries.add("Comoros");
        unicefCountries.add("Congo");
        unicefCountries.add("Denmark");
        unicefCountries.add("Dominican Republic");
        unicefCountries.add("Djibouti");
        unicefCountries.add("Ecuador");
        unicefCountries.add("Egypt");
        unicefCountries.add("El Salvador");
        unicefCountries.add("Estonia");
        unicefCountries.add("Ethiopia");
        unicefCountries.add("Eritrea");
        unicefCountries.add("Equatorial Guinea");
        unicefCountries.add("Fiji");
        unicefCountries.add("Finland");
        unicefCountries.add("France");
        unicefCountries.add("Gabon");
        unicefCountries.add("Germany");
        unicefCountries.add("Gambia");
        unicefCountries.add("Georgia");
        unicefCountries.add("Guatemala");
        unicefCountries.add("Guinea Bissau");
        unicefCountries.add("Guyana");
        unicefCountries.add("Guinea");
        unicefCountries.add("Greece");
        unicefCountries.add("Ghana");
        unicefCountries.add("Haiti");
        unicefCountries.add("Honduras");
        unicefCountries.add("Hong Kong");
        unicefCountries.add("Hungary");
        unicefCountries.add("Iceland");
        unicefCountries.add("India");
        unicefCountries.add("Indonesia");
        unicefCountries.add("Iran, Islamic Republic of");
        unicefCountries.add("Ireland");
        unicefCountries.add("Israel");
        unicefCountries.add("Italy");
        unicefCountries.add("Iraq");
        unicefCountries.add("Jamaica");
        unicefCountries.add("Japan");
        unicefCountries.add("Jordan");
        unicefCountries.add("Kazakhstan");
        unicefCountries.add("Kenya");
        unicefCountries.add("Kuwait");
        unicefCountries.add("Kosovo");
        unicefCountries.add("Krygyzstan");
        unicefCountries.add("Lebanon");
        unicefCountries.add("Lesotho");
        unicefCountries.add("Liechtenstein");
        unicefCountries.add("Lithuania");
        unicefCountries.add("Luxembourg");
        unicefCountries.add("Liberia");
        unicefCountries.add("Libya");
        unicefCountries.add("Libya Arab Jamahiriya"); //[sic]
        unicefCountries.add("Lebanon");
        unicefCountries.add("Madagascar");
        unicefCountries.add("Macedonia");
        unicefCountries.add("Malawi");
        unicefCountries.add("Malaysia");
        unicefCountries.add("Mali");
        unicefCountries.add("Mauritania");
        unicefCountries.add("Mexico");
        unicefCountries.add("Monaco");
        unicefCountries.add("Mongolia");
        unicefCountries.add("Morocco");
        unicefCountries.add("Mozambique");
        unicefCountries.add("Myanmar");
        unicefCountries.add("Namibia");
        unicefCountries.add("Nepal");
        unicefCountries.add("Netherlands");
        unicefCountries.add("New Zealand");
        unicefCountries.add("Nicaragua");
        unicefCountries.add("Nigeria");
        unicefCountries.add("Niger");
        unicefCountries.add("Norway");
        unicefCountries.add("Oman");
        unicefCountries.add("Pakistan");
        unicefCountries.add("Panama");
        unicefCountries.add("Peru");
        unicefCountries.add("Philippines");
        unicefCountries.add("Paraguay");
        unicefCountries.add("Papua New Guinea");
        unicefCountries.add("Poland");
        unicefCountries.add("Portugal");
        unicefCountries.add("Qatar");
        unicefCountries.add("Republic of Korea");
        unicefCountries.add("Republic of Moldova");
        unicefCountries.add("Republic of South Sudan");
        unicefCountries.add("Rwanda");
        unicefCountries.add("Romania");
        unicefCountries.add("Russian Federation");
        unicefCountries.add("Samoa");
        unicefCountries.add("SaoTome");
        unicefCountries.add("San Marino");
        unicefCountries.add("Saudi Arabia");
        unicefCountries.add("Seychelles");
        unicefCountries.add("Sierra Leone");
        unicefCountries.add("Somalia");
        unicefCountries.add("South Africa");
        unicefCountries.add("Senegal");
        unicefCountries.add("Serbia");
        unicefCountries.add("Singapore");
        unicefCountries.add("Slovak Republic");
        unicefCountries.add("Slovenia");
        unicefCountries.add("South Korea");
        unicefCountries.add("Spain");
        unicefCountries.add("Sri Lanka");
        unicefCountries.add("Surinam");
        unicefCountries.add("Sudan");
        unicefCountries.add("Sweden");
        unicefCountries.add("Switzerland");
        unicefCountries.add("Tajikistan");
        unicefCountries.add("Trinidad and Tobago");
        unicefCountries.add("Turkmenistan");
        unicefCountries.add("Thailand");
        unicefCountries.add("Macedonia");
        unicefCountries.add("Togo");
        unicefCountries.add("Trinidad");
        unicefCountries.add("Tanzania");
        unicefCountries.add("Tunisia");
        unicefCountries.add("Turkey");
        unicefCountries.add("Syria");
        unicefCountries.add("Ukraine");
        unicefCountries.add("United Arab Emirates");
        unicefCountries.add("United Kingdom");
        unicefCountries.add("USA");
        unicefCountries.add("Uganda");
        unicefCountries.add("Uruguay");
        unicefCountries.add("Uzbekistan");
        unicefCountries.add("Venezuela");
        unicefCountries.add("Yemen");
        unicefCountries.add("Zambia");
        unicefCountries.add("Zimbabwe");
    }
    
    private String name;
    private URL source;
    private URL spreadsheet;
    private String spreadsheetTitle;
    private String currencyCode;
    private double salary;
    private double multiplier = 1.0;

    public double getMultiplier() {
        return multiplier;
    }
    public void setMultiplier(double multiplier) {
        this.multiplier = multiplier;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public URL getSource() {
        return source;
    }
    public void setSource(URL source) {
        this.source = source;
    }
    public URL getSpreadsheet() {
        return spreadsheet;
    }
    public void setSpreadsheet(URL spreadsheet) {
        this.spreadsheet = spreadsheet;
    }
    public String getCurrencyCode() {
        return currencyCode;
    }
    public void setCurrencyCode(String currencyCode) {
        this.currencyCode = currencyCode;
    }
    public double getSalary() {
        return salary;
    }
    public void setSalary(double salary) {
        this.salary = salary;
    }
    public String getSpreadsheetTitle() {
        return spreadsheetTitle;
    }
    public void setSpreadsheetTitle(String spreadsheetTitle) {
        this.spreadsheetTitle = spreadsheetTitle;
    }

}
