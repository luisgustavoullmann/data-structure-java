package graphs.adj_list.undirected_unweight;

public class MainGraphListUndirectedUnweighted {
    public static void main(String[] args) {
        GraphListUndirectedUnweighted g = new GraphListUndirectedUnweighted(5);

        // Add edges
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(3, 4);

        System.out.println("Graph after adding edges:");
        g.printGraph();

        // Remove one edge
        System.out.println("\nRemoving edge between 0 and 2...");
        g.removeEdge(0, 2);

        // Print the graph again
        System.out.println("\nGraph after removing the edge:");
        g.printGraph();

        // List vertices sorted by degree
        g.listByDegree();

        // BFS
        System.out.println("Number of connected components: " + g.bfsConnectedComponent());

        System.out.println("DFS (recursive) ");
        g.dfs(0);

        System.out.println("DFS - Iterator");
        g.dfsIterator(0);


        // Disjoint Set Union (Union-Find)
        // Union operations: merge sets
        System.out.println();
        g.union(0, 1);
        g.union(2, 3);
        g.union(1, 2);

        // Find operations: get representative of each set
        System.out.println("Representative of vertex 0: " + g.find(0));
        System.out.println("Representative of vertex 3: " + g.find(3));
        System.out.println("Representative of vertex 4: " + g.find(4));

        // Find with path compression
        System.out.println("Representative of vertex 0 (with path compression): " + g.findWithCompression(0));

        // Check if vertices are in the same set
        System.out.println("Are vertices 0 and 3 in the same set? " + (g.find(0) == g.find(3)));
        System.out.println("Are vertices 0 and 4 in the same set? " + (g.find(0) == g.find(4)));
    }
}
