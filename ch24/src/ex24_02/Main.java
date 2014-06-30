package ex24_02;

import java.util.Currency;
import java.util.Locale;

public class Main {
    private static final Locale[] countries = {
            Locale.JAPAN,
            Locale.US,
            Locale.GERMANY,
            Locale.CHINA,
            Locale.UK,
            Locale.ITALY
    };
    
    public static void main(String[] args) {
        for (int i = 0; i < countries.length; i++) {
            System.out.println("Currency of " + countries[i] + " in");
            System.out.println("Country\tSymbol");
            showCurrencies(countries[i]);
            System.out.println("----------------");
        }
    }
    
    private static void showCurrencies(Locale locale) {
        Currency currency = Currency.getInstance(locale);
        for (int i = 0; i < countries.length; i++) {
            System.out.println(countries[i] + "\t" + currency.getSymbol(countries[i]));
        }
    }
}
