import java.util.LinkedList;

public class Tester {


    public static Graph createNewGraph() {
        Graph g = new Graph();        
        Node[] temp = new Node[6];

/*
        temp[0] = new Node("a", 3);
        temp[1] = new Node("b", 0);
        temp[2] = new Node("c", 0);
        temp[3] = new Node("d", 1);
        temp[4] = new Node("e", 1);
        temp[5] = new Node("f", 0);

        temp[0].addAdjacent(temp[1]);
        temp[0].addAdjacent(temp[2]);
        temp[0].addAdjacent(temp[3]);
        temp[3].addAdjacent(temp[4]);
        temp[4].addAdjacent(temp[5]);
*/
/*
        temp[0] = new Node("o", 2);
        temp[1] = new Node("a", 2);
        temp[2] = new Node("b", 2);
        temp[3] = new Node("c", 0);
        temp[4] = new Node("d", 0);
        temp[5] = new Node("f", 0);

        temp[0].addAdjacent(temp[1]);
        temp[0].addAdjacent(temp[2]);

        temp[1].addAdjacent(temp[3]);
        temp[1].addAdjacent(temp[4]);

        temp[2].addAdjacent(temp[4]);
        temp[2].addAdjacent(temp[5]);
*/
        temp[0] = new Node("a", 2);
        temp[1] = new Node("b", 0);
        temp[2] = new Node("c", 0);

        temp[3] = new Node("c", 2);
        temp[4] = new Node("d", 0);
        temp[5] = new Node("f", 0);

        temp[0].addAdjacent(temp[1]);
        temp[0].addAdjacent(temp[2]);

        temp[3].addAdjacent(temp[4]);
        temp[3].addAdjacent(temp[5]);

        for (int i = 0; i < 6; i++) {
            g.addNode(temp[i]);
        }
        return g;

    }

    public static boolean search (Graph g, Node start, Node end) {
        LinkedList<Node> qnodes = new LinkedList<Node>();
        qnodes.add(start);

        while (!qnodes.isEmpty()) {
            printQueue(qnodes);
            Node n = qnodes.remove();
            if (n == end) {
                return true;
            }
            Node[] adjacents = n.getAdjacent();
            for (Node a : adjacents) {
                if (a.state == 0) {
                    a.state = 1;
                    qnodes.add(a);
                }
            }
        }
        return false;
    }

    public static void printQueue(LinkedList<Node> q) {
        System.out.print("queue: ");
        for (Node n : q)
            System.out.print(n.name + " ");
        System.out.println();
    }

    public static void main(String a[]) {
        Graph g = createNewGraph();
        Node[] n = g.getNodes();
        Node start = n[0];
        Node end = n[5];
        System.out.println("start: " + start.name);
        System.out.println("end: " + end.name);

        System.out.println(search(g, start, end));

    }
}
