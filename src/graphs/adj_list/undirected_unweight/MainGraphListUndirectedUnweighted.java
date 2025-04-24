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
    }
}
