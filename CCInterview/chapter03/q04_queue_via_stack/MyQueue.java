import java.util.Stack;
//import java.lang.Integer;

public class MyQueue<Integer> {

    private Stack<Integer> s1, s2; //one to accept and another to return

    public MyQueue() {
        s1 = new Stack<Integer>();
        s2 = new Stack<Integer>();
    }

    public void add(Integer value) {
        s1.push(value);
    }

    public Integer remove() {
        copyStack();
        return s2.pop();
    }

    public int size() {
        return s1.size() + s2.size();
    }

    public Integer peek() {
        copyStack();
        return s2.peek();
    }

    private void copyStack () {
        if (s2.isEmpty()) {
            if (s1.isEmpty()) { //what to do?
            }
            while (!s1.isEmpty()) {
                s2.push(s1.pop());
            }
        } 
    }
}
