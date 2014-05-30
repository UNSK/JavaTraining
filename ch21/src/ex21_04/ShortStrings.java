package ex21_04;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class ShortStrings implements Iterator<String> {

    /** original string */
    private Iterator<String> strings;
    /** null if next is not known */
    private String nextShort;
    /** only return string shorter than */
    private final int maxLen;
    
    public ShortStrings(Iterator<String> strings, int maxLen) {
        this.strings = strings;
        this.maxLen = maxLen;
        nextShort = null;
    }
    
    @Override
    public boolean hasNext() {
        if (nextShort != null) { // already found
            return true;
        }
        while (strings.hasNext()) {
            nextShort = strings.next();
            if (nextShort.length() <= maxLen) {
                return true;
            }
        }
        nextShort = null; // not found
        return false;
    }

    @Override
    public String next() {
        if (nextShort == null && !hasNext()) {
            throw new NoSuchElementException();
        }
        String n = nextShort; // remember
        nextShort = null; // consume
        return n; // return nextShort
    }
    
    public void remove() {
        throw new UnsupportedOperationException();
    }

}
