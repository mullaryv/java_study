import MyLibrary.AssortedMethods;


public class PalindromePermutation {

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
                chars[ind] ^= 1;
            }
        }
        // System.out.println ("chars: " + intArrayToString (chars));

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
        }
//        System.out.println ("chars: " + bitvalue);

        // check if we have no more than one bit set:
        int res = (bitvalue & (bitvalue - 1));
        return (res == 0);
    }


    public static void main(String[] args) {
        String[] strings = {"Rats live on no evil star",
                       "A man, a plan, a canal, panama",
                       "Lleve",
                       "Tacotac",
                       "A roza upala na lapu Azora",
                       "A roza upala na lapu Azoras",
                       "asda",
                       "qwe ?? qwe asd asd"};

        if (args.length > 0) {
            strings = args;
        }

        for (String s : strings) {
            boolean d = isPermutationOfPalindromeD (s);
            boolean e = isPermutationOfPalindromeE (s);
            boolean f = isPermutationOfPalindromeF (s);

            if (d == e && e == f){
                System.out.println("Agree: " + d + (d ? " -- palindrome: " + s : ""));
            } else {
                System.out.println("Disagree: " + d + ", " + e + ", " + f);
            }
        }

    }
}