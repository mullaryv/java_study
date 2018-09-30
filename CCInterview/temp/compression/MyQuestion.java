public class MyQuestion {

  public static String compressA (String s) {
    int len = s.length();

    StringBuffer sb = new StringBuffer();

    for (int i=0; i<len; i++) {
      char ch = s.charAt(i);
      sb.append(ch);
      int count=1;
      for (int j=i+1; j<len; j++, i++) {
        if (s.charAt(j) == ch) {
          count++;
        } else {
          break;
        }
      }
      sb.append(count);
    }
    String res = sb.toString();
    if (res.length() < len)
      return res;
    return s;
  }


  public static void main (String[] args) {
//    String s = "aaabbaccccccc ddaa";
    String s = args[0];

    System.out.println ("input:      " + s);
    System.out.println ("compressed: " + compressA(s));
  }
}