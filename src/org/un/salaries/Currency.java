package org.un.salaries;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.Hashtable;

public class Currency {

    private String code;
    private double exchangeRateUSD;

    public String getCode() {
        return code;
    }
    public void setCode(String code) {
        this.code = code;
    }
    public double getExchangeRateUSD() {
        return exchangeRateUSD;
    }
    public void setExchangeRateUSD(double exchangeRateUSD) {
        this.exchangeRateUSD = exchangeRateUSD;
    }
    
    public static String BASE_URL = "http://finance.yahoo.com/d/quotes.csv?e=.csv&f=sl1d1t1&s=<code>=X";

    public static Double getExchange(String code)  throws MalformedURLException, IOException {
        if (exchangeRates.containsKey(code)) {
            return exchangeRates.get(code);
        } else {
            Double toRet = Double.parseDouble(WebScraper.getText(BASE_URL.replace("<code>", code)).split(",")[1]);
            exchangeRates.put(code, toRet);
            return toRet;
        }
    }
    
    // from http://en.wikipedia.org/wiki/ISO_4217
    public static Hashtable<String, String> countryLookup = new Hashtable<String, String>();
    
    public static Hashtable<String, String> commonLookup = new Hashtable<String, String>();
    public static Hashtable<String, Double> exchangeRates = new Hashtable<String, Double>();

    static {
        commonLookup.put("us dollars", "USD");
        commonLookup.put("euro", "EUR");
        commonLookup.put("united states dollars", "USD");
        commonLookup.put("cfa francs", "XAF");
        
        countryLookup.put("United Arab Emirates", "AED");
        countryLookup.put("Afghanistan", "AFN");
        countryLookup.put("Albania", "ALL");
        countryLookup.put("Armenia", "AMD");
        countryLookup.put("Curaçao", "ANG");
        countryLookup.put("Sint Maarten", "ANG");
        countryLookup.put("Angola", "AOA");
        countryLookup.put("Argentina", "ARS");
        countryLookup.put("Australia", "AUD");
        countryLookup.put("Australian Antarctic Territory", "AUD");
        countryLookup.put("Christmas Island", "AUD");
        countryLookup.put("Cocos (Keeling) Islands", "AUD");
        countryLookup.put("Heard and McDonald Islands", "AUD");
        countryLookup.put("Kiribati", "AUD");
        countryLookup.put("Nauru", "AUD");
        countryLookup.put("Norfolk Island", "AUD");
        countryLookup.put("Tuvalu", "AUD");
        countryLookup.put("Aruba", "AWG");
        countryLookup.put("Azerbaijan", "AZN");
        countryLookup.put("Bosnia and Herzegovina", "BAM");
        countryLookup.put("Barbados", "BBD");
        countryLookup.put("Bangladesh", "BDT");
        countryLookup.put("Bulgaria", "BGN");
        countryLookup.put("Bahrain", "BHD");
        countryLookup.put("Burundi", "BIF");
        countryLookup.put("Bermuda", "BMD");
        countryLookup.put("Brunei", "BND");
        countryLookup.put("Singapore", "BND");
        countryLookup.put("Bolivia", "BOB");
        countryLookup.put("Brazil", "BRL");
        countryLookup.put("Bahamas", "BSD");
        countryLookup.put("Bhutan", "BTN");
        countryLookup.put("Botswana", "BWP");
        countryLookup.put("Belarus", "BYR");
        countryLookup.put("Belize", "BZD");
        countryLookup.put("Canada", "CAD");
        countryLookup.put("Democratic Republic of Congo", "CDF");
        countryLookup.put("Switzerland", "CHE");
        countryLookup.put("Switzerland", "CHF");
        countryLookup.put("Liechtenstein", "CHF");
        countryLookup.put("Switzerland", "CHW");
        countryLookup.put("Chile", "CLF");
        countryLookup.put("Chile", "CLP");
        countryLookup.put("China", "CNY");
        countryLookup.put("Colombia", "COP");
        countryLookup.put("Costa Rica", "CRC");
        countryLookup.put("Cuba", "CUC");
        countryLookup.put("Cuba", "CUP");
        countryLookup.put("Cape Verde", "CVE");
        countryLookup.put("Czech Republic", "CZK");
        countryLookup.put("Djibouti", "DJF");
        countryLookup.put("Denmark", "DKK");
        countryLookup.put("Faroe Islands", "DKK");
        countryLookup.put("Greenland", "DKK");
        countryLookup.put("Dominican Republic", "DOP");
        countryLookup.put("Algeria", "DZD");
        countryLookup.put("Egypt", "EGP");
        countryLookup.put("Eritrea", "ERN");
        countryLookup.put("Ethiopia", "ETB");
        countryLookup.put("Andorra", "EUR");
        countryLookup.put("Austria", "EUR");
        countryLookup.put("Belgium", "EUR");
        countryLookup.put("Cyprus", "EUR");
        countryLookup.put("Estonia", "EUR");
        countryLookup.put("Finland", "EUR");
        countryLookup.put("France", "EUR");
        countryLookup.put("Germany", "EUR");
        countryLookup.put("Greece", "EUR");
        countryLookup.put("Ireland", "EUR");
        countryLookup.put("Italy", "EUR");
        countryLookup.put("Kosovo", "EUR");
        countryLookup.put("Luxembourg", "EUR");
        countryLookup.put("Malta", "EUR");
        countryLookup.put("Monaco", "EUR");
        countryLookup.put("Montenegro", "EUR");
        countryLookup.put("Netherlands", "EUR");
        countryLookup.put("Portugal", "EUR");
        countryLookup.put("San Marino", "EUR");
        countryLookup.put("Slovakia", "EUR");
        countryLookup.put("Slovak Republic", "EUR");
        countryLookup.put("Slovenia", "EUR");
        countryLookup.put("Spain", "EUR");
        countryLookup.put("Vatican City", "EUR");
        countryLookup.put("Fiji", "FJD");
        countryLookup.put("Falkland Islands", "FKP");
        countryLookup.put("United Kingdom", "GBP");
        countryLookup.put("Georgia", "GEL");
        countryLookup.put("Ghana", "GHS");
        countryLookup.put("Gibraltar", "GIP");
        countryLookup.put("Gambia", "GMD");
        countryLookup.put("Guinea", "GNF");
        countryLookup.put("Guatemala", "GTQ");
        countryLookup.put("Guyana", "GYD");
        countryLookup.put("Hong Kong", "HKD");
        countryLookup.put("Macao", "HKD");
        countryLookup.put("Honduras", "HNL");
        countryLookup.put("Croatia", "HRK");
        countryLookup.put("Haiti", "HTG");
        countryLookup.put("Hungary", "HUF");
        countryLookup.put("Indonesia", "IDR");
        countryLookup.put("Israel", "ILS");
        countryLookup.put("Palestinian territories", "ILS");
        countryLookup.put("India", "INR");
        countryLookup.put("Iraq", "IQD");
        countryLookup.put("Iran, Islamic Republic of", "IRR");
        countryLookup.put("Iceland", "ISK");
        countryLookup.put("Jamaica", "JMD");
        countryLookup.put("Jordan", "JOD");
        countryLookup.put("Japan", "JPY");
        countryLookup.put("Kenya", "KES");
        countryLookup.put("Krygyzstan", "KGS"); // [sic]
        countryLookup.put("Kyrgyzstan", "KGS");
        countryLookup.put("Cambodia", "KHR");
        countryLookup.put("Comoros", "KMF");
        countryLookup.put("North Korea", "KPW");
        countryLookup.put("South Korea", "KRW");
        countryLookup.put("Kuwait", "KWD");
        countryLookup.put("Cayman Islands", "KYD");
        countryLookup.put("Kazakhstan", "KZT");
        countryLookup.put("Laos", "LAK");
        countryLookup.put("Lebanon", "LBP");
        countryLookup.put("Sri Lanka", "LKR");
        countryLookup.put("Liberia", "LRD");
        countryLookup.put("Lesotho", "LSL");
        countryLookup.put("Lithuania", "LTL");
        countryLookup.put("Latvia", "LVL");
        countryLookup.put("Libya", "LYD");
        countryLookup.put("Libya Arab Jamahiriya", "LYD");
        countryLookup.put("Morocco", "MAD");
        countryLookup.put("Moldova", "MDL");
        countryLookup.put("Madagascar", "MGA");
        countryLookup.put("Macedonia", "MKD");
        countryLookup.put("Myanmar", "MMK");
        countryLookup.put("Mongolia", "MNT");
        countryLookup.put("Macao", "MOP");
        countryLookup.put("Mauritania", "MRO");
        countryLookup.put("Mauritius", "MUR");
        countryLookup.put("Maldives", "MVR");
        countryLookup.put("Malawi", "MWK");
        countryLookup.put("Mexico", "MXN");
        countryLookup.put("Malaysia", "MYR");
        countryLookup.put("Mozambique", "MZN");
        countryLookup.put("Namibia", "NAD");
        countryLookup.put("Nigeria", "NGN");
        countryLookup.put("Nicaragua", "NIO");
        countryLookup.put("Norway", "NOK");
        countryLookup.put("Svalbard", "NOK");
        countryLookup.put("Jan Mayen", "NOK");
        countryLookup.put("Bouvet Island", "NOK");
        countryLookup.put("Queen Maud Land", "NOK");
        countryLookup.put("Peter I Island", "NOK");
        countryLookup.put("Nepal", "NPR");
        countryLookup.put("Cook Islands", "NZD");
        countryLookup.put("New Zealand", "NZD");
        countryLookup.put("Niue", "NZD");
        countryLookup.put("Pitcairn", "NZD");
        countryLookup.put("Tokelau", "NZD");
        countryLookup.put("Ross Dependency", "NZD");
        countryLookup.put("Oman", "OMR");
        countryLookup.put("Panama", "PAB");
        countryLookup.put("Peru", "PEN");
        countryLookup.put("Papua New Guinea", "PGK");
        countryLookup.put("Philippines", "PHP");
        countryLookup.put("Pakistan", "PKR");
        countryLookup.put("Poland", "PLN");
        countryLookup.put("Paraguay", "PYG");
        countryLookup.put("Qatar", "QAR");
        countryLookup.put("Romania", "RON");
        countryLookup.put("Serbia", "RSD");
        countryLookup.put("Russian Federation", "RUB");
        countryLookup.put("Abkhazia", "RUB");
        countryLookup.put("South Ossetia", "RUB");
        countryLookup.put("Rwanda", "RWF");
        countryLookup.put("Saudi Arabia", "SAR");
        countryLookup.put("Solomon Islands", "SBD");
        countryLookup.put("Seychelles", "SCR");
        countryLookup.put("Sudan", "SDG");
        countryLookup.put("Republic of South Sudan", "SSP");
        countryLookup.put("Sweden", "SEK");
        countryLookup.put("Singapore", "SGD");
        countryLookup.put("Brunei", "SGD");
        countryLookup.put("Saint Helena", "SHP");
        countryLookup.put("Sierra Leone", "SLL");
        countryLookup.put("Somalia", "SOS");
        countryLookup.put("Surinam", "SRD");
        countryLookup.put("South Sudan", "SSP");
        countryLookup.put("SaoTome", "STD");
        countryLookup.put("Syria", "SYP");
        countryLookup.put("Swaziland", "SZL");
        countryLookup.put("Thailand", "THB");
        countryLookup.put("Tajikistan", "TJS");
        countryLookup.put("Turkmenistan", "TMT");
        countryLookup.put("Tunisia", "TND");
        countryLookup.put("Tonga", "TOP");
        countryLookup.put("Turkey", "TRY");
        countryLookup.put("Trinidad and Tobago", "TTD");
        countryLookup.put("Taiwan", "TWD");
        countryLookup.put("Tanzania", "TZS");
        countryLookup.put("Ukraine", "UAH");
        countryLookup.put("Uganda", "UGX");
        countryLookup.put("American Samoa", "USD");
        countryLookup.put("British Indian Ocean Territory", "USD");
        countryLookup.put("British Virgin Islands", "USD");
        countryLookup.put("Caribbean Netherlands", "USD");
        countryLookup.put("Ecuador", "USD");
        countryLookup.put("El Salvador", "USD");
        countryLookup.put("Guam", "USD");
        countryLookup.put("Haiti", "USD");
        countryLookup.put("Marshall Islands", "USD");
        countryLookup.put("Federated States of Micronesia", "USD");
        countryLookup.put("Northern Mariana Islands", "USD");
        countryLookup.put("Palau", "USD");
        countryLookup.put("Panama", "USD");
        countryLookup.put("Puerto Rico", "USD");
        countryLookup.put("Timor-Leste", "USD");
        countryLookup.put("Turks and Caicos Islands", "USD");
        countryLookup.put("United States", "USD");
        countryLookup.put("USA", "USD");
        countryLookup.put("U.S. Virgin Islands", "USD");
        countryLookup.put("Zimbabwe", "USD");
        countryLookup.put("Uruguay", "UYU");
        countryLookup.put("Uzbekistan", "UZS");
        countryLookup.put("Venezuela", "VEF");
        countryLookup.put("Vietnam", "VND");
        countryLookup.put("Vanuatu", "VUV");
        countryLookup.put("Samoa", "WST");
        countryLookup.put("Cameroon", "XAF");
        countryLookup.put("Central African Republic", "XAF");
        countryLookup.put("Congo", "XAF");
        countryLookup.put("Congo, Dem. Rep. of", "XAF");
        countryLookup.put("Chad", "XAF");
        countryLookup.put("Equatorial Guinea", "XAF");
        countryLookup.put("Gabon", "XAF");
        countryLookup.put("Anguilla", "XCD");
        countryLookup.put("Antigua and Barbuda", "XCD");
        countryLookup.put("Dominica", "XCD");
        countryLookup.put("Grenada", "XCD");
        countryLookup.put("Montserrat", "XCD");
        countryLookup.put("Saint Kitts and Nevis", "XCD");
        countryLookup.put("Saint Lucia", "XCD");
        countryLookup.put("Saint Vincent and the Grenadines", "XCD");
        countryLookup.put("Benin", "XOF");
        countryLookup.put("Burkina Faso", "XOF");
        countryLookup.put("Cote D'Ivoire", "XOF");
        countryLookup.put("Guinea Bissau", "XOF");
        countryLookup.put("Mali", "XOF");
        countryLookup.put("Niger", "XOF");
        countryLookup.put("Senegal", "XOF");
        countryLookup.put("Togo", "XOF");
        countryLookup.put("French Polynesia", "XPF");
        countryLookup.put("New Caledonia", "XPF");
        countryLookup.put("Wallis and Futuna", "XPF");
        countryLookup.put("Yemen", "YER");
        countryLookup.put("South Africa", "ZAR");
        countryLookup.put("Zambia", "ZMK");
        countryLookup.put("Zimbabwe", "ZWL");
    }

}
