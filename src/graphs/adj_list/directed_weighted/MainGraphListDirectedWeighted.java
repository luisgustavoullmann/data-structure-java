package graphs.adj_list.directed_weighted;

import graphs.adj_list.MinimumSpanningTree;

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


        // Run Floyd-Warshall
        System.out.println();
        List<List<Integer>> distFloydWarshall = g.floydWarshall();

        // Print result
        System.out.println("Floyd-Warshall distance matrix:");
        for (int i = 0; i < distFloydWarshall.size(); i++) {
            for (int j = 0; j < distFloydWarshall.get(i).size(); j++) {
                if (distFloydWarshall.get(i).get(j) == Integer.MAX_VALUE) {
                    System.out.print("INF ");
                } else {
                    System.out.print(distFloydWarshall.get(i).get(j) + " ");
                }
            }
            System.out.println();
        }

        // Runs Prim's algorithm starting from vertex 0
        System.out.println();
        MinimumSpanningTree mst = g.primMST(0);

        if (mst == null) {
            System.out.println("The graph is not connected. MST could not be constructed.");
        } else {
            System.out.println("Edges of the Minimum Spanning Tree:");
            for (int[] edge : mst.getMstEdges()) {
                System.out.printf("%d - %d (weight: %d)%n", edge[0], edge[1], edge[2]);
            }
            System.out.println("Total weight of the MST: " + mst.getTotalWeight());
        }


        // Run Kruskal's algorithm to find the Minimum Spanning Tree (MST)
        System.out.println();
        System.out.println("Running Kruskal's algorithm...");
         mst = g.kruskal();

        // Print the result
        System.out.println("\nEdges in the Minimum Spanning Tree:");
        for (int[] edge : mst.getMstEdges()) {
            int u = edge[0], v = edge[1], w = edge[2];
            System.out.println(u + " - " + v + " (weight: " + w + ")");
        }

        System.out.println("Total weight of the MST: " + mst.getTotalWeight());

    }
}
