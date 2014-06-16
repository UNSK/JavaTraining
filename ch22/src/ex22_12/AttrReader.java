package ex22_12;


import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class AttrReader {
    private static final String LINE_SEPARATOR_PATTERN = 
            "\r\n|\n\r\u2028\u2029\u0085";
    
    public static Attributed read(Readable source) {
        @SuppressWarnings("resource")
        Scanner in = new Scanner(source);
        in.useDelimiter("\\s*=\\s*|" + LINE_SEPARATOR_PATTERN);
        AttributedImpl attrs = new AttributedImpl();
        Attr attr = null;
        
        while (in.hasNext()) {
            if (attr == null) { //new attribute
                attr = new Attr(in.next());
                attrs.add(attr);
            } else {            // set value
                attr.setValue(in.next());
                attr = null;
            }
        }
        
        return attrs;
    }
    
    public static void main(String[] args) throws IOException {
        FileReader source = new FileReader(new File("../ch22/src/ex22_12/test"));
        Attributed attrs = read(source);
        
        for (Attr attr : attrs) {
            System.out.println(attr);
        }
        
        source.close();
    }
    
}
