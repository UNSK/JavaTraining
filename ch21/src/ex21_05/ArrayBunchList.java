package ex21_05;

import java.util.AbstractList;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.NoSuchElementException;

/**
 * a bunch of arrays without copying arrays
 * @param <E> the type of arrays element 
 */
public class ArrayBunchList<E> extends AbstractList<E> {

    private final E[][] arrays;
    private final int size;
    
    public ArrayBunchList(E[][] arrays) {
        this.arrays = arrays;
        int s = 0;
        for(E[] array : arrays) {
            s += array.length;
        }
        size = s;
    }
    
    @Override
    public int size() {
        return size;
    }
    
    @Override
    public E get(int index) {
        int off = 0; // offsets from head of collection
        for (int i = 0; i < arrays.length; i++) {
            if (index < off + arrays[i].length) {
                return arrays[i][index - off];
            }
            off += arrays[i].length;
        }
        throw new ArrayIndexOutOfBoundsException();
    }

    @Override
    public E set(int index, E value) {
        int off = 0; // offsets from head of collection
        for (int i = 0; i < arrays.length; i++) {
            if (index < off + arrays[i].length) {
                E ret = arrays[i][index - off];
                arrays[i][index - off] = value;
                return ret;
            }
            off += arrays[i].length;
        }
        throw new ArrayIndexOutOfBoundsException();
    }
    
    @Override
    public Iterator<E> iterator() {
        return new ABLIterator();
    }
    
    @Override
    public ListIterator<E> listIterator() {
        return new ABLListIterator();
    }
    
    @Override
    public ListIterator<E> listIterator(int index) {
        return new ABLListIterator(index);
    }
    
    private class ABLIterator implements Iterator<E> {
        protected int off;    // offset from head of list
        protected int array;  // index of arrays processing currently
        protected int pos;    // position in current array

        ABLIterator() {
            off = 0;
            array = 0;
            pos = 0;
            // skip empty array
            for (array = 0; array < arrays.length; array++) {
                if (arrays[array].length > 0) {
                    break;
                }
            }
        }
        
        @Override
        public boolean hasNext() {
            return off + pos < size;
        }

        @Override
        public E next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            E ret = arrays[array][pos++];
            // to next element
            while (pos >= arrays[array].length) {
                off += arrays[array++].length;
                pos = 0;
                if (array >= arrays.length) {
                    break;
                }
            }
            return ret;
        }
        
        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }
    
    private class ABLListIterator extends ABLIterator implements ListIterator<E> {
    	
    	private boolean calledNext;
    	private boolean calledPrevious;
        
        public ABLListIterator() {
            off = 0;
            array = 0;
            pos = 0;
            calledNext = false;
            calledPrevious = false;
            // skip empty array
            for (array = 0; array < arrays.length; array++) {
                if (arrays[array].length > 0) {
                    break;
                }
            }
        }
        
        public ABLListIterator(int index) {
            this();
            while (nextIndex() != index) {
                super.next();
            }
        }

        @Override
        public void add(E arg0) {
            throw new UnsupportedOperationException();
        }

        @Override
        public boolean hasPrevious() {
        	return off + pos > 0;
        }

        @Override
        public int nextIndex() {
        	return off + pos;
        }

        @Override
        public E previous() {
        	if (!hasPrevious()) {
        		throw new NoSuchElementException();
        	}
        	E ret = arrays[array][--pos];
        	while (pos == 0) {
        		if (array  == 0) {
        			break;
        		}
        		off -= arrays[array--].length;
        	}
        	calledPrevious = true;
        	return ret;
        }
        
        @Override
        public E next() {
        	calledNext = true;
        	return super.next();
        }

        @Override
        public int previousIndex() {
        	return off + pos - 1;
        }

        @Override
        public void set(E value) {
        	if (calledNext && calledPrevious) {
        		throw new AssertionError();
        	}
        	
        	int index;
            if (calledNext) {
            	index = previousIndex();
            	calledNext = false;
            } else if (calledPrevious) {
            	index = nextIndex();
            	calledPrevious = false;
            } else {
            	throw new IllegalStateException();
            }
            
            ArrayBunchList.this.set(index, value);
        }
    }
}
