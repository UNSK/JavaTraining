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
              System.out.println("** print threads begin **");
              printThreadGroup(threadGroup);
              System.out.println("** end **");
              Thread.sleep(interval);
          }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
    
    private void printThreadGroup(ThreadGroup threadGroup) {
        Thread[] threads = new Thread[threadGroup.activeCount()];
        ThreadGroup[] groups = new ThreadGroup[threadGroup.activeGroupCount()];
        
        System.out.printf("< %s >%n", threadGroup.getName());
        threadGroup.enumerate(threads, false);
        for (Thread t : threads) {
            if (t != null)
                System.out.println("\t" + t.getName());
        }
        threadGroup.enumerate(groups, false);
        for (ThreadGroup tg : groups) {
            if(tg != null)
                printThreadGroup(tg);
        }
    }
    
    public static void main(String[] args) throws InterruptedException {
        
        class Sleep implements Runnable {
            private long lifetime;
            Sleep(long lifetime) {
                this.lifetime = lifetime;
            }
            
            @Override
            public void run() {
                try {
                    Thread.sleep(lifetime);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        }
        
        ThreadGroup root = new ThreadGroup("ROOT");
        ThreadGroup alpha = new ThreadGroup(root, "Alpha");
        ThreadGroup bravo = new ThreadGroup(root, "Bravo");
        ThreadGroup bravo1 = new ThreadGroup(bravo, "Bravo-1");
        ThreadGroup bravo2 = new ThreadGroup(bravo, "Bravo-2");
        
        ThreadGroupObserver observer = new ThreadGroupObserver(root, 2000);
        observer.start();
        
        for (;;) {
            new Thread(root, new Sleep(3000), "root-a").start();
            new Thread(root, new Sleep(5000), "root-b").start();
            new Thread(alpha, new Sleep(2000), "alpha-a").start();
            new Thread(alpha, new Sleep(4000), "alpha-b").start();
            new Thread(alpha, new Sleep(1000), "alpha-c").start();
            new Thread(bravo, new Sleep(9000), "bravo-a").start();
            new Thread(bravo, new Sleep(2000), "bravo-b").start();
            new Thread(bravo1, new Sleep(1000), "bravo-1-a").start();
            new Thread(bravo2, new Sleep(5000), "bravo-2-a").start();
            new Thread(bravo2, new Sleep(3000), "bravo-2-b").start();
            new Thread(bravo2, new Sleep(6000), "bravo-2-c").start();
            Thread.sleep(5500);;
        }
    }
}
