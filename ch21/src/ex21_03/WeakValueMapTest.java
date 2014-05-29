package ex21_03;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import org.junit.Test;

public class WeakValueMapTest {

    @Test
    public void test() {
        WeakValueMap<String, Integer> map = new WeakValueMap<>();
        Integer i = new Integer(10);
        map.put("test", i);
        assertThat(map.get("test"), is(10));
        i = null;
        System.gc();
        assertNull(map.get("test"));
    }

}
