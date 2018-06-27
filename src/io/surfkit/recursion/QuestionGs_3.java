package io.surfkit.recursion;


/*

 */

public class QuestionGs_3 {

    //  {50, 3, 10, 7, 40, 80} = 4

    public static int[][] memo;

    public static int LIS( int[] seq, int ind ){

        int max = 1;
        if( ind > seq.length-1 )return 0;
        int item = seq[ind];
        for(int i=ind; i<seq.length; i++){
            //System.out.println("ind: " + ind + "  " + i  + "   " + seq.length );
            if(memo[ind][i] != -1){
                max = Math.max( max, memo[ind][i] );
            }
            else if(item < seq[i] ){
                max = Math.max( max, LIS(seq, i)+1 );
                memo[ind][i] = max;
            }else{
                max = Math.max( max, LIS(seq, i+1) );
                memo[ind][i] = max;
            }
        }
        return max;
    }

    public static int LIS( int[] seq){
        memo = new int[seq.length][seq.length];
        for(int i =0; i<memo.length;i++)for(int j=0;j<memo[i].length; j++)memo[i][j] = -1;
        return LIS(seq, 0);
    }




    public static void main(String[] args) {
        int len1 = LIS(new int[]{10, 22, 9, 33, 21, 50, 41, 60, 80});
        System.out.println("LIS1: " + len1);

        int len2 = LIS(new int[]{3, 10, 2, 1, 20});
        System.out.println("LIS2: " + len2);

        int len3 = LIS(new int[]{3, 2});
        System.out.println("LIS3: " + len3);

        int len4 = LIS(new int[]{50, 3, 10, 7, 40, 80});
        System.out.println("LIS4: " + len4);
    }




    // SOLUTIONS
    /*

     */




}


