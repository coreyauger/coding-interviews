package io.surfkit.stackqueue;


public class Question3_1 {


    public interface Stack<E>{
        public void push(E item);
        public E pop();
        public E peek();
        public boolean isEmpty();
    }


    public static class ThreeInOneStack<E> implements Stack<E>{
        private int top = 0;
        private int start = 0;
        private int len = 0;
        private int size = 0;

        private E[] store;
        public ThreeInOneStack(E[] store, int start, int length){
            this.start = start;
            this.top = start-1;
            this.len = length;
            this.size = 0;
            this.store = store;
        }

        public void push( E item ){
            if(size+1 > len)throw new RuntimeException("Out of room on stack");
            top++;
            if( top - start > len ){    // NOTE: i did not need this as the stack should never wrap!
                top = start;
            }
            store[top] = item;
            size++;
        }

        public E pop(){
            if(size-1 < 0)throw new RuntimeException("Can not pop empty stack");
            E ret = store[top];
            top--;
            if( top - start < 0 ){
                top = start+len;
            }
            size--;
            return ret;
        }

        public E peek(){
            return store[top];
        }
        public boolean isEmpty(){ return size == 0; }
    }



    public static void main(String[] args) {
        Integer[] storage = new Integer[12];

        ThreeInOneStack<Integer> stack1 = new ThreeInOneStack<>(storage, 0, 4);
        ThreeInOneStack<Integer> stack2 = new ThreeInOneStack<>(storage, 4, 4);
        ThreeInOneStack<Integer> stack3 = new ThreeInOneStack<>(storage, 8, 4);

        stack1.push(8);
        stack1.push(9);
        stack1.push(10);
        stack1.push(11);

        System.out.println("pop 11?: "+stack1.pop());
        stack1.push(12);
        System.out.println("pop 12?: "+stack1.pop());
        System.out.println("pop 10?: "+stack1.pop());


        stack2.push(8);
        stack2.push(9);
        stack2.push(10);
        stack2.push(11);

        System.out.println("pop 11?: "+stack2.pop());
        stack2.push(12);
        System.out.println("pop 12?: "+stack2.pop());
        System.out.println("pop 10?: "+stack2.pop());
    }



    // SOLUTIONS
    /*

     */




}


