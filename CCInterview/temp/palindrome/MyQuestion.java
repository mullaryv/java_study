public class MyQuestion {

  public static String charArrayToString (char[] array) {
    StringBuilder buffer = new StringBuilder(array.length);
    for (char c : array) {
    if (c == 0) {
      break;
    }
    buffer.append(c);
    buffer.append(' ');
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


  public static boolean isPermutationOfPalindromeD (String str) {
    int len = str.length();

    // assuming ASCII alphabet: 
    int MAXS = 128;
    int[] chars = new int[MAXS];
    for (int i=0; i<len; i++) {
      char ch = Character.toUpperCase (str.charAt(i));
      if ((ch == ',') | (ch == ' '))
        continue;  
      if (chars[ch]==1)
        chars[ch]=0;
      else 
        chars[ch]=1;
    }
//    System.out.println (intArrayToString (chars));

    int count = 0;
    for (int i=0; i<MAXS; i++) {
      if (chars[i] > 0) count++;
    }

    return (count < 2);
  }


  // less space, a bit more efficient
  public static boolean isPermutationOfPalindromeE (String str) {
    int len = str.length();

    // assuming letters only
    int nvA = Character.getNumericValue ('a');
    int nvZ = Character.getNumericValue ('z');

    int MAXS = nvZ - nvA + 1;
    int[] chars = new int[MAXS];

    for (int i=0; i<len; i++) {
      char ch = str.charAt(i);
      
      int nv = Character.getNumericValue (ch);
      if ((nvA <= nv) && (nv <= nvZ)) {
        int ind = nv - nvA;
//        if (chars[ind]==1)
//          chars[ind]=0;
//        else 
//          chars[ind]=1;
          chars[ind] ^= 1;
      }
//      System.out.println ("i: " + intArrayToString (chars));

    }
//    System.out.println ("chars: " + intArrayToString (chars));

    int count = 0;
    for (int i=0; i<MAXS; i++) {
      if (chars[i] > 0) count++;
    }

    return (count < 2);
  }


  // more space efficient, using bit operations
  public static boolean isPermutationOfPalindromeF (String str) {
    int len = str.length();

    // assuming letters only
    int nvA = Character.getNumericValue ('a');
    int nvZ = Character.getNumericValue ('z');

    int bitvalue = 0;

    for (int i=0; i<len; i++) {
      char ch = str.charAt(i);
      
      int nv = Character.getNumericValue (ch);
      if ((nvA <= nv) && (nv <= nvZ)) {
        int ind = nv - nvA;
        int mask = 1<<ind;
        bitvalue ^= mask;
      }
//      System.out.println ("i: " + i + "  bitvalue=" + bitvalue);

    }
//    System.out.println ("chars: " + bitvalue);

    int res = (bitvalue & (bitvalue - 1));
    return (res == 0);
  }


  public static void main(String[] args) {
//    String s = "Rats live on no evil star"; //Rats live on  no evil star
    String s = "asda";

    System.out.println("string: " + s);
    boolean d = isPermutationOfPalindromeD (s);
    boolean e = isPermutationOfPalindromeE (s);
    boolean f = isPermutationOfPalindromeF (s);
    System.out.println("D -- " + d);
    System.out.println("E -- " + e);
    System.out.println("F -- " + f);
  }

}