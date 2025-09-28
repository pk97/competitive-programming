package daily.challenge.pratice;

import java.util.*;
import java.util.stream.Collectors;

public class LRUCacheImp {
    static class LRUCache<K, V> extends LinkedHashMap<K, V> {
        private final int capacitry;

        LRUCache(int capacity) {
            super(capacity, 0.75f, true);
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
        System.out.println(cache);

        }
}


class MyLRUCache {
    Map<Integer, Node> map;
    Node lu ;
    Node mu;
     static class Node {
         int k;
         int v;
         Node next;
    }

    MyLRUCache(int cap) {
          map = new HashMap<>(3);
          lu = null;
          mu= null;
    }

    void put() {
         new Node();
    }
}
