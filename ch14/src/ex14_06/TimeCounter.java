package ex14_06;

/**
 * 14.6 Write a program that prints a message thread and prints the elapsed time thread.
 * the message printing thread be notified by the time printing thread as each second.
 */
public class TimeCounter {
    static int elapsedSec = 0;
    
    public void createMessageThread(final String message, final int intervalSec) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    for (;;) {
                        printMessage(message, intervalSec);
                    }
                } catch (InterruptedException e) {
                    return;
                }
            }
        }).start();
    }
    
    public void createTimerThread() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    for (;;) {
                        printElapsedTimeSec();
                    }
                } catch (InterruptedException e) {
                    return;
                }
            }
        }).start();
    }
    
    private synchronized void printMessage(String message, int interval) throws InterruptedException {
        wait();
        if (elapsedSec % interval == 0) {
            System.out.println(message);
        }
    }
    
    private synchronized void printElapsedTimeSec() throws InterruptedException {
        wait(1000L);
        System.out.println("Elapsed " + ++elapsedSec + " seconds.");
        notifyAll();
    }
    
    public static void main(String[] args) {
        TimeCounter timer = new TimeCounter();
        timer.createMessageThread("** fifteen seconds passed. **", 15);
        timer.createMessageThread("* seven seconds passed. *", 7);
        timer.createTimerThread();
    }
}
