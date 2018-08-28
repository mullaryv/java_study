import MyLibrary.LinkedListNode;

public class LoopDetection {

    public static LinkedListNode FindLoopBeginning (LinkedListNode head) {
        if ((head == null) || (head.next == null)) return null;

        // first, run two pointers, find where they meet.
        LinkedListNode slow = head;
        LinkedListNode fast = head;

        // first, start running pointers, makes first step manually.
        fast = fast.next;
        if (fast == slow) {
            return null; //what to do in this case?
        }
        slow = slow.next;
        fast = fast.next;

        // find an intersection point
        int path_slow = 1;
        boolean half_way = false;

        while (fast != null) {
            slow = slow.next;
            path_slow++;  // there's no need to count, but I was interested in it.    
            fast = fast.next;
            if (fast == null) { // reached an end without intersection
                path_slow = 0;
                break;
            }
            if (fast == slow) {
                half_way = true;
                break;
            }
            fast = fast.next;
            if (fast == slow) {
                break;
            }
        }

        // if no intersection detected
        if (path_slow == 0) return null;

        // advance head if pointers converged "half-way"
        if (half_way) {      
            head = head.next;
        } 

        // go from beginning and from the place where fast pointer ended up.
        while (head != fast) {
            head = head.next;
            fast = fast.next;
        }

        System.out.println ("number of (slow) steps: " + path_slow + "  (half way: " + half_way + ")");
        return fast;
    }



    public static void main(String[] args) {
        int list_length = 99;
//        int k = 21;

        // Create linked list
        LinkedListNode[] nodes = new LinkedListNode[list_length];
        for (int i = 0; i < list_length; i++) {
            nodes[i] = new LinkedListNode(i, null, i > 0 ? nodes[i - 1] : null);
        }
        System.out.println (nodes[0].printForward());


        // Create loop at each possible node, find it.;
        for (int k = 1; k< list_length; k++) {
            LinkedListNode loop_node = nodes[list_length - k];    
            System.out.println ("k: " + k + ";  set loop at " + (list_length - k) + 
                                " (data: " + loop_node.data + ")");
            nodes[list_length - 1].next = loop_node;
        
            LinkedListNode loop = FindLoopBeginning(nodes[0]);
            System.out.println(loop == null ? " -- no cycle." : " -- loop at: " + loop.data);
            if (loop.data != loop_node.data) {
                System.out.println ("ERROR!!!");
            }
        }
    }
}