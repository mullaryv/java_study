import java.util.Stack;
//import java.lang.Integer;


public class MyQueue<T> {

    private Stack<T> s1, s2; //one to accept and another to return

    public MyQueue() {
        s1 = new Stack<T>();
        s2 = new Stack<T>();
    }

    public void add(T value) {
        s1.push(value);
    }

    public T remove() {
        copyStack();
        return s2.pop();
    }

    public int size() {
        return s1.size() + s2.size();
    }

    public T peek() {
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
