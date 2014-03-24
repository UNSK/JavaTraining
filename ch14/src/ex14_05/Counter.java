package ex14_05;

/**
 * 14.3 hold current value, add to / print the value
 * 14.4 change the value to static field
 * 14.5 safely decrement the value without using synchronized method
 */
public class Counter implements Runnable {
    private static int value = 10000;
    private long delay = 0L;
    
    @Override
    public void run() {
        try {
            for (;;) {
                countDown();
                Thread.sleep(delay);
            }
        } catch (InterruptedException e) {
            return;
        }
    }

    private static synchronized void countUp() {
        System.out.println(++value);
    }
    
    private void countDown() {
        synchronized (Counter.class) {
            if (value != 0) {
                System.out.println(--value);
            } else {
                Thread.currentThread().interrupt();
            }
        }
    }
    
    public static void main(String[] args) {
        Counter counter = new Counter();
        new Thread(counter).start();
        new Thread(counter).start();
        new Thread(counter).start();
    }
}
