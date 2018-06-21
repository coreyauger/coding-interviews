package io.surfkit.moderate;


import java.util.HashSet;

public class Question16_15 {



    public static class GameState{
        public int hits;
        public int pseudo;
        public GameState(int h, int p){this.hits = h; this.pseudo = p;}
    }

    public static char[] solution = new char[]{ 'R', 'G', 'B', 'Y' };

    public static GameState nextGuess( char[] guess ){
        if(guess.length != 4){
            // throw an error?
        }
        int hits = 0;
        int pseudo = 0;
        for( int i=0; i<solution.length; i++){
            if( solution[i] == guess[i]){
                hits++;
                pseudo--;
            }
        }
        HashSet<Character> set = new HashSet<>();
        for( int i=0; i<solution.length; i++)set.add(guess[i]);
        for( Character ch : set){
            for( int j=0; j<solution.length; j++){
                if( solution[j] == ch){
                    pseudo++;
                }
            }
        }
        return new GameState(hits, pseudo);
    }





    public static void main(String[] args) {

        GameState state = nextGuess( new char[]{'G', 'G', 'R', 'R'} );

        System.out.println("hits: " + state.hits);
        System.out.println("pseudo: " + state.pseudo);

    }




    // SOLUTIONS
    /*

     */



}


