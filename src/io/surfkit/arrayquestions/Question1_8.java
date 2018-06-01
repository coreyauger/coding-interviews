package io.surfkit.arrayquestions;

/*
URLify: Write a method to replace all spaces in a string with '%20'. You may assume that the string
has sufficient space at the end to hold the additional characters, and that you are given the "true"
length of the string. (Note: If implementing in Java, please use a character array so that you can
perform this operation in place.)
 */

public class Question1_8 {


    public static void zeroRow( int[][] m, int r ){
        for(int y=0; y<m[r].length; y++)m[r][y] = 0;
    }
    public static void zeroCol( int[][] m, int c ){
        for(int x=0; x<m.length; x++)m[x][c] = 0;
    }

    public static int[][] zeroMatrix( int[][] m ){
        java.util.Set cols = new java.util.HashSet<Integer>();
        java.util.Set rows = new java.util.HashSet<Integer>();
        // start looking for 0’s
        for(int x=0; x<m.length; x++){
            if(rows.contains(x))continue;
            for(int y=0; y<m[x].length; y++){
                if(cols.contains(y))break;
                if(m[x][y] == 0){
                    zeroRow(m, x);
                    zeroCol(m, y);
                    rows.add(x);
                    cols.add(y);
                    break;
                }
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
                {4, 0, 6},
                {7, 8, 9}};

        int[][] matrix2 = {
                {1, 2, 3, 0},
                {4, 0, 6, 4},
                {7, 8, 9, 11}};

        printMat(matrix);
        System.out.println("--");
        printMat(zeroMatrix(matrix));
        System.out.println("--");
        printMat(zeroMatrix(matrix2));

    }



    // BOOK SOLUTION...
    //



}
