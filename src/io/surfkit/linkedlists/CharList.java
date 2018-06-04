package io.surfkit.linkedlists;


public class CharList{
    static class Node{
        Node(char item){ data = item; }
        public Node next;
        public char data;
    }
    CharList( char item ){ head = new Node(item); }
    CharList( char[] items ){
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
