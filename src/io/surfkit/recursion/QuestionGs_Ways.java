package io.surfkit.recursion;


/*

 */

import java.util.ArrayList;
import java.util.*;

public class QuestionGs_Ways {

    public static HashMap<String, Integer> memo = new HashMap<>();

    enum Step {
        None(-1), One(1), Two(2), Three(3);
        public int value;

        Step(int v) {
            this.value = v;
        }
    }

    private static void perm1(String prefix, String s, ArrayList<String> acc) {
        if (s.length() == 0)acc.add(prefix);
        else {
            for (int i = 0; i < s.length(); i++)
                perm1(prefix + s.charAt(i), s.substring(0, i) + s.substring(i+1, s.length()), acc);
        }

    }


    public static int waysPermutation(String perm) {
        // check memo for ways cache.
        System.out.println("perms of: " + perm);
        char[] keyS = perm.toCharArray();
        Arrays.sort(keyS);
        String key = new String(keyS);
        if (memo.containsKey(key)) return memo.get(key);
        ArrayList<String> ps = new ArrayList<>();
        perm1("", perm, ps);
        System.out.println("perms: ");
        for( String s: ps)System.out.println(s);
        HashSet<String> set = new HashSet(ps);
        memo.put(key, set.size());
        return set.size();
    }

    public static int waysToCoverDistance(Step step, int distance, String perm) {
        StringBuilder sb = new StringBuilder();
        sb.append(perm);
        if (step == Step.None) {
            step = Step.Three;
        } else if (step == Step.Three) {
            step = Step.Two;
        } else if (step == Step.Two) {
            for (int i = 0; i < distance; i++) sb.append("1");
            int ways = waysPermutation(sb.toString());
            for (int i = 0; i < distance; i++) sb.setLength(sb.length() - 1);
            return ways;
        }
        int totalWays = 0;


        for (int i = 0; i * step.value <= distance; i++) {
            for (int j = 0; j < i; j++) sb.append(step.value +"");
            totalWays += waysToCoverDistance(step, distance - (i * step.value), sb.toString());
            for (int j = 0; j < i; j++) sb.setLength(sb.length() - 1);
        }
        return totalWays;

    }

    public static int waysToCoverDistance(int distance) {
        return waysToCoverDistance(Step.None, distance, "");
    }


    public static void main(String[] args) {
        int numWays = waysToCoverDistance(4);
        System.out.println("ways to cover: " + numWays);
    }


    // SOLUTIONS
    /*

     */


}


