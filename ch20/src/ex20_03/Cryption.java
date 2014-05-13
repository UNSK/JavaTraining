package ex20_03;

import java.io.IOException;

public class Cryption {

    private static final byte[] KEY = { 0xc, 0xa, 0xf, 0xe, 0xb, 0xa, 0xb, 0xe };

    public static void main(String[] args) throws IOException {
        EncryptInputStream en = new EncryptInputStream(System.in, KEY);
        DecryptOutputStream de = new DecryptOutputStream(System.out, KEY);
        byte[] buf = new byte[20];
        try {
            en.read(buf);
            System.out.print("crypt: ");
            de.write(buf);
            System.out.println();
            System.out.print("plain: ");
            for (byte b : buf)
                System.out.print((char) b);
        } finally {
            en.close();
            de.close();
        }
    }

}
