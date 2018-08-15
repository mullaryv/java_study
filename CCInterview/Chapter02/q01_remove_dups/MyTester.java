//package Q2_01_Remove_Dups;

import MyLibrary.LinkedListNode;

public class MyTester {


	public static void main(String[] args) {
		LinkedListNode first = new LinkedListNode(0, null, null);
		LinkedListNode head = first;
		LinkedListNode second = first;
		for (int i = 1; i < 20; i++) {
			second = new LinkedListNode(i % 3, null, null);
			first.setNext(second);
			second.setPrevious(first);
			first = second;
		}
//		System.out.println(head.printForward());

head.add (10); 
head.add (20);
head.add (30);
head.add (40);
head.add (10);
head.add (40); 
head.add (30);
head.add (20);
head.add (50);
head.add (10);
head.add (60);
head.add (0);
head.add (1);

		LinkedListNode cloneA = head.clone();
		LinkedListNode cloneB = head.clone();
		LinkedListNode cloneC = head.clone();

		MyQuestion.deleteDupsA(cloneA);
		MyQuestion.deleteDupsB(cloneB);
		MyQuestion.deleteDupsC(cloneC);

        head.add (9);
		System.out.println(head.printForward());
		
		System.out.println(cloneA.printForward());
		System.out.println(cloneB.printForward());
		System.out.println(cloneC.printForward());
	}

}
