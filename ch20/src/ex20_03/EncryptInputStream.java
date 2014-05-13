package ex20_03;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;


public class EncryptInputStream extends FilterInputStream {
    
    private final byte[] key;

    /**
     * @param in an InputStream
     * @param key the encyrption key
     */
    protected EncryptInputStream(InputStream in, byte[] key) {
        super(in);
        this.key = key;
    }
    
    @Override
    /** @Deprecated use {@link read(byte[], int, int)} instead. */
    public int read() throws IOException {
        return super.read();
    }

    @Override
    public int read(byte[] buf, int offset, int count) throws IOException {
        int nread = super.read(buf, offset, count);
        int last = offset + nread;
        for (int i = offset; i < last; i++) {
            int j = i % key.length;
            buf[i] ^= key[j];
        }
        return nread;
    }
    
    
}
