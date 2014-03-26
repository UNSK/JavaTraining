package ex14_09;

/**
 * 14.9 print the hierarchy of threads and thread groups periodically. 
 */
public class ThreadGroupObserver extends Thread {
    
    private final ThreadGroup threadGroup;
    private final long interval;
    /**
     * @param threadGroup be observed
     * @param interval of display in millisecond
     */
    public ThreadGroupObserver(ThreadGroup threadGroup, long interval) {
        this.threadGroup = threadGroup;
        this.interval = interval;
    }
    
    @Override
    public void run() {
        try {
          for(;;) {
              printThreadGroup();
              Thread.sleep(interval);
          }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
    
    private void printThreadGroup() {
        System.out.println(threadGroup);
    }
}
