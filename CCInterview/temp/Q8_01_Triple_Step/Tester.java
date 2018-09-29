//package Q8_01_Triple_Step;

public class Tester {
	
	public static void main(String[] args) {
		for (int i = 0; i < 30; i++) {
			int c1 = QuestionB.countWays(i);
			int c2 = QuestionA.countWays(i);		

			int c3 = MyQuestionA.countWays(i);		
			int c4 = MyQuestionB.countWays(i);		

			System.out.println(i + ": " + 
                                           c1 + "(" + QuestionA.numberOfCalls()   + ") " + 
                                           c2 + "    " + 
                                           c3 + "(" + MyQuestionA.numberOfCalls() + ") " +
                                           c4 + "(" + MyQuestionB.numberOfCalls() + ")");
		}
	}



}
