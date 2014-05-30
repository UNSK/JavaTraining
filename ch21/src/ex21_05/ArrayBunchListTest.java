package ex21_05;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import java.util.List;
import java.util.ListIterator;
import java.util.NoSuchElementException;

import org.junit.Before;
import org.junit.Test;

public class ArrayBunchListTest {
    List<Integer> abl;
    ListIterator<Integer> ite;

    @Before
    public void setUp() throws Exception {
        Integer[][] arrays = {{0, 1, 2, 3}, { }, {4, 5}, {6, 7, 8}, {9}};
        abl = new ArrayBunchList<>(arrays);
    }

    @Test
    public void indexConstructorTest() {
        ite = abl.listIterator(2);
        assertThat(ite.next(), is(2));
    }
    
    @Test
    public void previousTest() {
        ite = abl.listIterator(2);
        assertThat(ite.next(), is(2));
        assertThat(ite.previous(), is(2));
    }
    
    @Test(expected = NoSuchElementException.class)
    public void previousFailTest() {
        ite = abl.listIterator();
        ite.previous();
    }
    
    @Test
    public void hasPreviousTest() {
        ite = abl.listIterator();
        assertFalse(ite.hasPrevious());
        ite.next();
        assertTrue(ite.hasPrevious());
    }

    @Test
    public void nextIndexTest() {
        ite = abl.listIterator();
        assertThat(ite.nextIndex(), is(0));
        ite.next();
        assertThat(ite.nextIndex(), is(1));
        while (ite.hasNext()) ite.next();
        assertThat(ite.nextIndex(), is(abl.size()));
    }
    
    @Test
    public void previousIndexTest() {
        ite = abl.listIterator();
        assertThat(ite.previousIndex(), is(-1));
        ite.next();
        assertThat(ite.previousIndex(), is(0));
    }
    
    @Test(expected = IllegalStateException.class)
    public void setFailTest() {
        ite = abl.listIterator();
        ite.set(1);
    }
    
    @Test
    public void setTest() {
        ite = abl.listIterator();
        ite.next();
        ite.set(100);
        assertThat(ite.previous(), is(100));
        ite.set(777);
        assertThat(ite.next(), is(777));
    }
}
