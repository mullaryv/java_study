import java.util.Arrays;

public class CheckPermutation {

    public static void printIntArray (int[] arr) {
        int len = arr.length;
           for (int i=0; i<len; i++) {
           System.out.print (arr[i] + " ");
        }
    }


    // using sort; slow
    public static boolean permutation1 (String a, String b) {
        int lenA = a.length();
        int lenB = b.length();
        if (lenA != lenB) return false;

        char[] charsA = a.toCharArray();
        char[] charsB = b.toCharArray();

        Arrays.sort (charsA);    
        Arrays.sort (charsB);    

        for (int i=0; i<lenA; i++) {
            if (charsA[i] != charsB[i]) 
                return false;
        }
        return true;
    }


    // using array
    public static boolean permutation2 (String a, String b) {
        int lenA = a.length();
        int lenB = b.length();
        if (lenA != lenB) return false;

        int MAXS = 128;
        int[] chars = new int[MAXS]; //assuming ASCII only

        for (int i=0; i<lenA; i++)
            chars[a.charAt(i)]++;
//        printIntArray (chars);

        for (int i=0; i<lenA; i++)
            chars[b.charAt(i)]--;

        for (int i=0; i<MAXS; i++) {
            if (chars[i] != 0) return false;
        }
        return true;
    }


    // almost the same, but can return faster, in case second string has more "same" chars: abbcdefgh vs. abbbcdefg
    public static boolean permutation3 (String a, String b) {
        int lenA = a.length();
        int lenB = b.length();
        if (lenA != lenB) return false;

        int MAXS = 128;
        int[] chars = new int[MAXS]; //assuming ASCII only

        for (int i=0; i<lenA; i++)
            chars[a.charAt(i)]++;

        for (int i=0; i<lenA; i++) {
            chars[b.charAt(i)]--;
            if (chars[b.charAt(i)] < 0)
                return false;
        }
        // actually, not clear if it is any better, since I have to compare at every step
        return true;
    }

    
    public static void main(String[] args) {
        String[][] pairs = {{"apple", "papel"}, {"carrot", "tarroc"}, {"hello", "llloh"},
                            {"qwerty", "qwertz"}, {"abbbc", "bbbac"}, {"abbcdefgh", "abbbcdefg"}};
        for (String[] pair : pairs) {
            String word1 = pair[0];
            String word2 = pair[1];

            boolean anagram1 = permutation1 (word1, word2);
            System.out.println(word1 + ", " + word2 + ": " + anagram1);

            boolean anagram2 = permutation2 (word1, word2);
            boolean anagram3 = permutation3 (word1, word2);
            if ((anagram1 != anagram2) | (anagram1 != anagram3))
                System.out.println("different results for " + word1 + ", " + word2);

        }
    }
}
