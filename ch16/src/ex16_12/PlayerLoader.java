package ex16_12;

import java.io.File;
import java.io.FileFilter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

public class PlayerLoader extends ClassLoader {
    @Override
    public Class<?> findClass(String name) throws ClassNotFoundException {
        try {
            byte[] buf = bytesForClass(name);
            return defineClass(name, buf, 0, buf.length);
        } catch (IOException e) {
            throw new ClassNotFoundException(e.toString());
        }
    }

    /**
     * @param name
     * @return
     */
    protected byte[] bytesForClass(String name) 
            throws IOException, ClassNotFoundException {
        FileInputStream in = null;
        try {
            in = streamFor(name + ".class");
            int length = in.available();
            if (length == 0) {
                throw new ClassNotFoundException(name);
            }
            byte[] buf = new byte[length];
            in.read(buf);
            return buf;
        } finally {
            if (in != null) {
                in.close();
            }
        }
    }

    /**
     * @param string
     * @return
     */
    private FileInputStream streamFor(String string) {
        try {
            string = "../ch16/bin/ex16_12/players/" + string;
            FileInputStream in = new FileInputStream(string);
            return in;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }
    
    /**
     * @param name the resource name
     * @return resource URL or null if not found
     */
    @Override
    public URL findResource(String name) {
        File f = FileFor(name);
        if (!f.exists()) {
            return null;
        }
        try {
            return f.toURI().toURL();
        } catch (MalformedURLException e) {
            throw new AssertionError();
        }
    }

    /**
     * @param name the resource name
     * @return file for the resource name
     */
    private File FileFor(String name) {
        File f = new File(name);
        return f;
    }
}
