package daily.challenge.pratice;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class LRUCacheImp {
    static class LRUCache<K, V> extends LinkedHashMap<K, V> {
        private final int capacitry;

        LRUCache(int capacity) {
//            super(capacity, 0.75f, true);
            this.capacitry = capacity;
        }

        @Override
        protected boolean removeEldestEntry(Map.Entry<K,V> eldest) {
            return size() > capacitry;
        }
    }

//    public static class LRUCache<K, V> extends LinkedHashMap<K, V> {
//        private final int capacity;
//
//        public LRUCache(int capacity) {
//            super(capacity, 0.75f, true);
//            this.capacity = capacity;
//        }
//
//        @Override
//        protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
//            return size() > capacity;
//        }
//    }

        public static void main(String[] args) {
        LRUCache cache = new LRUCache<String, Integer>(3);
        cache.put("1",1);
        cache.put("2",121);
        cache.put("3",1);

        System.out.println(cache);
        System.out.println(cache.get("2"));
        cache.put("4",4);
        System.out.println(cache.toString());




        }
}
