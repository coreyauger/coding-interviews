package io.surfkit.hackercup.tourist;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class FHC_Tourist {

    public static class Attraction{
        public static int nexPopularity = 0;

        public String name;
        public int popularity;
        public int visits = 0;

        public Attraction(String name){
            this.name = name;
            popularity = ++nexPopularity;
        }
        public Attraction(Attraction a){
            name = a.name;
            popularity = a.popularity;
        }
    }

    public static class AttracktionVisitor implements Comparator<Attraction> {
        public int compare(Attraction a, Attraction b){
            if(a.visits == b.visits){
                return a.popularity-b.popularity;
            }
            return a.visits-b.visits;
        }
    }


    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int numTests = in.nextInt();  // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int n = 1; n <= numTests; n++) {
            int N = in.nextInt();
            int K = in.nextInt();
            BigInteger V = in.nextBigInteger();

            ArrayList<Attraction> attractions = new ArrayList<>();
            for( int i=0; i<N; i++)
                attractions.add(new Attraction(in.next()));
            attractions.sort(new AttracktionVisitor());

            BigInteger rounds = new BigInteger("" + K).multiply( V.subtract(BigInteger.ONE) );
            int left = rounds.mod(new BigInteger(""+N)).intValue();
            //System.out.println("rounds: " + rounds);
            //System.out.println("left: " + left);


            for(int v=0; v<left; v++){
                int ind = v % N;
                attractions.get(ind).visits ++;
            }

            attractions.sort(new AttracktionVisitor());
            ArrayList<Attraction> nextK = new ArrayList<>();
            String[] names = new String[K];
            for(int k=0; k<K; k++){
                int ind = k % N;
                nextK.add(new Attraction( attractions.get(ind)) );
            }
            nextK.sort(new AttracktionVisitor());
            for(int k=0; k<K; k++){
                int ind = k % N;
                names[ind] = nextK.get(ind).name;
            }
            System.out.println("Case #" + n + ": " + String.join(" ", names));
        }
    }

}
