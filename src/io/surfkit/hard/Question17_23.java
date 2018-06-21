package io.surfkit.hard;



import java.util.ArrayList;

public class Question17_23 {


    public static class Square{
        public int r, c, dim;
        public Square(int r, int c, int dim){this.r =r; this.c =c; this.dim = dim;}
    }

    public static Square max = new Square(0,0,0);

    public static boolean tryForMax( int r, int c, int[][] grid){
        // try to move left max+1
        int tryDim = max.dim+1;
        int rightTop = r + tryDim;
        int rightBottom = c + tryDim;
        if( rightTop >= grid.length ) return false;
        if( rightBottom >= grid[r].length) return false;
        for(int i=r; i<r+tryDim; i++){
            if(grid[i][c] != 1)return false;
        }
        // try to move down now
        for(int i=c; i<c+tryDim; i++){
            if(grid[r][i] != 1)return false;
        }
        // try move bottom right
        for(int i=r; i<r+tryDim; i++){
            if(grid[i][c+tryDim] != 1)return false;
        }
        // try move right down
        for(int i=c; i<c+tryDim; i++){
            if(grid[r+tryDim][i] != 1)return false;
        }
        max = new Square(r, c, tryDim);
        System.out.println("m: " + max.r + ", " + max.c + "    " + max.dim);
        return true;
    }

    public static Square maxBlackSquare( int[][] grid ){
        for( int r=0; r<grid.length; r++){
            for( int c=0; c<grid[r].length; c++){
                if( grid[r][c] == 1 ){
                    Boolean newMax = tryForMax(r, c, grid);
                    while(newMax)newMax = tryForMax(r, c, grid);
                }
            }
        }
        return max;
    }



    public static void main(String[] args) {
        int gridDim = 25;
        int[][] grid = new int[gridDim][gridDim];
        int fillProb = (int)Math.floor( 1.5 * (gridDim*gridDim) );
        for(int i = 0; i<fillProb; i++){
            int r = (int)Math.floor( Math.random()*gridDim );
            int c = (int)Math.floor( Math.random()*gridDim );
            grid[r][c] = 1;
        }

        Square s = maxBlackSquare(grid);
        System.out.println("MAX: " + s.r + ", " + s.c + "    " + s.dim);

    }




    // SOLUTIONS
    /*

     */



}


