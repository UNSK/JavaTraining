package ex21_04;


import java.util.ListIterator;
import java.util.NoSuchElementException;


public class ListShortStrings extends ShortStrings implements
        ListIterator<String> {

    private ListIterator<String> strings;
    private final int maxLen;
    private String previousShort;
    
    public ListShortStrings(ListIterator<String> strings, int maxLen) {
        super(strings, maxLen);
        this.strings = strings;
        this.maxLen = maxLen;
        this.previousShort = null;
    }

    @Override
    public boolean hasPrevious() {
        if (previousShort != null) {
            return true;
        }
        while (strings.hasPrevious()) {
            previousShort = strings.previous();
            if (previousShort.length() <= maxLen) {
                return true;
            }
        }
        previousShort = null;
        return false;
    }

    @Override
    public int nextIndex() {
        if (hasNext()) {
            return strings.nextIndex() - 1;
        } else {
            while (strings.hasNext()) {
                strings.next();
            }
            return strings.nextIndex();
        }
    }

    @Override
    public String previous() {
        if (previousShort == null && !hasPrevious()) {
            throw new NoSuchElementException();
        }
        String n = previousShort;
        previousShort = null;
        return n;
    }

    @Override
    public int previousIndex() {
        return (hasPrevious() ? strings.previousIndex() + 1 : -1);
    }

    @Override
    public void set(String arg0) {
        throw new UnsupportedOperationException();
    }
    
    @Override
    public void add(String arg0) {
        throw new UnsupportedOperationException();
    }
}
