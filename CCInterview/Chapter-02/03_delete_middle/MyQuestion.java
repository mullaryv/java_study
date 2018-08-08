import MyLibrary.AssortedMethods;
import MyLibrary.LinkedListNode;

public class MyQuestion {

  public static void deleteNode (LinkedListNode n) {
    //at least not the last...
    if ((n == null) || (n.next == null))
      return;

    LinkedListNode nx = n.next;
    n.data = nx.data;
    n.setNext (nx.next);
    n = null; //do I need this?
  }

  public static void main(String[] args) {
    LinkedListNode head = AssortedMethods.randomLinkedList (10, 0, 10);
    System.out.println(head.printForward());

    deleteNode(head.next.next.next.next); // delete node 4
    System.out.println(head.printForward());
  }
}
