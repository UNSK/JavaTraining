package ex21_04;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.List;
import java.util.ListIterator;
import java.util.NoSuchElementException;

import org.junit.Before;
import org.junit.Test;

public class ListShortStringsTest {
    private static final String str = 
            "Alice was beginning to get very tired of sitting by her sister on the bank";
    private static final String[] strs = str.split(" ");
        
    ListIterator<String> strings;
    private ListShortStrings shortStrings;

    @Before
    public void setUp() throws Exception {
        List<String> list = Arrays.asList(strs);
        strings = list.listIterator();
    }

    @Test
    public void hasNextTest() {
        shortStrings = new ListShortStrings(strings, 3);
        assertTrue(shortStrings.hasNext());
        assertTrue(shortStrings.hasNext());
        
        shortStrings = new ListShortStrings(strings, 1);
        assertFalse(shortStrings.hasNext());
    }
    
    @Test
    public void nextTest() {
        shortStrings = new ListShortStrings(strings, 2);
        assertThat(shortStrings.next(), is("to"));
        
        try {
            for (int i = 0; i < 100; i++) shortStrings.next();
            fail();
        } catch (NoSuchElementException e) {
            // ok
        }
    }
    
    @Test(expected = UnsupportedOperationException.class)
    public void removeTest() {
        shortStrings = new ListShortStrings(strings, 5);
        shortStrings.remove();
    }

    @Test
    public void hasPreviousTest() {
        shortStrings = new ListShortStrings(strings, 3);
        assertFalse(shortStrings.hasPrevious());
        
        while(shortStrings.hasNext()) {
            shortStrings.next();
        }
        
        assertTrue(shortStrings.hasPrevious());
    }
    
    @Test
    public void previousTest() {
        shortStrings = new ListShortStrings(strings, 2);
        try {
            shortStrings.previous();
            fail();
        } catch (NoSuchElementException e) {
            //ok
        }
        
        assertThat(shortStrings.next(), is("to"));
        assertThat(shortStrings.previous(), is("to"));
        
        while(shortStrings.hasNext()) {
            shortStrings.next();
        }
        
        assertThat(shortStrings.previous(), is("on"));
    }
    
    @Test
    public void nextIndexTest() {
        shortStrings = new ListShortStrings(strings, 2);
        assertThat(shortStrings.nextIndex(), is(3)); //index of "to"
        while(shortStrings.hasNext()) {
            shortStrings.next();
        }
        //return list size if dosen't have next
        assertThat(shortStrings.nextIndex(), is(strs.length));
    }
    
    @Test
    public void previousIndexTest() {
        shortStrings = new ListShortStrings(strings, 2);
        // return -1 if doesn't have previous
        assertThat(shortStrings.previousIndex(), is(-1));
        
        while(shortStrings.hasNext()) {
            shortStrings.next();
        }
        // index of "on"
        assertThat(shortStrings.previousIndex(), is(12));
        
    }
    
    @Test(expected = UnsupportedOperationException.class)
    public void setTest() {
        shortStrings = new ListShortStrings(strings, 2);
        shortStrings.set("fail");
    }
    
    @Test(expected = UnsupportedOperationException.class)
    public void addTest() {
        shortStrings = new ListShortStrings(strings, 3);
        shortStrings.add("fail");
    }
}
