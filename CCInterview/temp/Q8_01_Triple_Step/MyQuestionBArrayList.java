import java.util.*;

public class MyQuestionBArrayList {

  private static int calls = 0;

  private static ArrayList<Integer> ways;

  private static int countWaysArray (int s) {
    calls++;
//System.out.println (ways.size());
    if (ways.size() < s+1) {
      int sum = countWaysArray(s-1) + countWaysArray(s-2) + countWaysArray(s-3);
      ways.add(sum);
    }
    return ways.get(s);
  }

  static int countWays (int s) {
    if (s <= 0) return 0;

    ways = new ArrayList<Integer>(s+1);
    ways.add(0);
    ways.add(1);
    ways.add(2);

System.out.println(ways);
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