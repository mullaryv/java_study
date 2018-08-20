import MyLibrary.LinkedListNode;

public class Summation {

    public static LinkedListNode createListNumber (int[] arr) {
        if ((arr == null) || (arr.length == 0)) {
            return null;
        }

        LinkedListNode head = new LinkedListNode(arr[0]);
        LinkedListNode n = head;

        int len = arr.length;
        for (int i=1; i<len; i++) {
            n = new LinkedListNode (arr[i], null, n);
        }
        return head;
    }

    public static int linkedListToInt (LinkedListNode n) {
        if (n==null) return -1;
  
        int r = 0;
        int k = 1;
        while (n != null) {
            r += k*n.data;
            n = n.next;
            k *= 10;
        }
        return r;
    }

    // Summation if number is encoded "backwards" (starting from the lower digit)
    public static LinkedListNode addLists (LinkedListNode a, LinkedListNode b) {

        int rem = 0;
        LinkedListNode c = null;
        LinkedListNode res = null;

        while ((a != null) || (b != null)) {
            int s = 0;
            if (a != null) {
                s += a.data;
                a = a.next;
            }
            if (b != null) {
                s += b.data;
                b = b.next;
            }

            s += rem;
            rem = s / 10;
            s %= 10; 

            if (c == null) { //i.e. this is first digit
                c = new LinkedListNode (s);
                res = c;
            } else {
                LinkedListNode t = new LinkedListNode(s, null, c);
                t.data = s;
                c = t;
            }
            //System.out.println ("s="+s+",  rem="+rem + ",  c.data: " + c.data); 
        }

        // if remainder is non-zero, add one more node
        if (rem != 0) {
            c = new LinkedListNode(rem, null, c);
        } 
        return res;
    }


    // if number is encoded in a natural order (starting from the high digit)
    public static LinkedListNode addLists (LinkedListNode a, LinkedListNode b, int rem) {

        int s = 0;
//        LinkedListNode c = null;
        LinkedListNode res = null;

        while ((a != null) || (b != null)) {
            if (a != null) {
                a = a.next;
            }
            if (b != null) {
                b = b.next;
            }
            res = addLists (a, b, rem);
        }
        
        s += (a != null) ? a.data : 0;
        s += (b != null) ? b.data : 0;
        s += rem;

        rem = s / 10;
        s %= 10; 

        res = new LinkedListNode(s, null, res);
        return res;

/*
        if (c == null) { //i.e. this is first digit
            c = new LinkedListNode (s);
            res = c;
        } else {
            LinkedListNode t = new LinkedListNode(s, null, c);
            t.data = s;
            c = t;
        }
        //System.out.println ("s="+s+",  rem="+rem + ",  c.data: " + c.data); 

        // if remainder is non-zero, add one more node
        if ((rem != 0) && (lenDiff==0)) {
            c = new LinkedListNode(rem, null, c);
        } 
        return res;
*/
    }


    public static void main(String[] args) {
        int[] a1 = {2,0,0};
        int[] b1 = {1,0};
        LinkedListNode lA1 = createListNumber (a1);
        LinkedListNode lB1 = createListNumber (b1);


        LinkedListNode listAB = addLists(lA1, lB1, 0);

		
        System.out.println (lA1.printForward() + "  (lA1)");
        System.out.println ("+");
        System.out.println (lB1.printForward() + "  (lB1)");
        System.out.println ("=\n" + listAB.printForward());

    }
    
}