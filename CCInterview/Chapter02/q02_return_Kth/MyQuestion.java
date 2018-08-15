import MyLibrary.*;

public class MyQuestion {

  // "runner"
  private static LinkedListNode nThToLast (LinkedListNode n, int k) {
    LinkedListNode runner = n;
    int cnt = 0;

    for (int i=0; i<k; i++) {
      if (runner == null) return null;
      runner = runner.next;
    }

    while (runner != null) {
      runner = runner.next;
      n = n.next;
    }
    return n;
  }


  public static void printKthToLastA (LinkedListNode n, int k) {
    LinkedListNode node = nThToLast (n, k);
    String nodeValue = node == null ? "null" : "" + node.data;
    System.out.println (k + " to last is " + nodeValue);
  }


  // recursive: doesn't return, just prints
  public static int printKthToLastB (LinkedListNode n, int k) {
    if (n == null) return 0;

    int num = printKthToLastB (n.next, k) + 1;

    if (num == k) {
      System.out.println (k + ":   " + n.data);
    } 
    return num;
  }


  // recursive: returns the node
  static class Counter {
    public int cnt;
    public Counter () {
      cnt = 0;
    }
  }

  public static LinkedListNode nToLastRecursive (LinkedListNode n, int k, Counter c) {
    if (n == null) return null;
    LinkedListNode current = nToLastRecursive (n.next, k, c);

    c.cnt++;
    if (c.cnt == k) {
      return n;
    } 
    
//    System.out.println (current == null ? "null" : "" + current.data);
    return current;
  }


  public static void printKthToLastC (LinkedListNode n, int k) {
    MyQuestion.Counter counter = new MyQuestion.Counter ();
    LinkedListNode node = nToLastRecursive (n, k, counter);
    String nodeValue = node == null ? "null" : "" + node.data;
    System.out.println (k + " to last is " + nodeValue);
  }


  public static void main(String[] args) {
    int[] array = {0, 1, 2, 3, 4, 5, 6};
//    int[] array = {0, 1, 2, 3};
    LinkedListNode head = AssortedMethods.createLinkedListFromArray(array);

    System.out.println ("\nrunner:");
    for (int i = 0; i <= array.length + 1; i++) {
      printKthToLastA (head, i);
    }

    System.out.println ("\nrecursion:");
    for (int i = 0; i <= array.length + 1; i++) {
      printKthToLastB (head, i);
    }

    System.out.println ("\nrecursion with counter class:");
//    printKthToLastC (head, 4);
    for (int i = 0; i <= array.length + 1; i++) {
      printKthToLastC (head, i);
    }

    System.out.println ();
    System.out.println (head.printForward ());
  }
}