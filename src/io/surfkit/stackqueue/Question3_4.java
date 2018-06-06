package io.surfkit.stackqueue;


import java.util.ArrayList;

public class Question3_4 {


    public interface Stack<E>{
        public void push(E item);
        public E pop();
        public E peek();
        public boolean isEmpty();
    }

    public static class ArrayStack<E> implements Stack<E>{
        private ArrayList<E> store = new ArrayList<>();

        public void push( E item ){
            store.add(item);
        }
        public E pop(){
            return store.remove(store.size()-1);
        }
        public E peek(){
            return store.get(store.size()-1);
        }
        public boolean isEmpty(){ return store.size() == 0; }
    }


    public interface Queue<E>{
        public void add(E item);
        public E remove();
        public E peek();
        public boolean isEmpty();
    }

    public static class MyQueue<E> implements Queue<E>{

        ArrayStack<E> a = new ArrayStack<>();
        ArrayStack<E> b = new ArrayStack<>();

        MyQueue(){}


        public void add(E item) {
            // keep one empty.. add new element.. stack others on top.. them move them all back to the other.
            b.push(item);
            while(!a.isEmpty())b.push(a.pop());
            while(!b.isEmpty())a.push(b.pop());
        }

        public E remove() {
            return a.pop();
        }

        public E peek() {
            return a.peek();
        }

        public boolean isEmpty() {
            return a.isEmpty();
        }
    }


    public static void main(String[] args) {
        Integer[] storage = new Integer[12];

        MyQueue<Integer> queue = new MyQueue();
        queue.add(1);
        queue.add(2);
        queue.add(3);
        queue.add(4);

        System.out.println("remove 4?: "+queue.remove());
        System.out.println("remove 3?: "+queue.remove());

        queue.add(5);
        queue.add(6);
        System.out.println("remove 6?: "+queue.remove());
        System.out.println("remove 5?: "+queue.remove());

        System.out.println("remove 2?: "+queue.remove());
        System.out.println("remove 1?: "+queue.remove());

    }



    // SOLUTIONS
    /*

     */




}


