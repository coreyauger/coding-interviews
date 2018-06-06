package io.surfkit.stackqueue;


import java.util.ArrayList;
import java.util.LinkedList;

public class Question3_6 {

    interface Animal{
        void setId(int id);
        int getId();
    }
    public static class Cat implements Animal{
        private int id;
        public void setId(int id){ this.id = id; }
        public int getId(){ return id;}

    }
    public static class Dog implements Animal{
        private int id;
        public void setId(int id){ this.id = id; }
        public int getId(){ return id;}
    }


    public static class AnimalShelter{
        LinkedList<Cat> cats = new LinkedList<>();
        LinkedList<Dog> dogs = new LinkedList<>();

        int id = 0;

        public void enqueue(Animal a){
            a.setId(id++);
            if(a instanceof Dog)dogs.addLast((Dog)a);
            else if(a instanceof Cat)cats.addLast((Cat)a);
        }

        public Animal dequeueAny(){
            if(cats.isEmpty()){
                if(dogs.isEmpty() )return null;
                else return dogs.pop();
            }else if(dogs.isEmpty()){
                return cats.pop();
            }
            else{
                if(dogs.peek().getId() < cats.peek().getId())return dogs.pop();
                return cats.pop();
            }
        }

        public Dog dequeueDog(){
            if(dogs.isEmpty())return null;
            else return dogs.pop();
        }

        public Cat dequeueCat(){
            if(cats.isEmpty())return null;
            else return cats.pop();
        }
    }




    public static void main(String[] args) {

        AnimalShelter shelter = new AnimalShelter();
        shelter.enqueue(new Cat());
        shelter.enqueue(new Cat());
        shelter.enqueue(new Dog());
        shelter.enqueue(new Cat());
        shelter.enqueue(new Dog());

    }



    // SOLUTIONS
    /*

     */




}


