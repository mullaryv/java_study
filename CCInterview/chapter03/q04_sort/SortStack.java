import java.util.Stack;
import MyLibrary.AssortedMethods;

public class SortStack {

    public static void sort (Stack<Integer> origin) {
        Stack<Integer> dest = new Stack<Integer>();

        while (!origin.isEmpty()) {
            int current = origin.pop();
            while (!dest.isEmpty() && dest.peek() > current) {
                origin.push(dest.pop());
            } 
            dest.push(current);
        }

        while (!dest.isEmpty()) {
            origin.push(dest.pop());
        }
    }



    public static void main(String [] args) {
        Stack<Integer> s = new Stack<Integer>();
        for (int i = 0; i < 10; i++) {
            int r = AssortedMethods.randomIntInRange(0, 1000);
            s.push(r);
        }
        
        sort(s);
        
        while(!s.isEmpty()) {
            System.out.println(s.pop());
        }
    }

}