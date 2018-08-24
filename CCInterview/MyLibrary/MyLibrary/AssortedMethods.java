package MyLibrary;

import java.util.Random;

public class AssortedMethods {

  public static LinkedListNode createLinkedListFromArray (int[] arr) {
    if (arr == null) return null;
 
    LinkedListNode head = new LinkedListNode(arr[0]);
    LinkedListNode current = head;

    for (int i=1; i < arr.length; i++) {
      //current.next = new LinkedListNode (arr[i]);
      current.setNext (new LinkedListNode (arr[i]));
      current = current.next;
    }
    return head;

/*
    LinkedListNode head = null;
    LinkedListNode prev = null;

    for (int i=arr.length-1; i>=0; i--) {
      String t="prev: null";
      if (prev != null)
        t = "prev: " + prev.data;

      head = new LinkedListNode (arr[i]);
//System.out.println("i: " + i + ",  head: " + head.data);
//System.out.println("       " + t);
      head.setNext (prev); // this will also set head as "previous" to prev  
      prev = head;
    }
    return head;
*/
  }

  public static LinkedListNode randomLinkedList (int amount, int from, int to) {
    // can just create an array of randoms and then call createLinkedListFromArray method
    
    if ((amount < 0) || (from >= to)) //lazy to swap
      return null;

    LinkedListNode prev = null;
    LinkedListNode head = null;

    Random rand = new Random ();
      
    for (int i=amount; i>0; i--) {
      int r = rand.nextInt (to - from);
      head = new LinkedListNode (from + r);
      head.setNext (prev);
      prev = head;
    }
    return head;
  }

}