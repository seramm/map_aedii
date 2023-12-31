package map;

import java.util.Collection;
import java.util.List;
import java.util.LinkedList;
import java.util.Set;
import java.util.HashSet;

public class HashMap<K, V> implements Map<K, V> {

    private List<Par<K, V>>[] map;
    private int numElem;

    public HashMap(int size_array) throws IllegalArgumentException {
        if (size_array < 0) {
            throw new IllegalArgumentException("HashMap: size is negative");
        }
        map = new List[size_array];
        numElem = 0;
        for (int i = 0; i < size_array; i++) {
            map[i] = new LinkedList<>();
        }
    }

    public HashMap() {
        this(10);
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
        int index = functionHash(key);
        if (existing != null) {
            int indexPar = 0;
            while (map[index].get(indexPar).getKey() != key) {
                indexPar++;
            }
            map[functionHash(key)].set(indexPar, new Par<>(key, value));
        } else {
            map[index].add(new Par<>(key, value));
            numElem++;
        }
        return existing;
    }

    @Override
    public V remove(K key) {
        V existing = get(key);
        if (existing != null) {
            int index = functionHash(key);
            int indexPar = 0;
            while (map[index].get(indexPar).getKey() != key) {
                indexPar++;
            }
            map[index].remove(indexPar);
            numElem--;
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
    public List<V> values() {
        List<V> values = new LinkedList<>();
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
                if (par_aux.getKey().equals(key)) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public boolean containsValue(V value) {
        if (numElem == 0) {
            return false;
        }
        for (List<Par<K, V>> map_aux : map) {
            for (Par<K, V> par_aux : map_aux) {
                if (par_aux.getValue().equals(value)) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public Collection<K> getKey(V value) {
        Set<K> keys = new HashSet<>();
        int numElem_aux = 0;
        for (List<Par<K, V>> map_aux : map) {
            for (Par<K, V> par_aux : map_aux) {
                if (numElem_aux == numElem) {
                    return keys;
                }
                if (par_aux.getValue().equals(value)) {
                    keys.add(par_aux.getKey());
                }
            }
        }
        return keys;
    }
}
