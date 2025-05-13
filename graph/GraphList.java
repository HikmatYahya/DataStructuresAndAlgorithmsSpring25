package graph;
import java.util.LinkedList;

class Node {
    int destination;
    int weight;

    public Node(int destination, int weight) {
        this.destination = destination;
        this.weight = weight;
    }
}

public class GraphList {

    private LinkedList<Node>[] adjacencyList;
    private int numVertices;

    public GraphList(int numVertices) {
        this.numVertices = numVertices;
        adjacencyList = new LinkedList[numVertices];

        for (int i = 0; i < numVertices; i++) {
            adjacencyList[i] = new LinkedList<>();
        }
    }

    public void addEdge(int source, int destination) {
        adjacencyList[source].add(new Node(destination, 0));
    }

    public void addEdge(int source, int destination, int weight) {
        adjacencyList[source].add(new Node(destination, weight));
    }

    public void printList() {
        for (int i = 0; i < numVertices; i++) {
            System.out.print("Vertex " + i + " -> ");
            for (Node node : adjacencyList[i]) {
                System.out.print("[Dest: " + node.destination + ", Weight: " + node.weight + "] ");
            }
            System.out.println();
        }
    }
}
