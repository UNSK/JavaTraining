package ex22_13;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;


public class AttributedImpl implements Attributed, Iterable<Attr> {

    protected Map<String, Attr> attrMap = new HashMap<>();
    
    @Override
    public void add(Attr newAttr) {
        attrMap.put(newAttr.getName(), newAttr);
    }

    @Override
    public Attr find(String attrName) {
        return attrMap.get(attrName);
    }

    @Override
    public Attr remove(String attrName) {
        Attr retAttr = attrMap.remove(attrName);
        return retAttr;
    }

    @Override
    public Iterator<Attr> attrs() {
        return attrMap.values().iterator();
    }
    
    @Override
    public Iterator<Attr> iterator() {
        return attrs();
    }

}
