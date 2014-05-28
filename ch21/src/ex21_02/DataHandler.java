package ex21_02;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Map;
import java.util.WeakHashMap;

public class DataHandler {
    
    private Map<File, byte[]> dataCache = new WeakHashMap<>();
    
    byte[] readFile(File file) {
        byte[] data;
        
        if (dataCache.containsKey(file)) {
            data = dataCache.get(file);
            return data;
        } else {        
            data = readBytesFromFile(file);
            dataCache.put(file, data);
            return data;
        }
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
    
    public Map<File, byte[]> getDataCache() {
        return dataCache;
    }
}
