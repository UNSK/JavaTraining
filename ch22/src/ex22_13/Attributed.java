package ex22_13;

import java.util.Iterator;

public interface Attributed extends Iterable<Attr>{
    void add(Attr newAttr);
    Attr find(String attrName);
    Attr remove(String attrName);
    Iterator<Attr> attrs();
}
