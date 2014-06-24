package ex23_01;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class UserProcessManager {
    public static Process userProg(String cmd) throws IOException {
        Process proc = Runtime.getRuntime().exec(cmd);
        plugTogether(System.in,  proc.getOutputStream());
        plugTogether(System.out, proc.getInputStream());
        plugTogether(System.err, proc.getErrorStream());
        return proc;
    }
    
    private static void plugTogether(InputStream in, OutputStream out) {
        new Thread(new Adapter(in, out)).start();
    }
    
    private static void plugTogether(OutputStream out, InputStream in) {
        new Thread(new Adapter(in, out)).start();
    }
    
    private static class Adapter implements Runnable {
        InputStream  in;
        OutputStream out;
        
        public Adapter(InputStream in, OutputStream out) {
            this.in  = in;
            this.out = out;
        }
        
        @Override
        public void run() {
            int c;
            try {
                while ((c = in.read()) != -1) {
                    out.write(c);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }    
    }
    
    public static void main(String[] args) throws IOException {
        Process proc = userProg("ls -la /");
        System.out.println(proc);
    }
}
