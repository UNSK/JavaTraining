package ex14_03;

/**
 * 14.3 hold current value, add to / print the value
 */
public class Counter implements Runnable {
    private int value = 0;
    private long delay = 100L;
    
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

    private synchronized void countUp() {
        System.out.println(++value);
    }
    
    public static void main(String[] args) {
        Counter counter = new Counter();
        new Thread(counter).start();
        new Thread(counter).start();
        new Thread(counter).start();
    }
}
