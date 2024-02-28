package map;

import java.util.*;

public class CustomMap<K, V> {

    private static final float DEFAULT_LOAD_FACTOR = 0.75f;
    private static final int DEFAULT_CAPACITY = 16;

    private int size;
    private int capacity = DEFAULT_CAPACITY;

    private LinkedList<Entry<K, V>>[] buckets;

    @SuppressWarnings("unchecked")
    public CustomMap() {
        this.buckets = new LinkedList[DEFAULT_CAPACITY];
        this.size = 0;
    }

    @SuppressWarnings("unchecked")
    public CustomMap(int capacity) {
        this.buckets = new LinkedList[capacity];
        this.size = 0;
    }

    public void put(K key, V value) {
        int hash = hash(key);
        int index = hash % capacity;

        if ((float) size / capacity >= DEFAULT_LOAD_FACTOR) {
            resize();
        }

        LinkedList<Entry<K, V>> entries = buckets[index];
        if (entries != null) {
            entries.addFirst(new Entry<>(key, value));
        } else {
            LinkedList<Entry<K, V>> list = new LinkedList<>();
            list.addFirst(new Entry<>(key, value));
            buckets[index] = list;
        }
        size++;
    }

    public V get(K key) {
        int hash = hash(key);
        int index = hash % capacity;

        if (buckets[index] != null) {
            LinkedList<Entry<K, V>> entries = buckets[index];
            for (Entry<K, V> entry : entries) {
                if (entry.key.equals(key)) {
                    return entry.value;
                }
            }
        }

        return null;
    }

    public V remove(K key) {
        int hash = hash(key);
        int index = hash % capacity;

        if (buckets[index] != null) {
            LinkedList<Entry<K, V>> entries = buckets[index];
            for (Entry<K, V> entry : entries) {
                if (entry.key.equals(key)) {
                    V value = entry.value;
                    entries.remove(entry);
                    size--;
                    return value;
                }
            }
        }
        return null;
    }

    public List<V> values() {
        List<V> values = new ArrayList<>();
        for (LinkedList<Entry<K, V>> bucket : buckets) {
            if (bucket != null) {
                for (Entry<K, V> kvEntry : bucket) {
                    values.add(kvEntry.value);
                }
            }
        }
        return values;
    }

    public Set<K> keySet() {
        Set<K> kSet = new HashSet<>();
        for (LinkedList<Entry<K, V>> bucket : buckets) {
            if (bucket != null) {
                for (Entry<K, V> kvEntry : bucket) {
                    kSet.add(kvEntry.key);
                }
            }
        }
        return kSet;
    }

    public Set<Entry<K, V>> entrySet() {
        Set<Entry<K, V>> entrySet = new HashSet<>();
        for (LinkedList<Entry<K, V>> bucket : buckets) {
            if (bucket != null) {
                entrySet.addAll(bucket);
            }
        }
        return entrySet;

    }

    public boolean contains(K key) {
        int hash = hash(key);
        int index = hash % capacity;

        if (buckets[index] != null) {
            LinkedList<Entry<K, V>> entries = buckets[index];
            for (Entry<K, V> entry : entries) {
                if (entry.key.equals(key)) {
                    return true;
                }
            }
        }
        return false;
    }

    public int getSize() {
        return size;
    }

    private void resize() {
        capacity = capacity << 1;

        @SuppressWarnings("unchecked")
        LinkedList<Entry<K, V>>[] newBuckets = new LinkedList[capacity];

        for (LinkedList<Entry<K, V>> bucket : buckets) {
            if (bucket != null) {

                for (Entry<K, V> kvEntry : bucket) {
                    int hash = hash(kvEntry.key);
                    int index = hash % capacity;
                    LinkedList<Entry<K, V>> list = new LinkedList<>();
                    list.addFirst(kvEntry);
                    newBuckets[index] = list;
                }
            }
        }
        buckets = newBuckets;
    }

    private int hash(Object key) {
        int h;
        return (key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16);
    }
}