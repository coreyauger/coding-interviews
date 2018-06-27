package io.surfkit.recursion;


/*

 */

public class QuestionGs_Knapsack {

    public static int knapsack( int[] vals, int[] weights, int index, int weight ){
        if( vals.length == index ) return 0;
        int w = weights[index];
        if( weight - w < 0 )return 0;
        return Math.max(
                knapsack(vals, weights, index+1, weight - w) + vals[index],
                knapsack(vals, weights, index+1, weight)
                );
    }




    public static void main(String[] args) {
        //int[] vals = new int[]{60, 100, 120};
        //int[] weights = new int[]{1,2,3};

        int[] vals = new int[]{120, 100, 60};
        int[] weights = new int[]{3, 2, 1};

        int v = knapsack(vals, weights, 0,5);

        System.out.println("knapsack: " + v);

        int v2 = knapSack(5, weights, vals, vals.length);
    }



    // A utility function that returns maximum of two integers
    static int max(int a, int b) { return (a > b)? a : b; }

    // Returns the maximum value that can be put in a knapsack of capacity W
    static int knapSack(int W, int wt[], int val[], int n)
    {
        int i, w;
        int K[][] = new int[n+1][W+1];

        // Build table K[][] in bottom up manner
        for (i = 0; i <= n; i++)
        {
            for (w = 0; w <= W; w++)
            {
                if (i==0 || w==0)
                    K[i][w] = 0;
                else if (wt[i-1] <= w)
                    K[i][w] = max(val[i-1] + K[i-1][w-wt[i-1]],  K[i-1][w]);
                else
                    K[i][w] = K[i-1][w];
            }
        }
        System.out.println("");
        for (i = 0; i <= n; i++)
        {

            for (w = 0; w <= W; w++)
            {
                System.out.print(K[i][w] + ",");
            }
            System.out.println("");
        }

        return K[n][W];
    }




    // SOLUTIONS
    /*

     */




}


