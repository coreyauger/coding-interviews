package io.surfkit.moderate;


public class Question16_17 {



    public static int largestSum( int[] array ){
        int largest = Integer.MIN_VALUE;
        for( int i=0; i<array.length; i++){
            int sum = 0;
            for( int j=i; j<array.length; j++){
                sum += array[j];
                largest = Math.max(largest, sum);
            }
        }
        return largest;
    }







    public static void main(String[] args) {

        int[] array = new int[] {2, -8, 3, -2, 4, -10};
        int sum = largestSum(array);

        System.out.println("sum: " + sum);
    }




    // SOLUTIONS
    /*

     */



}


