package shortestpathalgorithm;

class Edge {
	int source, destination, weight;

	public Edge(int s, int d, int w) {
		source = s;
		destination = d;
		weight = w;
	}
}

class Graph {
	int V, E; // Number of vertices and edges
	Edge[] edges;

	public Graph(int v, int e) {
		V = v;
		E = e;
		edges = new Edge[E];
	}

	public void bellmanFord(int src) {
		int[] dist = new int[V];

		for (int i = 0; i < dist.length; i++) {
			dist[i] = Integer.MAX_VALUE;
		}

		dist[src] = 0;

		// Step 1: Relax all edges V - 1 times
		for (int i = 1; i < V; i++) {

			for (int j = 0; j < E; j++) {

				int u = edges[j].source;
				int v = edges[j].destination;
				int w = edges[j].weight;
				if (dist[u] != Integer.MAX_VALUE && dist[u] + w < dist[v]) {
					dist[v] = dist[u] + w;
				}
			}
		}

		// Step 2: Check for negative-weight cycles
		for (int j = 0; j < E; ++j) {

			int u = edges[j].source;
			int v = edges[j].destination;
			int w = edges[j].weight;

			if (dist[u] != Integer.MAX_VALUE && dist[u] + w < dist[v]) {
				System.out.println("Graph contains a negative weight cycle");
				return;
			}
		}

		// Print the distances
		System.out.println("Vertex   Distance from Source");
		for (int i = 0; i < V; ++i) {
			System.out.println(i + "\t\t" + dist[i]);
		}
	}

}

public class bellmanFord {

	public static void main(String[] args) {
		int V = 5; // vertices
		int E = 8; // edges

		Graph g = new Graph(V, E);

		g.edges[0] = new Edge(0, 1, -1);
		g.edges[1] = new Edge(0, 2, 4);
		g.edges[2] = new Edge(1, 2, 3);
		g.edges[3] = new Edge(1, 3, 2);
		g.edges[4] = new Edge(1, 4, 2);
		g.edges[5] = new Edge(3, 2, 5);
		g.edges[6] = new Edge(3, 1, 1);
		g.edges[7] = new Edge(4, 3, -3);

		g.bellmanFord(0);
	}
}
