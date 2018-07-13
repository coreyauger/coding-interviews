package io.surfkit.hard;


public class Question17_24 {


    public static int maxSum( int[][] matrix, int[] ul, int w, int h ) {
        int withRow = 0;
        int withCol = 0;
        System.out.println("w: " + w + ", h:" + h);
        // add a row to the matrix
        if (ul[1] + h < matrix[ul[1]].length) {

            int rowSum = 0;
            for (int c = ul[1]; c < h + ul[1]; c++) rowSum += matrix[ul[0] + 1][c];
            withRow = rowSum + maxSum(matrix, ul, w, h + 1);
        }
        if ( ul[0] + w < matrix[ul[0]].length) {
            int colSum = 0;
            for (int r = ul[0]; r < w + ul[0]; r++) colSum += matrix[r][ul[1] + 1];
            withCol = colSum + maxSum(matrix, ul, w + 1, h);
        }
        return Math.max(withRow, withCol);
    }

    public static int maxSubMatrix( int[][] matrix ) {
        int max = 0;
        for (int r = 0; r < matrix.length; r++) {
            for (int c = 0; c < matrix[r].length; c++) {
                max = Math.max(max, maxSum(matrix, new int[]{r, c}, 1, 1));
            }
        }
        return max;
    }




    public static void main(String[] args) {
        int gridDim = 10;
        int[][] grid = new int[gridDim][gridDim];
        int fillProb = (int)Math.floor( 1.5 * (gridDim*gridDim) );
        for(int i = 0; i<fillProb; i++){
            int r = (int)Math.floor( Math.random()*gridDim );
            int c = (int)Math.floor( Math.random()*gridDim );
            grid[r][c] =  (int)Math.floor(Math.random()*25);
        }

        int s = maxSubMatrix(grid);
        System.out.println("MAX: " +s);

    }




    // SOLUTIONS
    /*

     */



}


