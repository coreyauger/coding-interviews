package io.surfkit.moderate;


import java.util.*;

public class Question16_25 {



    public static class LRU<K, V>{
        private Map<K, V> cache = new HashMap<K, V>();
        private LinkedList<K> lru = new LinkedList<K>();
        private int capacity;

        public LRU( int capacity ){
            this.capacity = capacity;
        }

        public V put(K key,  V val){
            lru.remove(key);
            lru.addFirst(key);
            if(lru.size() > capacity){
                cache.remove(lru.removeLast());
            }
            return cache.put(key, val);
        }
        public V get(K key){
            lru.remove(key);
            lru.addFirst(key);
            return cache.get(key);
        }
        public int getSize(){
            return lru.size();
        }
        public int getCapacity(){
            return capacity;
        }

        public void printKeys(){
            for( K k : lru){
                System.out.print(k + ",");
            }
            System.out.println("");
        }
    }






    public static void main(String[] args) {
        LRU<String, String> lru = new LRU(4);

        lru.put("1", "1");
        lru.put("2", "2");
        lru.put("3", "3");
        lru.put("4", "4");
        lru.get("4");
        lru.get("3");
        lru.get("2");
        lru.put("5", "5");
        lru.printKeys();
    }




    // SOLUTIONS
    /*

     */



}


