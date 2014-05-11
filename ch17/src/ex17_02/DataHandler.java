package ex17_02;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.ref.WeakReference;

public class DataHandler {

    private WeakReference<File> lastFile;
    private WeakReference<byte[]> lastData;
    
    byte[] readFile(File file) {
        byte[] data;
        
        if ((lastFile != null) && (file.equals(lastFile.get()))) {
            data = lastData.get();
            if (data != null) {
                return data;
            }
        }
        
        lastFile = new WeakReference<File>(file);
        data = readBytesFromFile(file);
        lastData = new WeakReference<byte[]>(data);
        return data;
    }
    
    private byte[] readBytesFromFile(File file) {
        BufferedInputStream is = null;
        try {
            is = new BufferedInputStream(new FileInputStream(file));
            
            byte[] buf = new byte[(int) file.length()];
            
                is.read(buf);
            
            return buf;
            
        } catch (Exception e) {
            e.printStackTrace();
            throw new AssertionError();
        } finally {
            try {
                if (is != null)
                    is.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        
    }
}
