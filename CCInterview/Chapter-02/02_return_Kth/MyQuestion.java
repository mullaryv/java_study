public class MyQuestion {


  public static void printKthToLastA


	public static void main(String[] args) {
		int[] array = {0, 1, 2, 3, 4, 5, 6};
		LinkedListNode head = AssortedMethods.createLinkedListFromArray(array);
		for (int i = 0; i <= array.length + 1; i++) {
			printKthToLastA(head, i);
		}
	}
}