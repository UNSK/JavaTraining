package ex20_01;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class TranslateByte {
    
    public void translate(InputStream in, OutputStream out, 
            byte from, byte to) throws IOException {
        int b;
        while ((b = in.read()) != -1) {
            out.write(b == from ? to : b);
        }
    }
    
    public static void main(String[] args) {
        InputStream in = System.in;
        OutputStream out = System.out;
        
        TranslateByte translateByte = new TranslateByte();
        try {
            translateByte.translate(in, out, (byte) 'b', (byte) 'B');
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
