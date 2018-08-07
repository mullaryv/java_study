import MyLibrary.*;

import java.util.HashSet;

public class MyQuestion {


  static HashSet<Integer> hashNodes = new HashSet<Integer> ();
  
  public static void deleteDupsA (LinkedListNode head) {
    LinkedListNode current = head;

    // note: I will pretend that I don't have a link to the previous,
    // so I'm dealing with a single-linked list here
    LinkedListNode prev = head;
    LinkedListNode next = null;

    while (current != null) {
      if (hashNodes.contains (current.data)) {
        prev.setNext (current.next);
      }
      else {
        hashNodes.add (current.data);
        prev = current;
      }  
      current = current.next;
    }
  }


  static HashSet<Integer> hashNodesB = new HashSet<Integer> ();


  // try checking next, not current
  public static void deleteDupsB (LinkedListNode head) {
    LinkedListNode current = head;

    hashNodesB.add (current.data);

    // note: I will pretend that I don't have a link to the previous,
    // so I'm dealing with a single-linked list here
    LinkedListNode next = null;


    while (current.next != null) {
      next = current.next;

      if (hashNodesB.contains (next.data)) {
        next = next.next;
        //delete node:
        current.setNext (next);
        // in a double-linked list only:
        if (next != null)
          next.setPrevious (current); 
      }
      else {
        hashNodesB.add (next.data);
        current = current.next;
      }  
//      System.out.println ("  (2) prev=" + prev.data + ",  current=" + current.data + "\n"); 
    }
  }


  // without extra storage
  public static void deleteDupsC (LinkedListNode n) {

    while (n.next != null) {

      LinkedListNode runner = n;
      while (runner.next != null) {

        if (runner.next.data == n.data) {
          LinkedListNode temp = runner.next;
          runner.setNext (temp.next);
        }
        else {
          runner = runner.next;
        }  
      }
      n = n.next;
    }
  }


	public static void main(String[] args) {
		LinkedListNode first = new LinkedListNode(0, null, null);
		LinkedListNode head = first;
		LinkedListNode second = first;
		for (int i = 1; i < 8; i++) {
			second = new LinkedListNode(i % 2, null, null);
			first.setNext(second);
			second.setPrevious(first);
			first = second;
		}
//		System.out.println(head.printForward());

head.add (10); 
head.add (20);
head.add (30);
head.add (40);
head.add (10);
head.add (40); 
head.add (30);
head.add (20);
head.add (50);
head.add (10);
head.add (60);
head.add (0);
head.add (1);
head.add (1);
head.add (1);
head.add (0);


		LinkedListNode cloneA = head.clone();
		deleteDupsC(cloneA);
		System.out.println(cloneA.printForward());

        head.add (99);
		System.out.println(head.printForward());

//        System.out.print ("hash-set: ");
//		for (Integer h : hashNodes) {
//          System.out.print (h.toString() + " ");
//        }

		
	}

}