public class MyQuestionA {

  private static int calls = 0;

  static int countWays (int s) {
    calls++;
    if (s == 0) return 0;
    if (s == 1) return 1;
    if (s == 2) return 2;
    if (s == 3) return 4;
    if (s == 4) return 7;

    return countWays(s-1) + countWays(s-2) + countWays(s-3);
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