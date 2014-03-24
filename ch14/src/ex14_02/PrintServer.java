package ex14_02;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 14.2 modify PrintServer that only the thread created in constructor can run
 */
public class PrintServer implements Runnable {
    private final Queue<String> requests = new LinkedList<>();
    private final Thread thread;

    public PrintServer() {
        thread = new Thread(this);
        thread.start();
    }
    
    public void print(String job) {
        requests.add(job);
    }
    
    @Override
    public void run() {
        if (Thread.currentThread().equals(thread)) {
            for (;;) {
                if (!requests.isEmpty())
                    realPrint(requests.remove());
            }
        } else {
            throw new IllegalStateException();
        }
    }
    
    private void realPrint(String job) {
        System.out.println(job);
    }

}
