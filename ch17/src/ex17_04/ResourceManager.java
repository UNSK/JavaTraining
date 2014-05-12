package ex17_04;

import java.lang.ref.PhantomReference;
import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.util.HashMap;
import java.util.Map;

public final class ResourceManager {
    final ReferenceQueue<Object> queue;
    final Map<Reference<?>, Resource> refs;
    final Thread reaper;
    boolean shutdown = false;
    
    public ResourceManager() {
        queue = new ReferenceQueue<>();
        refs = new HashMap<>();
        reaper = new ReaperThread();
        reaper.start();
        
        // initialize a resource...
    }
    
    public synchronized void shutdown() {
        if (!shutdown) {
            shutdown = true;
            reaper.interrupt();
        }
    }
    
    public synchronized Resource getResource(Object key) {
        if (shutdown) {
            throw new IllegalStateException();
        }
        Resource res = new ResourceImpl(key);
        Reference<?> ref = new PhantomReference<Object>(key, queue);
        refs.put(ref, res);
        return res;
    }
    
    class ReaperThread extends Thread {
        boolean isInterrupted = false;
        @Override
        public void run() {
            while (true) {
                try {
                    Reference<?> ref = queue.remove();
                    Resource res = null;
                    synchronized (ResourceManager.this) {
                        res = refs.get(ref);
                        refs.remove(ref);
                    }
                    res.release();
                    ref.clear();
                    if (isInterrupted && refs.isEmpty()) {
                        break;
                    }
                } catch (InterruptedException ex) {
                    isInterrupted = true;
                }
            }
        }
    }
}
