package io.surfkit.recursion;


/*

 */

import java.util.ArrayList;
import java.util.Stack;

public class Question8_13 {


    public class Box{
        public int w, h, d;
        public Box(int w, int h, int d){ this.w = w; this.h = h; this.d = d; }
        public boolean canStack(Box other){
            return other.w > w && other.h > h && other.d > d;
        }
    }


/*
    public Stack<Box> findStack( Stack<Box> current, ArrayList<Box> boxes){
        if(boxes.isEmpty())return current;
        else if(current.isEmpty()){
            for( int i=0; i<boxes.size(); i++){
                Stack<Box> sb = new Stack<>();
                sb.addAll(current);
                sb.add(boxes.get(i));
                ArrayList<Box> left = new ArrayList<>();
                left.addAll(boxes);
                left.remove(i);
                findStack(sb, left);
            }
        }else{
            Box top = current.peek();
            for( int i=0; i<boxes.size(); i++){
                Box next = boxes.get(i);
                if(! top.canStack(next))continue;
                Stack<Box> sb = new Stack<>();
                sb.addAll(current);
                sb.add(next);
                ArrayList<Box> left = new ArrayList<>();
                left.addAll(boxes);
                left.remove(i);
                findStack(sb, left);

            }
        }
    }
*/

    public static void print(ArrayList<String> ps){
        for( String s : ps){
            System.out.println("{"+s+"}");
        }
    }


    public static void main(String[] args) {
        //ArrayList<String> ps = perms("abcd", 0);
        //print(ps);
    }




    // SOLUTIONS
    /*

     */




}


