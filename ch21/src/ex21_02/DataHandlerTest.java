package ex21_02;

import static org.junit.Assert.*;

import java.io.File;
import java.util.Map;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class DataHandlerTest {
    Map<File, byte[]> cacheMap;
    DataHandler dataHandler;

    @Before
    public void setUp() { 
        dataHandler = new DataHandler();
        cacheMap = dataHandler.getDataCache();
    }
    
    @Test
    public void test() {
        File testFile = new File("../ch21/src/ex21_02/test");
        dataHandler.readFile(testFile);
        assertTrue(cacheMap.containsKey(testFile));
        testFile = null;
        System.out.println(cacheMap);
        System.gc();
        testFile = new File("../ch21/src/ex21_02/test");
        System.out.println(cacheMap);
        assertFalse(cacheMap.containsKey(testFile));
    }
}
