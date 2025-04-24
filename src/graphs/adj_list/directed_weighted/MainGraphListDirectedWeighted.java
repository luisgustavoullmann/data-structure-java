package graphs.adj_list.directed_weighted;

import java.util.List;

public class MainGraphListDirectedWeighted {
    public static void main(String[] args) {
        GraphListDirectedWeighted g = new GraphListDirectedWeighted(5);

        g.addEdge(0, 1, 5);
        g.addEdge(0, 2, 3);
        g.addEdge(1, 2, 1);
        g.addEdge(1, 3, 4);
        g.addEdge(2, 4, 2);

        System.out.println("Graph:");
        g.printGraph();

        System.out.println("\nRemoving edge 0 -> 2");
        g.removeEdge(0, 2);
        g.printGraph();

        System.out.println("\nLowest weight edge:");
        int[] min = g.lowestWeight();
        if (min != null) {
            System.out.println("From " + min[0] + " to " + min[1]);
        } else {
            System.out.println("No edges found.");
        }

        System.out.println("\nNeighbours of vertex 1:");
        System.out.println(g.neighbours(1));

        System.out.println("\nVertices sorted by degree:");
        System.out.println(g.listByDegree());


        // BFS
        System.out.println("Number of connected components: " + g.bfsConnectedComponent());

        System.out.println("DFS (recursive) ");
        g.dfs(0);

        System.out.println("DFS - Iterator");
        g.dfsIterator(0);

        System.out.println("Has cycle: " + g.hasCycle());
        System.out.println("\nTopological Sort:");
        List<Integer> topoOrder = g.toposortDfs();
        System.out.println("Order: " + topoOrder);


        // Dijkstra
        Pair<List<Integer>, List<Integer>> result = g.dijkstra(0);
        List<Integer> dist = result.first;
        List<Integer> prev = result.second;

        System.out.println("\nDijkstra from 0:");
        for (int i = 0; i < dist.size(); i++) {
            System.out.println("Distance to " + i + ": " + dist.get(i));
            System.out.println("Path: " + g.recoverPath(i, prev));
        }

        // Bellman-Ford
        System.out.println("\nBellman-Ford from 0:");
        List<Integer> distances = g.bellmanFord(0);
        System.out.println("Shortest distances from source 0:");
        System.out.println(distances);
    }
}
