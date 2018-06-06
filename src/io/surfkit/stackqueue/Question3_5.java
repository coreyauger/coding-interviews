package io.surfkit.stackqueue;


import java.util.ArrayList;

public class Question3_5 {


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

        public void print(){
            for( E item: store)System.out.print(item+",");
        }
    }


    public static class SortStack implements Stack<Integer>{
        private ArrayStack<Integer> sorted = new ArrayStack<>();
        private ArrayStack<Integer> a = new ArrayStack<>();

        // not pretty !
        public void push(Integer item){
            System.out.println("push:" +item);
            while(!sorted.isEmpty()){
                if(item < sorted.peek()){
                    a.push(item);
                    break;
                }
                a.push(sorted.pop());
            }
            while(!sorted.isEmpty())a.push(sorted.pop());
            if(!a.isEmpty() && item > a.peek())a.push(item);
            while(!a.isEmpty())sorted.push(a.pop());
            if(sorted.isEmpty())sorted.push(item);
            sorted.print();
            System.out.println("---");
        }

        public Integer pop(){ return sorted.pop(); }
        public boolean isEmpty(){ return sorted.isEmpty(); }
        public Integer peek(){ return sorted.peek(); }
    }



    public static void main(String[] args) {

        SortStack sortStack = new SortStack();
        sortStack.push(10);
        sortStack.push(5);
        sortStack.push(2);
        sortStack.push(9);
        sortStack.push(7);
        sortStack.push(4);
        sortStack.push(1);


        System.out.println("pop 1?: "+sortStack.pop());
        System.out.println("pop 2?: "+sortStack.pop());
        System.out.println("pop 4?: "+sortStack.pop());
        System.out.println("pop 5?: "+sortStack.pop());
        System.out.println("pop 7?: "+sortStack.pop());

    }



    // SOLUTIONS
    /*

     */




}


