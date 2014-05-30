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
        private int off;    // offset from head of list
        private int array;  // index of arrays processing currently
        private int pos;    // position in current array

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
        private int off;    // offset from head of list
        private int array;  // index of arrays processing currently
        private int pos;    // position in current array
        
        public ABLListIterator() {
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
            // TODO Auto-generated method stub
            return false;
        }

        @Override
        public int nextIndex() {
            // TODO Auto-generated method stub
            return 0;
        }

        @Override
        public E previous() {
            // TODO Auto-generated method stub
            return null;
        }

        @Override
        public int previousIndex() {
            // TODO Auto-generated method stub
            return 0;
        }

        @Override
        public void set(E arg0) {
            // TODO Auto-generated method stub

        }
    }
}
