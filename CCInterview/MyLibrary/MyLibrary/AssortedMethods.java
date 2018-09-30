package MyLibrary;

import java.util.Random;

public class AssortedMethods {

    public static String charArrayToString (char[] array) {
        StringBuilder buffer = new StringBuilder(array.length);
        for (char c : array) {
            if (c == 0)
                break;
            buffer.append(c);
        }
        return buffer.toString();
    }


    public static String intArrayToString (int[] array) {
        StringBuilder buffer = new StringBuilder(array.length);
        for (int c : array) {
            buffer.append(c);
            buffer.append(' ');
        }
        return buffer.toString();
    }


    public static LinkedListNode createLinkedListFromArray (int[] arr) {
        if (arr == null) return null;
 
        LinkedListNode head = new LinkedListNode(arr[0]);
        LinkedListNode current = head;

        for (int i=1; i < arr.length; i++) {
             //current.next = new LinkedListNode (arr[i]);
            current.setNext (new LinkedListNode (arr[i]));
            current = current.next;
        }
        return head;

    }


  public static LinkedListNode randomLinkedList (int amount, int from, int to) {
    // can just create an array of randoms and then call createLinkedListFromArray method
    
    if ((amount < 0) || (from >= to)) //lazy to swap
      return null;

    LinkedListNode prev = null;
    LinkedListNode head = null;

    Random rand = new Random ();
      
    for (int i=amount; i>0; i--) {
      int r = rand.nextInt (to - from);
      head = new LinkedListNode (from + r);
      head.setNext (prev);
      prev = head;
    }
    return head;
  }


  public static String arrayToString(int[] arr) {
    if ((arr == null) || (arr.length == 0))
      return "";

    int len = arr.length;
    StringBuffer sb = new StringBuffer();
    sb.append(arr[0]); 
    for (int i=1; i<len; i++) {
      sb.append(", ");
      sb.append(arr[i]);
    }
    return sb.toString();
  }


    public static int randomIntInRange(int from, int to) {
        int r = (int) (Math.random() * (to - from + 1));
        return from + r;
    }

    // copy from the book
    public static void printMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] < 10 && matrix[i][j] > -10) {
                    System.out.print(" ");
                }
                if (matrix[i][j] < 100 && matrix[i][j] > -100) {
                    System.out.print(" ");
                }
                if (matrix[i][j] >= 0) {
                    System.out.print(" ");
                }
                System.out.print(" " + matrix[i][j]);
            }
            System.out.println();
        }
    }


    // copy from the book
    public static int[][] randomMatrix(int M, int N, int min, int max) {
        int[][] matrix = new int[M][N];
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                matrix[i][j] = randomIntInRange(min, max);
            }
        }
        return matrix;
    }


    public static boolean matricesAreEqual(int[][] m1, int[][] m2) {
        if (m1.length != m2.length || m1[0].length != m2[0].length) {
            return false;
        }
        
        for (int k = 0; k < m1.length; k++) {
            for (int j = 0; j < m1[0].length; j++) {
                if (m1[k][j] != m2[k][j]) {
                    return false;
                }
            }
        }    
        return true;
    }

    
    public static int[][] cloneMatrix(int[][] matrix) {
        int[][] c = new int[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                c[i][j] = matrix[i][j];
            }
        }
        return c;
    }
}