import MyLibrary.LinkedListNode;
import MyLibrary.AssortedMethods;

public class ListIntersection {

    public static LinkedListNode findIntersection (LinkedListNode li1, LinkedListNode li2) {
        // check:
        if ((li1 == null) || (li2 == null)) {
            return null;
        } 

        int s1 = 0;
        LinkedListNode first = li1;
        while (first.next != null) {
            s1++;
            first = first.next;
        }

        int s2 = 0;
        LinkedListNode second = li2;
        while (second.next != null) {
            s2++;
            second = second.next;
        }

        // quick sanity check:
        if (first != second) {
            System.out.println ("! last node is not the same; quit");
            return null;
        } 

        first = (s1 < s2) ? li2 : li1;
        second = (s1 < s2) ? li1 : li2;
        int diff = (s1 < s2) ? s2 - s1 : s1 - s2;

        for (int i=0; i<diff; i++) {
           first = first.next;
        }

        // now they are aligned.
        while (first != second) {
            first = first.next;
            second = second.next;
        }
        return first;
    }


	public static void main(String[] args) {

        int[] vals = {-1, -2, 0, 1, 2, 3, 4, 5, 6, 7, 8};
        int[] vals2 = {12, 14, 15};

        LinkedListNode list1 = AssortedMethods.createLinkedListFromArray(vals);
        LinkedListNode list2 = AssortedMethods.createLinkedListFromArray(vals2);
        System.out.println(list1.printForward());
        System.out.println(list2.printForward());

        LinkedListNode res = findIntersection(list1, list2);
        System.out.println ("res-0: " + ((res == null) ? "null" : res.printForward()));

        // make intersection        
        list2.next.next = list1.next.next.next.next;
        res = findIntersection(list1, list2);
        System.out.println ("res-1: " + ((res == null) ? "null" : res.printForward()));

        list2.next.next = list1.next.next.next.next.next.next.next.next.next.next;        
        res = findIntersection(list1, list2);
        System.out.println ("res-2: " + ((res == null) ? "null" : res.printForward()));

    }

}