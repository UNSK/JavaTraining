package ex17_05;

import java.lang.ref.PhantomReference;
import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.util.HashMap;
import java.util.Map;

public final class ResourceManager {
    private final ReferenceQueue<Object> queue;
    private final Map<Reference<?>, Resource> refs;
    private boolean shutdown = false;
    
    public ResourceManager() {
        queue = new ReferenceQueue<>();
        refs = new HashMap<>();
        
        // initialize a resource...
    }
    
    public synchronized void shutdown() {
        if (shutdown) {
            throw new IllegalStateException();
        }
        shutdown = true;
        while (!refs.isEmpty()) {
            Reference<?> ref = null;
            while ((ref = queue.poll()) == null); //block until reference enqueued
            Resource res = null;
            synchronized (this) {
                res = refs.get(ref);
                refs.remove(ref);
            }
            res.release();
            ref.clear();
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
    
    /**
     * @return the queue
     */
    public ReferenceQueue<Object> getQueue() {
        return queue;
    }

    /**
     * @return the refs
     */
    public Map<Reference<?>, Resource> getRefs() {
        return refs;
    }

}
