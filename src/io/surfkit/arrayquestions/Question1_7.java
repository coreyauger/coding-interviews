package io.surfkit.arrayquestions;

/*
URLify: Write a method to replace all spaces in a string with '%20'. You may assume that the string
has sufficient space at the end to hold the additional characters, and that you are given the "true"
length of the string. (Note: If implementing in Java, please use a character array so that you can
perform this operation in place.)
 */

public class Question1_7 {


    // Rotation came be made of 2 reflections...
    public static int[][] rotate90( int[][] m ){
        // confirm this is nxn
        int start = 0;
        // first reflection
        for ( int i = start; i<m[0].length; i++ ){
            for( int j=start; j<m[i].length; j++){
                int tmp = m[i][j];
                m[i][j] = m[j][i];
                m[j][i] = tmp;
            }
            start++;
        }
        // 2nd reflection.
        for( int i=0; i<m[0].length; i++ ){
            for( int j=0; j<m[i].length/2; j++){
                int tmp = m[i][j];
                m[i][j] = m[i][m[i].length-j-1];
                m[i][m[i].length-j-1] = tmp;
            }
        }
        return m;
    }


    public static void printMat(int[][] m){
        for(int i=0; i<m.length; i++){
            for(int j=0; j<m[i].length; j++){
                System.out.print(m[i][j] + ", ");
            }
            System.out.println("");
        }
    }


    public static void main(String[] args) {
        // write your code here
        int[][] matrix = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}};

        printMat(matrix);
        System.out.println("--");
        printMat(rotate90(matrix));

    }



    // BOOK SOLUTION...
    //

    public static boolean rotate(int[][] matrix) {
        if (matrix.length == 0 || matrix.length != matrix[0].length) return false; // Not a square
        int n = matrix.length;

        for (int layer = 0; layer < n / 2; layer++) {
            int first = layer;
            int last = n - 1 - layer;
            for(int i = first; i < last; i++) {
                int offset = i - first;
                int top = matrix[first][i]; // save top

                // left -> top
                matrix[first][i] = matrix[last-offset][first];

                // bottom -> left
                matrix[last-offset][first] = matrix[last][last - offset];

                // right -> bottom
                matrix[last][last - offset] = matrix[i][last];

                // top -> right
                matrix[i][last] = top; // right <- saved top
            }
        }
        return true;
    }


}
