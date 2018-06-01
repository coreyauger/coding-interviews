package io.surfkit.linkedlists;

public class List{
    class Node{
        Node(int item){ data = item; }
        public Node next;
        public int data;
    }
    List( int item ){ head = new Node(item); }
    List( int[] items ){
        head = new Node(items[0]);
        Node iter = head;
        for( int i=1; i<items.length; i++){
            iter.next = new Node(items[i]);
            iter = iter.next;
        }
    }

    public Node head;

    @Override
    public String toString(){
        Node iter = head;
        StringBuilder str = new StringBuilder();
        str.append("\n[");
        while(iter != null){
            System.out.print(iter.data);
            str.append(iter.data+", ");
            iter = iter.next;
        }
        str.append("]");
        return str.toString();
    }
}
