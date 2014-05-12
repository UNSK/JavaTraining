package ex17_03;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;


public class ResourceImpl implements Resource {
    int keyHash;
    boolean needsRelease = false;
    BufferedReader reader;
    private static final String FILE_NAME = "../ch17/src/ex17_03/test.txt";
    
    public ResourceImpl(Object key) {
        keyHash = System.identityHashCode(key);
        
        // set up external resource
        File file = new File(FILE_NAME);
        try {
            reader = new BufferedReader(new FileReader(file));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        
        needsRelease = true;
    }
    
    @Override
    public void use(Object key, Object... args) {
        if (System.identityHashCode(key) != keyHash) {
            throw new IllegalArgumentException("wrong key");
        }

        try {
            System.out.println(reader.readLine());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public synchronized void release() {
        if (needsRelease) {
            needsRelease = false;
            
            // release the resource
            try {
                if (reader != null)
                    reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
