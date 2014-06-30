package ex24_01;

import java.util.ListResourceBundle;

public class GlobalRes_fr extends ListResourceBundle {

    @Override
    protected Object[][] getContents() {
        return contents;
    }
    
    private static final Object[][] contents = {
        {GlobalRes.HELLO, "Bonjour"},
        {GlobalRes.GOODBYE, "Au revoir"}
    };

}
