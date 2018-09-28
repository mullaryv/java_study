import MyLibrary.AssortedMethods;


public class URLify {


    public static int findLastCharacter (char[] chars) {
        int len = chars.length;
        for (int i=len-1; i>0; i--) {
            if (chars[i] != ' ') 
                return i;
        }
        return 0; 
    }


    public static void replaceSpaces (char[] chars, int tLength) {
        int j = chars.length-1;
        if (tLength < chars.length) {
            //System.out.println ("  !");
            //chars[tLength]='\0';
        }
        for (int i = tLength-1; i>= 0; i--, j--) {
            if (chars[i] != ' ') {
                chars[j] = chars[i];
            }
            else {
                chars[j]='0';
                chars[j-1]='2';
                chars[j-2]='%';
                j -= 2;
            }
        }
    }


    public static void main(String[] args) {
        String str = args[0];
//        String str = "Mr John Smith    ";
//        String str = "MrJohnSmith";
//        String str = "  MrJohnSmith        ";
        char[] arr = str.toCharArray();
        int trueLength = findLastCharacter(arr) + 1;
        System.out.println(trueLength);

        System.out.println("input:  [" + AssortedMethods.charArrayToString (arr) + "]");

        replaceSpaces(arr, trueLength);	
        String res = AssortedMethods.charArrayToString (arr);
        System.out.println("output: " + res);
    }
}
