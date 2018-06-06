package io.surfkit.linkedlists;

/*
Return Kth to Last: Implement an algorithm to find the kth to last element of a singly linked list.
 */

import java.util.ArrayList;

public class Question2_6 {


    public static int getListLen(CharList l){
        int len=1;
        for(CharList.Node i=l.head; i.next != null; i = i.next )len++;
        return len;
    }

    public static CharList.Node reverse(CharList.Node n){
        ArrayList<CharList.Node> xs = new ArrayList<>();
        for(CharList.Node i=n; i!=null; i=i.next)xs.add(i);
        for(int i=xs.size()-1; i>=1; i--){
            xs.get(i).next = xs.get(i-1);
        }
        xs.get(0).next = null;
        return xs.get(xs.size()-1);
    }

    public static  boolean listCmp(CharList.Node a, CharList.Node b){
        // check for null
        CharList.Node it = b;
        for(CharList.Node i=a; i.next != null; i = i.next){
            if(it == null)return false;
            System.out.println("a:" +i.data);
            System.out.println("b:" +it.data);
            if(i.data != it.data)return false;
            it = it.next;
        }
        return true;
    }

    public static void print(CharList.Node a){
        for(CharList.Node i=a; i!=null; i=i.next)System.out.print(i.data);
    }

    public static  boolean palindrome(CharList list){
        int len = getListLen(list);
        System.out.println("len:" +len);
        int half = len/2;
        CharList.Node it = list.head;
        for(int i=0;i<half; i++)it = it.next;
        if( len % half == 1)it = it.next;
        return listCmp(reverse(it), list.head );
    }


    public static void main(String[] args) {
        // write your code here
        CharList a = new CharList( new char[]{'a', 'b', 'c', 'c', 'b', 'a'} );
        System.out.println("palindrome: " + palindrome(a));

        CharList b = new CharList( new char[]{'a', 'b', 'c', 'd', 'c', 'b', 'a'} );
        System.out.println("palindrome: " + palindrome(b));

    }



    /*  BOOK Solution A


    import CtCILibrary.LinkedListNode;

public class QuestionA {
	public static boolean isPalindrome(LinkedListNode head) {
		LinkedListNode reversed = reverseAndClone(head);
		return isEqual(head, reversed);
	}

	public static LinkedListNode reverseAndClone(LinkedListNode node) {
		LinkedListNode head = null;
		while (node != null) {
			LinkedListNode n = new LinkedListNode(node.data); // Clone
			n.next = head;
			head = n;
			node = node.next;
		}
		return head;
	}

	public static boolean isEqual(LinkedListNode one, LinkedListNode two) {
		while (one != null && two != null) {
			if (one.data != two.data) {
				return false;
			}
			one = one.next;
			two = two.next;
		}
		return one == null && two == null;
	}

	public static void main(String[] args) {
		int length = 9;
		LinkedListNode[] nodes = new LinkedListNode[length];
		for (int i = 0; i < length; i++) {
			nodes[i] = new LinkedListNode(i >= length / 2 ? length - i - 1 : i, null, null);
		}

		for (int i = 0; i < length; i++) {
			if (i < length - 1) {
				nodes[i].setNext(nodes[i + 1]);
			}
			if (i > 0) {
				nodes[i].setPrevious(nodes[i - 1]);
			}
		}
		// nodes[length - 2].data = 9; // Uncomment to ruin palindrome

		LinkedListNode head = nodes[0];
		System.out.println(head.printForward());
		System.out.println(isPalindrome(head));
	}

}


     */

}


