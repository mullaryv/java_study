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


  // recursive
  public static int printKthToLastB (LinkedListNode n, int k) {
    if (n == null) return 0;

    int num = printKthToLastB (n.next, k) + 1;

    if (num == k) {
      System.out.println (k + ":   " + n.data);
    } 
    return num;
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

    System.out.println (head.printForward ());
  }
}