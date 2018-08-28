import MyLibrary.AssortedMethods;


public class RotateArray {

    public static void rotateArray (int[] arr, int r) {
        // some precautions first
        if (arr == null)
            return;
        int len = arr.length;
        r %= len; //prevent cyclical rotation
        if (r == 0)
            return;

/*
        for (int i=0; i< r; i++) {
            int temp = arr[len - r + i];
            for (int j = 0; j <= len / r; j++) {
                int k = i+ r * j;
                if (k >= len)
                    k = k % len;
                int t = arr[k];
                arr[k] = temp;
                temp = t;
            }
        }
*/
        int start = len - r; //first element to copy; it will necessarily appear in the zero-th position in the result
        int temp = arr[start];
        int k = 0; // position of a first element to be replaces

        for (int cnt=0; cnt < len; cnt++) { //will do exactly as many steps as number of elements in array
            int t = arr[k];
            arr[k] = temp;

            //prepare for the next iteration:
            if ((k == start) && (k < len-1)) { // met element that already was rotated
                k++;
                start++;
                temp = arr[k];
            } else {
                temp = t;
            }

            k += r;
            if (k >= len)
                k -= len;
        }
    }


    public static void main(String[] args) {

        int[] a = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20};
        String s = AssortedMethods.arrayToString(a);  
        System.out.println (s);

//        rotateArray(a, 4);
//        System.out.println ("a: " + AssortedMethods.arrayToString (a));

        for (int i=0; i<20; i++) {
            int[] b = a.clone();
            rotateArray(b, i);
            System.out.println ("i=" + i + ": " + AssortedMethods.arrayToString (b));
        }
    }

}
