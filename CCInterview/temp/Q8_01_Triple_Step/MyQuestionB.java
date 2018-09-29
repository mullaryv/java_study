import java.util.*;

public class MyQuestionB {

  private static int calls = 0;

  private static int[] ways;

  private static int countWaysArray (int s) {
    calls++;
    if (ways[s] > 0) return ways[s];
    else {
      int sum = countWaysArray(s-1) + countWaysArray(s-2) + countWaysArray(s-3);
      ways[s] = sum;
      return sum;
    }
  }

  static int countWays (int s) {
    if (s <= 0) return 0;

    ways = new int[s+1];
    ways[0] = 0; //not important
    ways[1] = 1;
    if (s > 1)
      ways[2] = 2;
    if (s > 2)
      ways[3] = 4;

    return countWaysArray(s);
  }

  public static int numberOfCalls () {
    return calls;
  }

  public static void main (String[] args) {
    //int k=10;
    //System.out.println (args[0]);
    int k = Integer.valueOf(args[0]);
    System.out.println("steps: " + k + ", ways: " + countWays(k));
    System.out.println ("number of calls: " + numberOfCalls());
  }  

}