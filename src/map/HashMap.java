/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package map;

import java.util.Collection;
import java.util.List;
import java.util.LinkedList;
import java.util.Set;
import java.util.HashSet;

public class HashMap<K, V> implements Map<K, V> {

    private List<Par<K, V>>[] map;
    private int numElem;

    public void HashMap(int size_array) throws IllegalArgumentException {
        if (size_array < 0) {
            throw new IllegalArgumentException("HashMap: size is negative");
        }
        map = new List[size_array];
        numElem = 0;
        for (int i = 0; i < size_array; i++) {
            map[i] = new LinkedList<>();
        }
    }

    private int functionHash(K key) {
        return Math.abs(key.hashCode()) % map.length;
    }

    @Override
    public int size() {
        return numElem;
    }

    @Override
    public boolean isEmpty() {
        return numElem == 0;
    }

    @Override
    public V get(K key) {
        for (Par<K, V> i : map[functionHash(key)]) {
            if (key.equals(i.getKey())) {
                return i.getValue();
            }
        }
        return null;
    }

    @Override
    public V put(K key, V value) {
        V existing = get(key);
        if (existing != null) {
            int index = map[functionHash(key)].indexOf(new Par<>(key, value));
            map[functionHash(key)].set(index, new Par<>(key, value));
        } else {
            map[functionHash(key)].add(new Par<>(key, value));
            numElem++;
        }
        return existing;
    }

    @Override
    public V remove(K key) {
        V existing = get(key);
        if (existing != null) {
            int index = map[functionHash(key)].indexOf(new Par<>(key, existing));
            map[functionHash(key)].remove(index);
        }
        return existing;
    }

    @Override
    public Set<K> keySet() {
        Set<K> keys = new HashSet<>();
        for (int i = 0; keys.size() < numElem; i++) {
            for (int j = 0; j < map[i].size() && keys.size() < numElem; j++) {
                keys.add(map[i].get(j).getKey());
            }
        }
        return keys;
    }

    @Override
    public Collection<V> values() {
        Set<V> values = new HashSet<>();
        for (List<Par<K, V>> map_aux : map) {
            for (Par<K, V> par_aux : map_aux) {
                values.add(par_aux.getValue());
            }
        }
        return values;
    }

    @Override
    public boolean containsKey(K key) {
        if (numElem == 0) {
            return false;
        }
        for (List<Par<K, V>> map_aux : map) {
            for (Par<K, V> par_aux : map_aux) {
                if (par_aux.getKey() == key) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean containsValue(V value) {
        if (numElem == 0) {
            return false;
        }
        for (List<Par<K, V>> map_aux : map) {
            for (Par<K, V> par_aux : map_aux) {
                if (par_aux.getKey() == key) {
                    return true;
                }
            }
        }
        return false;
    }

    public List<K> getKey(V value) {

    }
}
