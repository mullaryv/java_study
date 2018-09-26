import java.util.Stack;

public class StackWithMin2 extends Stack<Integer> {

    private Stack<Integer> min_storage;

    public StackWithMin2() {
        min_storage = new Stack<Integer>(); 
    }

    public void push(int value) {
        int top_min =min();
        if (value <= top_min) { //equality so that I won't have issues when doing .pop
        //could save some space and do not add duplicates, but then I'd have to peek() when doing .pop
            min_storage.push(value);
        }
        super.push(value);
    }

    public Integer pop() {
        int top_min = min();
        int value = super.pop();
        if (value == top_min) {
            min_storage.pop();
        }
        return value;
    }

    public int min() {
        if (min_storage.isEmpty()) {
            return Integer.MAX_VALUE;
        }
        return min_storage.peek();
    }
}
