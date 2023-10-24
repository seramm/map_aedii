/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package map;

import java.util.Collection;
import java.util.List;
import java.util.LinkedList;
import java.util.Set;

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

    public int size() {
        return numElem;
    }

    public boolean isEmpty() {
        return numElem == 0;
    }

    public V get(K key) {
        for (Par<K, V> i : map[functionHash(key)]) {
            if (key.equals(i.getKey())) {
                return i.getValue();
            }
        }
        return null;
    }

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

    public V remove(K key) {

    }

    public Set<K> keySet() {

    }

    public Collection<V> values() {

    }

    public boolean containsKey(K key) {

    }

    public boolean containsValue(V value) {

    }

    public List<K> getKey(V value) {

    }
}
