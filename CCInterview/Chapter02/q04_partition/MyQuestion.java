//package Chapter_02.04_partition;

import MyLibrary.LinkedListNode;

public class MyQuestion {

    public static LinkedListNode partitionA (LinkedListNode n, int part) {
        int moves = 0;

        LinkedListNode head = n;
        LinkedListNode prev = null;
        LinkedListNode r = n;

        while (n != null) {
            moves++;
//            System.out.println ("n.data: " + n.data);
            if (n.data >= part) {
                //send runner
                r = n.next;
                LinkedListNode rprev = n;
                while (r != null) {
                    moves++;
//                    System.out.println ("  r.data: " + r.data);

                    if (r.data < part) { //switch
//                        System.out.println ("  found!");
                        LinkedListNode t = n.next;
                        n.next = r.next;
                        r.next = rprev == n ? n : t;
                        if (rprev != n) {
                            rprev.next = n;
                        }

                        if (prev != null) {
                            prev.next = r;
                        }
                        else {
                            head = r;
                            head.prev = null;
                        }
                        n = r;
                        break;
                    }
                    rprev = r;
                    r = r.next;
                }
            }
            prev = n;
            n = n.next;
        }
        System.out.println ("ha moves: " + moves);
        return head;
    }


    public static LinkedListNode partitionB (LinkedListNode n, int part) {
        int moves = 0;

        LinkedListNode head = n;
        LinkedListNode prev = null;
        LinkedListNode runner = n.next;
        LinkedListNode rprev = n;

        // find the first node that can be used as a replacement.
        while (runner != null) {
            moves++;
            if (runner.data < part) {
                break;
            }
            rprev = runner;
            runner = runner.next;
        }

        while (n != null) {
            moves++;
            if (n.data >= part) {
                //send runner
                LinkedListNode r = runner;
                while (r != null) {
                    moves++;

                    if (r.data < part) { //switch
                        runner = r.next;
                        LinkedListNode t = r.next;
                        r.next = n.next == r ? n : n.next;
                        n.next = t;
                        if (rprev != n) {
                            rprev.next = n;
                        }

                        if (prev != null) {
                            prev.next = r;
                        }
                        else {
                            head = r;
                        }
                        n = r;
                        rprev = rprev.next;
                        break;
                    }
                    rprev = r;
                    r = r.next;
                }
            }
            prev = n;
            n = n.next;
        }
        System.out.println ("hb moves: " + moves);
        return head;
    }


    public static LinkedListNode partitionC (LinkedListNode n, int part) {
        LinkedListNode before = null;
        LinkedListNode beforeEnd = null;
        LinkedListNode after = null;
        LinkedListNode afterEnd = null;

        while (n != null) {
            LinkedListNode next = n.next;
            n.next = null; // important!

            if (n.data < part) {
                // add to "before-list"
                if (before == null) {
                    before = n;
                    beforeEnd = before;
                }
                else {
                    beforeEnd.next = n;
                    beforeEnd = n;
                }
            }
            else {
                // add to "after-list"
                if (after == null) {
                    after = n;
                    afterEnd = after;
                }
                else {
                    afterEnd.next = n;
                    afterEnd = n;
                }
            }
            n = next;
        }
        //combine both lists
        beforeEnd.next = after;
        return before;
    }


    public static LinkedListNode changeWithNext (LinkedListNode n, int d) {

        LinkedListNode head = n;
        LinkedListNode prev = null;

        while (n != null) {
            if ((n.data == d) && (n.next != null)) {
                LinkedListNode temp = n.next;
                n.next = n.next.next;
                temp.next = n;
                if (prev != null) {
                    prev.next = temp;
                }
                else {
                    head = temp;
                }
                break;
            }
            prev = n;
            n = n.next;
        }
        return head;
    }



    public static LinkedListNode createLinkedList() {
    /* Create linked list */
        int[] vals = {12, 3, 5, 8, 4, 7, 10, 2, 1, 3, 100, 4, 5, 8, 2};
//        int[] vals = {1, 12, 3, 5, 8, 4, 7, 10, 2, 1, 3, 100, 4, 5, 8, 2};
//        int[] vals = {10, 9, 8, 7, 6, 5, 4, 3, 2, 1};

        LinkedListNode head = new LinkedListNode(vals[0], null, null);
        LinkedListNode current = head;
        for (int i = 1; i < vals.length; i++) {
          current = new LinkedListNode(vals[i], null, current);
        }
        return head;
    }


    public static void main(String[] args) {
        System.out.println(createLinkedList().printForward());
		

        LinkedListNode first = createLinkedList ();
        System.out.println("first: " + first.printForward());

//        LinkedListNode second = changeWithNext (first, 3);
//        System.out.println("second: " + second.printForward());

        LinkedListNode hA = partitionA (createLinkedList(), 5);
        System.out.println("ha:    " + hA.printForward());
        LinkedListNode hB = partitionB (createLinkedList(), 5);
        System.out.println("hB:    " + hB.printForward());
        LinkedListNode hC = partitionC (createLinkedList(), 5);
        System.out.println("hC:    " + hC.printForward());
  }

}