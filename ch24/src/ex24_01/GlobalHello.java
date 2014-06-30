package ex24_01;

import java.util.Locale;
import java.util.ResourceBundle;

public class GlobalHello {
    public static void main(String[] args) {
//        Locale.setDefault(Locale.ENGLISH);
//        Locale.setDefault(Locale.JAPANESE);
//        Locale.setDefault(Locale.FRENCH);
        Locale.setDefault(Locale.GERMANY);
        ResourceBundle res = ResourceBundle.getBundle("ex24_01.GlobalRes");
        String msg;
        if (args.length > 0) {
            msg = res.getString(GlobalRes.GOODBYE);
        } else {
            msg = res.getString(GlobalRes.HELLO);
        }
        System.out.println(msg);
    }
}
