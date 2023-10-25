package map;

import java.util.Collection;
import java.util.List;
import java.util.Set;

/**
 *
 * @author seram
 */
public interface Map<K, V> {

    public int size();

    public boolean isEmpty();

    public V get(K key);

    public V put(K key, V value);

    public V remove(K key);

    public Set<K> keySet();

    public Collection<V> values();

    public boolean containsKey(K key);

    public boolean containsValue(V value);

    public List<K> getKey(V value);
}