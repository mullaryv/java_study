import MyLibrary.LinkedListNode;

public class Palindrome {

    private static LinkedListNode front;

    //private static int cnt = 0;
    //public static int getCount () {
    //   return cnt;
    }//

    public static boolean isPalindrome (LinkedListNode node) {
        front = node;
        //cnt = 0;
        if (isPalindromeRecursion (node) == -1)
           return false;
        return true;
    }

    // recursive
    // -1 is false, 0 is true, 1 is true and stop
    private static int isPalindromeRecursion (LinkedListNode back) {
        int pal = 0;
        if (back.next != null) {
            pal = isPalindromeRecursion (back.next);
        }
        if (pal == -1)
            return -1;

        if ((pal == 1) || (front == back)) {
            return 1;
        }
        //cnt++;

        if (front.data == back.data) {
            front = front.next;
            if (front == back) {
                return 1;
            }
            return 0;
        }
        return -1;
    }
 
}