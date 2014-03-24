package ex14_04;

/**
 * 14.3 hold current value, add to / print the value
 * 14.4 change the value to static field
 */
public class Counter implements Runnable {
    private static int value = 0;
    private long delay = 0L;
    
    @Override
    public void run() {
        try {
            for (;;) {
                countUp();
                Thread.sleep(delay);
            }
        } catch (InterruptedException e) {
            return;
        }
    }

    private static synchronized void countUp() {
        System.out.println(++value);
    }
    
    public static void main(String[] args) {
        Counter counter = new Counter();
        new Thread(counter).start();
        new Thread(counter).start();
        new Thread(counter).start();
    }
}
