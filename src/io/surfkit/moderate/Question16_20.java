package io.surfkit.moderate;


import java.util.ArrayList;
import java.util.HashMap;

public class Question16_20 {


    public static class Tries{
        public char value;
        public HashMap<Character, Tries> children = new HashMap<>();
        public Tries(char v){ value = v; }
    }


    public static ArrayList<String> t9Map = null;

    public static ArrayList<String> search( Tries node,  ArrayList< String > chars, int n, String sb){
        ArrayList<String> words = new ArrayList();
        if( n == chars.size() ){
            if(node.children.containsKey('%')) {
                System.out.println("word: " + sb);
                words.add(sb);
            }
            return words;
        }

        char[] next = chars.get(n).toCharArray();
        for( char c : next ){
            if( node.children.containsKey(c) ){
                ArrayList<String> w = search( node.children.get(c), chars, n+1, sb + c);
                words.addAll(w);
            }
        }
        return words;
    }

    public static void initT9Map(){
        t9Map = new ArrayList<>(10);
        t9Map.add("");
        t9Map.add("");
        t9Map.add("abc");
        t9Map.add("def");
        t9Map.add("ghi");
        t9Map.add("jkl");
        t9Map.add("mno");
        t9Map.add("pqrs");
        t9Map.add("tuv");
        t9Map.add("wxyz");
    }

    public static ArrayList<String> t9( int[] numbers, Tries root ){
        if(t9Map == null)initT9Map();
        ArrayList< String > chars = new ArrayList<>();
        for( int i=0; i<numbers.length; i++){
            chars.add(
                    t9Map.get(
                            numbers[i]) );
        }
        return search(root, chars, 0, "");
    }




    public static void main(String[] args) {
        Tries root = buildTries(new String[]{
                "fart",
                "buthole",
                "tree",
                "used",
                "tred",
                "donkey"

        });

        ArrayList<String> words = t9(new int[] {8, 7, 3, 3}, root);

        System.out.println("words: " + words);
    }



    public static Tries buildTries( String[] words ){
        Tries root = new Tries(' ');
        for(String w : words){
            char[] letters = w.toCharArray();
            Tries next = root;
            for( char ch : letters){
               if(!next.children.containsKey(ch)){
                   next.children.put(ch, new Tries(ch));
               }
               next = next.children.get(ch);
            }
            next.children.put('%', new Tries('%'));
        }
        return root;
    }


    // SOLUTIONS
    /*

     */



}


