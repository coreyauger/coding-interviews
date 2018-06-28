package io.surfkit.hard;


import java.util.ArrayList;
import java.util.HashSet;

public class Question17_21 {


    public static class Vol{
        public int start;
        public int width;
        public int height;
        public int endHeight;
        public int ice;
        public Vol( int start, int height){
            this.start = start;
            this.height = height;
        }
        public void addIce(int cubes){
            ice += cubes;
        }
        public int getVolume(){
            if( height < 0 ) return 0;
            return ((width-1) *height) - ice;
        }
        public void addVol( Vol other ){
            width = other.start - start;
            endHeight= other.height;
            height = height > other.height ? other.height : height;
        }
        public Vol newVol(){
            return new Vol(start + width, endHeight);
        }
        public String toString(){
            return start + ", " + (start+width) + "  h: "+height + " i:" + ice;
        }
    }

    public static Vol findNextHeighest(  int[] bars, int start, int val ){
        Vol max = new Vol(-1, -1);
        for( int i=start+1; i<bars.length; i++){
            if( bars[i] > max.height )max = new Vol(i, bars[i] );
        }
        return max;
    }

    public static int histogramVolume( int[] bars ){
        ArrayList<Vol> vols = new ArrayList<>();
        Vol first = new Vol(0,0);
        for( int i=0; i<bars.length; i++){
            if( bars[i] > 0){
                first = new Vol(i, bars[i] );
                break;
            }
        }
        Vol end = findNextHeighest( bars, first.start, first.height);
        first.addVol(end);
        vols.add(first);
        Vol next = first.newVol();
        while( next.height > 0 ){
            end = findNextHeighest( bars, next.start, next.height);
            next.addVol(end);
            vols.add(next);
            next = next.newVol();
            System.out.println("new height: " + next.height + "  " + next.start);
        }
        int totalVol = 0;
        for( Vol v : vols ){
            for( int i=v.start+1; i<v.start+v.width-1; i++){
                v.addIce(bars[i]);
            }
            System.out.println(v);
            System.out.println(v.getVolume());
            totalVol += v.getVolume();
        }
        return totalVol;
    }




    public static void main(String[] args) {
        int[] bars = new int[] { 0, 0 , 4, 0, 0, 6, 0, 0, 3, 0, 5, 0 , 1, 0, 0, 0};
        int vol = histogramVolume(bars);
        System.out.println("volume: " + vol);
    }




    // SOLUTIONS
    /*

     */



}


