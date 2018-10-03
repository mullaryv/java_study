public class Node {

    private Node[] adjacent;
    private int adj_count;
 
    public String name;
    public int state = 0;

    public Node(String n, int num) {
        adj_count = 0;
        adjacent = new Node[num];
        name = n;
    }

    public void addAdjacent(Node a) {
        if (adjacent.length > adj_count) {
            adjacent[adj_count] = a;
            adj_count++;
        } else {
            System.out.println ("cannot add adjacent");
        }
    }

    public Node[] getAdjacent() {
        return adjacent;
    }
}
