package ex22_04;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Observable;

public class AttributedImpl extends Observable implements Attributed, Iterable<Attr> {

    protected Map<String, Attr> attrMap = new HashMap<>();
    
    @Override
    public void add(Attr newAttr) {
        attrMap.put(newAttr.getName(), newAttr);
        setChanged();
        notifyObservers(newAttr);
    }

    @Override
    public Attr find(String attrName) {
        return attrMap.get(attrName);
    }

    @Override
    public Attr remove(String attrName) {
        Attr retAttr = attrMap.remove(attrName);
        setChanged();
        notifyObservers(retAttr);
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
