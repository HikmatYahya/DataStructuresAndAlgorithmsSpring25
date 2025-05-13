package dijkstra;

class DijkstraShortestPath {
	
	static final int NUM_VERTICES = 9;

	
	int findMinDistanceVertex(int distances[], Boolean shortestPathTreeSet[]) {
		
		int minDistance = Integer.MAX_VALUE;
		int minDistanceVertex = -1;

		for (int v = 0; v < NUM_VERTICES; v++) {
			if (!shortestPathTreeSet[v] && distances[v] <= minDistance) {
				minDistance = distances[v];
				minDistanceVertex = v;
			}
		}

		return minDistanceVertex;
	}

	// Print the constructed distance array
	void printSolution(int distances[]) {
		System.out.println("Vertex \t\t Distance from Source");
		for (int i = 0; i < NUM_VERTICES; i++) {
			System.out.println(i + " \t\t " + distances[i]);

		}
	}

	// Implement Dijkstra's single source shortest path algorithm for a graph
	// represented using adjacency matrix representation
	void dijkstra(int graph[][], int sourceVertex) {
		
		
		int[] distances = new int[NUM_VERTICES]; 
		Boolean[] shortestPathTreeSet = new Boolean[NUM_VERTICES];

		for (int i = 0; i < NUM_VERTICES; i++) {
			distances[i] = Integer.MAX_VALUE;
			shortestPathTreeSet[i] = false;
		}

		// Distance of source vertex from itself is always 0
		distances[sourceVertex] = 0;

		// Find shortest path for all vertices
		for (int count = 0; count < NUM_VERTICES - 1; count++) {
		
			int u = findMinDistanceVertex(distances, shortestPathTreeSet);

			// Mark the picked vertex as processed
			shortestPathTreeSet[u] = true;

			for (int v = 0; v < NUM_VERTICES; v++) {
			
				if (!shortestPathTreeSet[v] && 
						
						graph[u][v] != 0 && 
						
						distances[u] != Integer.MAX_VALUE && 
						
						distances[u] + graph[u][v] < distances[v]) {
					
					distances[v] = distances[u] + graph[u][v];
				}
			}
		}

		// Print the constructed distance array
		printSolution(distances);
	}

	// Driver's code
	public static void main(String[] args) {
		int graph[][] = new int[][] { { 0, 4, 0, 0, 0, 0, 0, 8, 0 },
									  { 4, 0, 8, 0, 0, 0, 0, 11, 0 },
									  { 0, 8, 0, 7, 0, 4, 0, 0, 2 }, 
									  { 0, 0, 7, 0, 9, 14, 0, 0, 0 }, 
									  { 0, 0, 0, 9, 0, 10, 0, 0, 0 },
									  { 0, 0, 4, 14, 10, 0, 2, 0, 0 }, 
									  { 0, 0, 0, 0, 0, 2, 0, 1, 6 }, 
									  { 8, 11, 0, 0, 0, 0, 1, 0, 7 },
									  { 0, 0, 2, 0, 0, 0, 6, 7, 0 } }
		;
		DijkstraShortestPath shortestPath = new DijkstraShortestPath();

		shortestPath.dijkstra(graph, 0);
	}
}
