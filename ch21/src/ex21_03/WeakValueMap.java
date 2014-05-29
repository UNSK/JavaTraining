package ex21_03;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;


public class WeakValueMap<K, V> implements Map<K, V> {

    /** Delegated map */
    private HashMap<K, WeakReference<V>> map = new HashMap<>();
    
    @Override
    public void clear() {
        map.clear();
    }
    @Override
    public boolean containsKey(Object key) {
        return map.containsKey(key);
    }
    @Override
    public boolean containsValue(Object value) {
        return map.containsValue(value);
    }
    @Override
    public Set<Map.Entry<K, V>> entrySet() {
        Map<K, V> retMap = new HashMap<>();
        map.forEach((k, v) -> {
            retMap.put(k, v.get());
        });
        return retMap.entrySet();
    }
    @Override
    public V get(Object key) {
        return map.get(key).get();
    }
    @Override
    public boolean isEmpty() {
        return map.isEmpty();
    }
    @Override
    public Set<K> keySet() {
        Set<K> set = new HashSet<>();
        map.forEach((k,v) -> {
            set.add(k);
        });
        return set;
    }
    @Override
    public V put(K key, V value) {
       WeakReference<V> weakVal = map.put(key, new WeakReference<>(value));
       return weakVal == null ? null : weakVal.get() ;
    }
    @Override
    public void putAll(Map<? extends K, ? extends V> otherMap) {
        otherMap.forEach((k, v) -> {
            map.put(k, new WeakReference<>(v));
        });
    }
    @Override
    public V remove(Object key) {
        WeakReference<V> weakVal = map.remove(key);
        return weakVal == null ? null : weakVal.get();
    }
    @Override
    public int size() {
        return map.size();
    }
    @Override
    public Collection<V> values() {
        Collection<V> collection = new ArrayList<>();
        map.forEach((k, v) -> {
            collection.add(v.get());
        });
        return collection;
    }
}
