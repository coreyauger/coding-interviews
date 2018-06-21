package io.surfkit.bits;


import java.util.*;

public class Question5_8 {

    public static final int sizeOfByte = 8;

    public static void drawPixel(byte[] screen, int w, int h, int x, int y){
        // lets get the the right y
        int row = y * w;
        int unit = x / sizeOfByte;
        int bit = sizeOfByte-(x % sizeOfByte);
        int blast = 1 << (bit-1);
        printByte((byte)blast);
        System.out.println("r: " + row + "  " + unit +  " bit:"+bit);
        screen[row + unit] = (byte)((int)screen[row + unit] | blast);
    }

    public static byte[] drawline(byte[] screen, int width, int x1, int x2, int y){
        int height = (width/sizeOfByte) / screen.length;
        if( x2 < x1 ){
            int tmp = x1;
            x1 = x2;
            x2 = tmp;
        }
        for(int i=x1; i<=x2; i++)drawPixel(screen, width/sizeOfByte, height, i, y);
        return screen;
    }


    public static void printByte(byte b1){
        String s1 = String.format("%8s", Integer.toBinaryString(b1 & 0xFF)).replace(' ', '0');
        System.out.print(s1); // 10000001
    }

    public static void printScreen(byte[] screen, int w, int h){
        for( int i=0; i<h; i++){
            for(int j=0; j<w; j++)printByte(screen[h*i + j]);
            System.out.println("");
        }
    }





    public static void main(String[] args) {
        int w = 10, h = 10;

        byte[] screen = new byte[ w*h ];
        printScreen(screen, w, h);

        drawline(screen, w*sizeOfByte, 4, 25, 5);

        System.out.println("***");
        printScreen(screen, w, h);

    }




    // SOLUTIONS
    /*

     */



}


