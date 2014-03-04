package ex11_03;

import static org.junit.Assert.*;

import java.util.Iterator;

import org.junit.Test;

public class AttributedTest {

    @Test
    public void test() {
        AttributedImpl attributed = new AttributedImpl();
        Attr<Integer> intAttr = new Attr<>("one", 1);
        Attr<Double> doubleAttr = new Attr<Double>("pi", 3.1415);
        attributed.add(intAttr);
        attributed.add(doubleAttr);
        
        assertEquals(intAttr, attributed.find("one"));
        assertEquals(doubleAttr, attributed.find("pi"));
        
        System.out.println(attributed.find("pi").getValue());
        
        Iterator<Attr<?>> iterator = attributed.iterator();
       
        assertEquals(intAttr, iterator.next());
        
        attributed.remove("one");
        iterator = attributed.iterator();
        assertEquals(doubleAttr, iterator.next());
    }

}
