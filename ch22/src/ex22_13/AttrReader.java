package ex22_13;



import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class AttrReader {
    private static final String LINE_SEPARATOR_PATTERN = 
            "\n|\r\n|\n\r\u2028\u2029\u0085";
    private static final String ATTR_SEPARATOR_PATTERN =
            "\\s*=\\s*";
    
    public static Attributed read(Readable source) throws IOException {
        @SuppressWarnings("resource")
        Scanner in = new Scanner(source);
        
        AttributedImpl attrs = new AttributedImpl();
        Attr attr = null;
        
        boolean readValue = false;
        
        in.useDelimiter(ATTR_SEPARATOR_PATTERN);
        while (in.hasNext()) {
            switch (in.delimiter().toString()) {
            case ATTR_SEPARATOR_PATTERN:
                if (attr != null) {
                    throw new IOException("misplaced '='");
                }
                attr = new Attr(in.next());
                attrs.add(attr);
                try {
                    in.skip(ATTR_SEPARATOR_PATTERN);
                } catch (NoSuchElementException e) {
                    throw new IOException("bad attr name");
                }
                in.useDelimiter(LINE_SEPARATOR_PATTERN);
                readValue = false;
                break;
                
            case LINE_SEPARATOR_PATTERN:
                if (attr == null) {
                    throw new IOException("bad attr name");
                }
                String value = in.next();
                if (value.contains("=")) {
                    throw new IOException("misplace '='");
                }
                attr.setValue(value);
                attr = null;
                in.nextLine();
                in.useDelimiter(ATTR_SEPARATOR_PATTERN);
                readValue = true;
                break;
                
            default:
                throw new AssertionError();
            }
        }
        if (!readValue) {
            throw new IOException("didn't read value");
        }
        return attrs;
    }
    
    public static void main(String[] args) throws IOException {
        FileReader source = new FileReader(new File("../ch22/src/ex22_13/test"));
        Attributed attrs = read(source);
        
        for (Attr attr : attrs) {
            System.out.println(attr);
        }
        
        source.close();
    }
    
}
