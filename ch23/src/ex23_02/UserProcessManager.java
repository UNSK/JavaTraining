package ex23_02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintStream;

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
        InputStreamReader r;
        PrintStream out;
        BufferedReader in;

        
        public Adapter(InputStream in, OutputStream out) {
            this.r   = new InputStreamReader(in);
            this.out   = new PrintStream(out);
            this.in  = new BufferedReader(r);
        }
        
        @Override
        public void run() {
            String line;
            int lineNum = 1;
            try {
                while ((line = in.readLine()) != null) {
                    out.printf("%3d: %s%n", lineNum, line);
                    lineNum++;
                }
                r.close();
                in.close();
                out.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    
    public static void main(String[] args) throws IOException {
        String arg = String.join(" ", args);
        Process proc = userProg(arg);
        System.out.println(proc);
    }
}
