package ex17_03;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;

public class ResourceManagerTest {
    
    private static ResourceManager manager;
    
    @BeforeClass
    public static void setUpBeforeClass() {
        manager = new ResourceManager();
    }

    @Test
    public void useTest() {
        Object object = new Object();
        Resource res = manager.getResource(object);
        res.use(object, null);
        res.release();
        res.use(object, null);
    }

}
