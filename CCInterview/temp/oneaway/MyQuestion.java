public class MyQuestion {

  public static boolean oneEditAwayC (String a, String b) {
    int lenA = a.length();
    int lenB = b.length();
   
    int diff = lenA - lenB;
    if (diff < -1 || diff > 1)
      return false;

    if (lenB == lenA)
      return editReplacement (a, b);

    return deleteReplacement (a, b);
  }

  public static boolean editReplacement (String a, String b) {
    int len = a.length();
    boolean foundDiff = false;
 
    for (int i=0; i<len; i++) {
      if (a.charAt(i) != b.charAt(i)) {
        if (foundDiff)
          return false;
        foundDiff = true;
      }
    }
    return true;
  }

  public static boolean deleteReplacement (String a, String b) {

    String first = a;
    String second = b;

    if (a.length() < b.length()) {
      first = b;
      second = a;
    }

    boolean foundDiff = false;
//    System.out.println ("first: " + first + ", second:" + second); 
    for (int i=0, j=0; i<first.length() && j<second.length(); i++, j++) {
//      System.out.println ("  i: " + i + ", j:" + j + 
//                          "  f: " + first.charAt(i) + ", s:" + second.charAt(j)); 
      if (first.charAt(i) != second.charAt(j)) {
        if (foundDiff)
          return false;
        foundDiff = true;
        j--; //keep same letter from the smaller string for the next comparison
//        System.out.println ("       count:" + count); 
      }
    }
    return true;
  }


  public static void main(String[] args) {
    String[] test = {"", "d", "true"};
//    String[] test = {args[0], args[1], args[2]};
    String a = test[0];
    String b = test[1];
    boolean expected = test[2].equals("true");

    boolean a_b = oneEditAwayC (a, b);
    System.out.println (a_b + "; expected:" + expected);
    boolean b_a = oneEditAwayC (b, a);
    System.out.println (b_a + "; expected:" + expected);
  }
 
}