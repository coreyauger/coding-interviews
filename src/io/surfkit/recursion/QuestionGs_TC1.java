package io.surfkit.recursion;


/*

 */

public class QuestionGs_TC1 {

    public static  boolean isValid( String str, int k ){
        int pairs = 0;
        char[] letters = str.toCharArray();
        for( int i=0; i<letters.length; i++){
            for(int j=i+1; j<letters.length; j++){
                if( letters[i] < letters[j] )pairs++;
            }
        }
        return pairs == k;
    }

    public static String buildString( String str, int N, int k ){
        if( str.length() == N ){

            if(isValid(str, k)) return str;
            else return "";
        }
        String aa = buildString( str + "A", N, k);
        String bb = buildString( str + "B", N, k);
        String cc = buildString( str + "C", N, k);
        if( aa.length() > 0)return aa;
        if( bb.length() > 0)return bb;
        if( cc.length() > 0)return cc;
        return "";
    }

    public static String createString(int N, int K){
        //if(N > K)return "";
        return buildString( "", N, K);
    }




    public static void main(String[] args) {
        //int[] vals = new int[]{60, 100, 120};
        //int[] weights = new int[]{1,2,3};

        String t1 = createString(15, 36);
        System.out.println(t1);
    }




    // SOLUTIONS
    /*

     */




}


