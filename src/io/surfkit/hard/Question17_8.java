package io.surfkit.hard;


import java.util.*;

public class Question17_8 {


    public static class Person{
        public int height;
        public int weight;
        public Person(int h, int w){
            height = h;
            weight = w;
        }
        public String toString(){
            return "(" + height + ", " + weight + ")";
        }
    }


    public static ArrayList<Person> largestTower( Person[] people, Person top ){
        ArrayList<Person> largest = new ArrayList();
        for( Person p : people){
            if( p.height < top.height && p.weight < top.weight ){
                ArrayList x = largestTower( people, p );
                x.add(p);
                if( x.size() > largest.size() )largest = x;
            }
        }
        return largest;
    }

    public static ArrayList<Person> largestTower( Person[] people ){
        return largestTower(people, new Person(Integer.MAX_VALUE, Integer.MAX_VALUE));
    }


/*
 (56, 90) (60,95) (65,100) (68,110) (70,150) (75,190)
 */

    public static void main(String[] args) {
        // (65, 100) (70, 150) (56, 90) (75, 190) (60, 95) (68, 110)
        Person[] poeple = new Person[]{
                new Person(65, 100),
                new Person(70, 150),
                new Person(56, 90),
                new Person(75, 190),
                new Person(60, 95),
                new Person(68, 110)
        };

        ArrayList<Person> stack = largestTower(poeple);
        System.out.println("largest stack is: " + stack.size());
        for(Person p: stack)System.out.println(p);
    }




    // SOLUTIONS
    /*

     */



}


