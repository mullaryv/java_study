public class OneAway {

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
//        System.out.println ("first: " + first + ", second:" + second); 
        for (int i=0, j=0; i<first.length() && j<second.length(); i++, j++) {
//      System.out.println ("  i: " + i + ", j:" + j + 
//                          "  f: " + first.charAt(i) + ", s:" + second.charAt(j)); 
            if (first.charAt(i) != second.charAt(j)) {
                if (foundDiff)
                    return false;
                foundDiff = true;
                j--; //keep same letter from the smaller string for the next comparison
//              System.out.println ("       count:" + count); 
            }
        }
        return true;
    }


	public static void main(String[] args) {
		String[][] tests = {{"a", "b", "true"}, 
				{"", "d", "true"},
				{"d", "de", "true"},
				{"pale", "pse", "false"},
				{"acdsfdsfadsf", "acdsgdsfadsf", "true"},
				{"acdsfdsfadsf", "acdsfdfadsf", "true"},
				{"acdsfdsfadsf", "acdsfdsfads", "true"},
				{"acdsfdsfadsf", "cdsfdsfadsf", "true"},
				{"adfdsfadsf", "acdfdsfdsf", "false"},
				{"adfdsfadsf", "bdfdsfadsg", "false"},
				{"adfdsfadsf", "affdsfads", "false"},
				{"pale", "pkle", "true"},
				{"pkle", "pable", "false"}};

		for (int i = 0; i < tests.length; i++) {
			String[] test = tests[i];
			String a = test[0];
			String b = test[1];
			boolean expected = test[2].equals("true");

			System.out.println(a + ", " + b + " (" + oneEditAwayC (a, b) + ")");
			System.out.println(b + ", " + a + " (" + oneEditAwayC (b, a) + ")");
		}
		
	}
 
}