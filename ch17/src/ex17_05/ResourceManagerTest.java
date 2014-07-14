package ex17_05;

import static org.junit.Assert.*;

import java.lang.ref.Reference;
import java.util.Map;

import org.junit.BeforeClass;
import org.junit.Test;

public class ResourceManagerTest {
    
    private static ResourceManager manager;
    
    @BeforeClass
    public static void setUpBeforeClass() {
        manager = new ResourceManager();
    }

    @Test
    public void useTest() throws InterruptedException {
        Object object = new Object();
        Resource res = manager.getResource(object);
        res.use(object, null);
        //res.release();
        object = null; 
        System.gc();
        manager.shutdown();
        
        assertTrue(manager.getRefs().isEmpty());
      }

}
