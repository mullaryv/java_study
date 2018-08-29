import java.util.Stack;

public class StackWithMin extends Stack<NodeWithMin> {

    public void push(int value) {
        int min = value;
        int top_min =min();
        if (top_min < min) {
            min = top_min;
        }
        super.push(new NodeWithMin(value, min));
    }

    public int min() {
        if (this.isEmpty()) {
            return Integer.MAX_VALUE;
        }
        return peek().min;
    }
}
