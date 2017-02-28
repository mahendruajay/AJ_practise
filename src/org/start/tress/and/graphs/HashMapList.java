package org.start.tress.and.graphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class HashMapList<T, E> {

    private Map<T, List<E>> mapList = new HashMap<>();

    public void put(T key, E item) {
        if (!mapList.containsKey(key)) {
            mapList.put(key, new ArrayList<E>());
        }
        mapList.get(key).add(item);
    }

    public void put(T key, List<E> items) {
        mapList.put(key, items);
    }

    public List<E> get(T key) {
        return mapList.get(key);
    }

    public boolean contains(T key) {
        return mapList.containsKey(key);
    }

    public boolean containsKeyValue(T key, E item) {
        if (!mapList.containsKey(key)) {
            return false;
        }
        List<E> list = mapList.get(key);
        if (null == list) {
            return false;
        }
        return list.contains(item);
    }

    /* Get the list of keys. */
    public Set<T> keySet() {
        return mapList.keySet();
    }

    @Override
    public String toString() {
        return mapList.toString();
    }

}
