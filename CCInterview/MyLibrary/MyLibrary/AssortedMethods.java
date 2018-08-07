package MyLibrary;

public class AssortedMethods {

  public static LinkedListNode createLinkedListFromArray (int[] arr) {
    LinkedListNode head = null;
    LinkedListNode prev = null;

    for (int i=arr.length-1; i>=0; i--) {
      String t="prev: null";
      if (prev != null)
        t = "prev: " + prev.data;

      head = new LinkedListNode (i, null, null);
//System.out.println("i: " + i + ",  head: " + head.data);
//System.out.println("       " + t);
      head.setNext (prev); // this will also set head as "previous" to prev  
      prev = head;
    }
    return head;
  }
}