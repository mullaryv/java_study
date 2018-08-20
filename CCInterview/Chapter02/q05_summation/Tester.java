import MyLibrary.LinkedListNode;

public class Tester {

    public static void checkSum (int[] a, int[] b) {
        LinkedListNode lA1 = Summation.createListNumber (a);
        LinkedListNode lB1 = Summation.createListNumber (b);


        LinkedListNode listAB = Summation.addLists(lA1, lB1);

		
        System.out.println (lA1.printForward() + "  (lA1)");
        System.out.println ("+");
        System.out.println (lB1.printForward() + "  (lB1)");
        System.out.println ("=\n" + listAB.printForward());

		int l1 = Summation.linkedListToInt(lA1);
		int l2 = Summation.linkedListToInt(lB1);
		int l3 = Summation.linkedListToInt(listAB);
		
		System.out.println("test:\n    " + l1 + " + " + l2 + " = " + l3);
		System.out.println("    " + l1 + " + " + l2 + " = " + (l1 + l2));
		System.out.println("--------");
    }

    public static void main(String[] args) {
        int[] a1 = {9,9,9};
        int[] b1 = {9,9,9,9,1};

        checkSum (a1, b1);

        int[] a2 = {9,9,9};
        int[] b2 = {1,0,0};

        checkSum (a2, b2);

        int[] a3 = {3,1};
        int[] b3 = {5,9,1};

        checkSum (a3, b3);
//        LinkedListNode listNull = addLists(null, null);
//        String s = "null";
//        if (listNull != null) {
//            s = listNull.printForward();
//        }
//        System.out.println ("listNull: " + s);
    }
}