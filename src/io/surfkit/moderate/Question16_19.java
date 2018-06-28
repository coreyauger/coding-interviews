package io.surfkit.moderate;


import java.util.ArrayList;

public class Question16_19 {



    static int[][] visited;

    static int search( int[][] matrix, int r, int c){
        if( r < 0 || c < 0 || r > matrix.length-1 || c > matrix[r].length -1 ) return 0;
        if( matrix[r][c] == 0 && visited[r][c] == 0 ){
            visited[r][c] = 1;
            return  1+
                    search(matrix, r+1, c) +   // right
                    search(matrix, 1-r, c) +   // left
                    search(matrix, r, c+1) +   // up
                    search(matrix, r, c-1) +   // down
                    search(matrix, r-1, c-1) +   // ll
                    search(matrix, r+1, c-1) +   // lr
                    search(matrix, r+1, c+1) +   // ur
                    search(matrix, r-1, c+1);   // ul
        }
        return  0;
    }

    static ArrayList<Integer> pondSizes(int[][] matrix ){
        ArrayList<Integer> sizes = new ArrayList<>();
        if( matrix == null || matrix.length == 0) return sizes;
        visited = new int[matrix.length][matrix[0].length];
        for( int r=0; r<matrix.length; r++){
            for( int c=0; c<matrix[r].length; c++){
                if( matrix[r][c] == 0 && visited[r][c] == 0 ){
                    sizes.add( search( matrix, r, c) );
                }
            }
        }
        return sizes;
    }









    public static void main(String[] args) {

        int[][] pond = new int[][]{
                {0, 2, 1, 0},
                {0, 1, 0, 1},
                {1, 1, 0, 1},
                {0, 1, 0, 1}
        };

        ArrayList< Integer> sizes = pondSizes(pond);
        System.out.println("Sizes: " + sizes);
    }




    // SOLUTIONS
    /*

     */



}


