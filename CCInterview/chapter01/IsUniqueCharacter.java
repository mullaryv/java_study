import java.util.HashMap;
import java.util.HashSet;

public class IsUniqueCharacter {

    // using HashMap
    public static boolean isUniqueChars1 (String str) {
        HashMap<Character, Boolean> hash = new HashMap<Character, Boolean> ();
        boolean isUnique = true;

        int len = str.length();
        for (int i=0; i<len; i++) {
            Character ch = new Character (str.charAt(i)); //actually, there's no need to create an object
            if (hash.get (ch) != null) {
                isUnique = false;
                break;
            }
            hash.put (ch, Boolean.TRUE);
        }
        return isUnique;
    }


    // using HashSet
    public static boolean isUniqueChars2 (String str) {
        HashSet<Character> hash = new HashSet<Character> ();
        boolean isUnique = true;

        int len = str.length();
        for (int i=0; i<len; i++) {
            char ch = str.charAt(i);
            if (hash.contains (ch)) {
                isUnique = false;
                break;
            }       
            hash.add (ch);
        }
        return isUnique;
    }


    // If no additional structures are allowed
    public static boolean isUniqueChars3 (String str) {
        HashSet<Character> hash = new HashSet<Character> ();
        boolean isUnique = true;

        int len = str.length();
        for (int i=0; i<len; i++) {
            for (int j=i+1; j<len; j++) {
                if (str.charAt(i) == str.charAt(j)) {
                    isUnique = false;
                    break;
                }
                //stop if already have found non-unique.
                if (!isUnique) break;
            }
        }
        return isUnique;
    }


    // If no additional structures are allowed, and alphabet contains letters only
    public static boolean isUniqueChars4 (String str) {
        boolean isUnique = true;

        int bitmask = 0;

        int len = str.length();
        for (int i=0; i<len; i++) {
            int ch = str.charAt(i) - 'a';
            //if ((bitmask | (1 << ch)) == bitmask) { // not very nice
            if ((bitmask & (1 << ch)) > 0) { // nice
                isUnique = false;
                break;
            }
            bitmask |= (1 << ch);
            //System.out.println ("bitmask: " + bitmask);
        }
        return isUnique;
    }


    public static void main(String[] args) {
        String[] words = {"abcde", "hello", "apple", "kite", "padle", "aabcdefghijklmnopqrstuvwxyz"};
        for (String word : words) {
            boolean wordA1 =  isUniqueChars1(word);
            boolean wordA2 =  isUniqueChars2(word);
            boolean wordA3 =  isUniqueChars3(word);
            boolean wordA4 =  isUniqueChars4(word);

            if ((wordA1 == wordA2) & (wordA1 == wordA3) & (wordA1 == wordA4)) {
                System.out.println(word + ": " + wordA1);
            } else {
                System.out.println(word + ": " + wordA1 + 
                                   "  (" + wordA2 + "," + wordA3 + "," + wordA4 + ")");
            }
        }
    }

}