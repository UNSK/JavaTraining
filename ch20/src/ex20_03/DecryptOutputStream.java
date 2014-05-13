package ex20_03;

import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class DecryptOutputStream extends FilterOutputStream {

    private final byte[] key;
    
    /**
     * @param out an OutputStream
     * @param key the decryption key
     */
    public DecryptOutputStream(OutputStream out, byte[] key) {
        super(out);
        this.key = key;
    }

    @Override
    public void write(byte[] buf, int offset, int count) throws IOException {
        super.write(buf, offset, count);
        int end = offset + count;
        for (int i = offset; i < end; i++) {
            int j = i % key.length;
            buf[i] ^= key[j]; 
        }
    }
    
}
