package io.surfkit.hard;


public class Question17_16 {


    public static int bookings( int[] times, int n ){
        if( n >= times.length )return 0;
        int time = times[n];
        return Math.max(
                time + bookings(times, n+2),
                bookings(times, n+1)
        );
    }



    public static void main(String[] args) {
        int[] times = new int[] { 30, 15, 60, 75, 45, 15, 15, 45};

        int max = bookings(times, 0);
        System.out.println("max time: " + max);
    }




    // SOLUTIONS
    /*

     */



}


