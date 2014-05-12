package ex20_02;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Reader;
import java.io.StringReader;

public class TranslateByte {
    
    public void translate(InputStream in, OutputStream out, 
            char from, char to) throws IOException {
        int b;
        while ((b = in.read()) != -1) {
            out.write(b == from ? to : b);
        }
    }
    
    public static void main(String[] args) {
        Reader reader = new StringReader(args[0]);
        TranslateByteReader in = 
                new TranslateByteReader(reader, (byte) 'b', (byte) 'B');
        int b;
        try {
            while ((b = in.read()) != -1) {
                System.out.print((char) b);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
