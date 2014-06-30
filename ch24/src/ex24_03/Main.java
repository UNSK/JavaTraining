package ex24_03;

import java.text.DateFormat;
import java.text.ParseException;
import java.util.Date;


public class Main {

    public static void main(String[] args) {
        printDate("1988/07/11");
        System.out.println();
        printDate("20000/13/35");
    }
    
    public static void printDate(String str) {
        try {
            Date date = DateFormat.getDateInstance().parse(str);
            System.out.println(DateFormat.getDateInstance(DateFormat.SHORT).format(date));
            System.out.println(DateFormat.getDateInstance(DateFormat.MEDIUM).format(date));
            System.out.println(DateFormat.getDateInstance(DateFormat.LONG).format(date));
            System.out.println(DateFormat.getDateInstance(DateFormat.FULL).format(date));
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

}
