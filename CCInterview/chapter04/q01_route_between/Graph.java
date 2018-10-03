import java.util.ArrayList;

public class Graph {

    private ArrayList<Node> nodes;

    public Graph() {
        nodes = new ArrayList<Node>();
    }

    public void addNode(Node n) {
        nodes.add(n);
    }

    public Node[] getNodes() {
        return nodes.toArray(new Node[nodes.size()]);
    }
}