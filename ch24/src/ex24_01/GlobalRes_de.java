package ex24_01;

import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;

public class GlobalRes_de extends ResourceBundle {

    private static final Map<String, String> MAP = new HashMap<>();
    private static final String[] KEYS = {"hello", "goodbye"};
     
    static {
        MAP.put(KEYS[0], "Guten Tag");
        MAP.put(KEYS[1], "Auf Wiedersehen");
    }
    
    @Override
    public Enumeration<String> getKeys() {
            return new Enumeration<String>() {
                private int i = 0;
                
                @Override
                public boolean hasMoreElements() {
                    return (i < KEYS.length);
                }

                @Override
                public String nextElement() {
                    return KEYS[i++];
                }
            };
    }

    @Override
    protected Object handleGetObject(String key) {
        return MAP.get(key);
    }
}
