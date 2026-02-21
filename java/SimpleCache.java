import java.util.LinkedHashMap;

public class SimpleCache<K, V>{
 
    private final int capacity;
    private LinkedHashMap<K, V> cache;
    
    public SimpleCache(int capacity){
        this.capacity = capacity;
        cache = new LinkedHashMap<>(capacity);
    }

    public void put(K key, V value){
        
        if(cache.size() == capacity){
            var oldestKey = cache.keySet().iterator().next();
            cache.remove(oldestKey); // into the void
        }
        cache.put(key, value);
    }

    public V get(K key){
        return cache.get(key);
    }
    
}
