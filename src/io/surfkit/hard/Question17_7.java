package io.surfkit.hard;


import java.util.*;

public class Question17_7 {


    public static HashMap<String, Synonyms> mapping = new HashMap<>();

    public static class Synonyms{
        public ArrayList<String> keys = new ArrayList<>();
        public int frequency;
        public Synonyms( String[] names, int frequency){
            for( String name : names) keys.add(name);
            this.frequency += frequency;
        }


        public void addName( String name ){
            keys.add(name);
        }
    }

    public static void load( Map<String, Integer> data, Map<String, String> syn ){
        for( String name : data.keySet() ){
            mapping.put( name, new Synonyms(new String[]{name}, data.get(name) ) );
        }
        for( String name: syn.keySet() ){
            String other = syn.get(name);
            Synonyms s1 = mapping.get(name);
            Synonyms s2 = mapping.get(other);
            System.out.println(name + " -> " + other);
            ArrayList<String> join = new ArrayList<>();
            join.addAll(s1.keys);
            join.addAll(s2.keys);
            ArrayList<String> all = new ArrayList<>();
            int freq = 0;
            for( String n : join){
                Synonyms s = mapping.get(n);
                freq += s.frequency;
                all.addAll(s.keys);
            }
            Set<String> set =new HashSet<>(all); // dedup
            Synonyms syns = new Synonyms( set.toArray(new String[set.size()]), freq );
            for( String key : syns.keys ){
                mapping.put(key, syns);
            }
        }
    }




/*
 John (15), Jon (12), Chris (13), Kris (4), Christopher (19) Synonyms: (Jon, John), (John, Johnny), (Chris, Kris), (Chris, Christopher)
 */

    public static void main(String[] args) {
        Map<String, Integer> data = new HashMap<>();
        data.put("John", 15);
        data.put("Jon", 12);
        data.put("Chris", 13);
        data.put("Kris", 4);
        data.put("Christopher", 19);

        Map<String, String> syns = new HashMap<>();
        syns.put("Jon", "John");
        //syns.put("John", "Johnny");
        syns.put("Chris", "Kris");
        syns.put("Chris", "Christopher");

        load(data, syns);

        System.out.println("Kris: " +  mapping.get("Kris").frequency);
        System.out.println("Chris: " +  mapping.get("Chris").frequency);
    }




    // SOLUTIONS
    /*

     */



}


