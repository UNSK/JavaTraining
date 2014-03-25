package ex14_08;

/**
 * 14.8 Try Friendly program. How often does the deadlock happens?
 * If you add Thread.yield, can you change frequency of deadlock?
 */
public class Friendly {
    private Friendly partner;
    private String name;
    
    private static boolean isLocked = false;
    
    public Friendly(String name) {
        this.name = name;
    }
    
    public synchronized void hug() {
        System.out.println(Thread.currentThread().getName() +
                 " in " + name + ".hug() trying to invoke " +
                partner.name + ".hugBack()");
        //Thread.yield();
        if (lock()) {
            try {
                wait();
                unlock();
            } catch (InterruptedException e) { }
        }
        partner.hugBack();
    }
    
    private synchronized void hugBack() {
        System.out.println(Thread.currentThread().getName() +
                " in " + name + ".hugBack()");
        notifyAll();
    }
    
    public void becomeFriend(Friendly partner) {
        this.partner = partner;
    }
    
    /** @return true (false), if you could (not) lock. */ 
    private boolean lock() {
        synchronized (Friendly.class) {
            if (!isLocked) {
                isLocked = true;
                return true;
            }
            return false;
        }
    }
    
    private void unlock() {
        isLocked = false;
    }
    
    public static void main(String[] args) {
        final Friendly jareth = new Friendly("jareth");
        final Friendly cory = new Friendly("cory");
        
        jareth.becomeFriend(cory);
        cory.becomeFriend(jareth);
        
        new Thread(new Runnable() {
            @Override
            public void run() { jareth.hug(); }
        }, "Thread1").start();
        
        new Thread(new Runnable() {
            @Override
            public void run() { cory.hug(); }
        }, "Thread2").start();
    
    }
}
