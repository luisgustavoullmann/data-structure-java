package graphs.adj_list.directed_weighted;

import graphs.adj_list.DisjointSet;
import graphs.adj_list.MinHeap;
import graphs.adj_list.MinimumSpanningTree;

import java.util.*;

public class GraphListDirectedWeighted {
    private int numVertices;
    private List<List<Edge>> adjList;
    private DisjointSet parentDisjointSet = null;

    private static class Edge {
        int dest;
        int weight;

        Edge(int dest, int weight) {
            this.dest = dest;
            this.weight = weight;
        }
    }

    public GraphListDirectedWeighted(int numVertices) {
        this.numVertices = numVertices;
        this.adjList = new ArrayList<>(numVertices);
        for (int i = 0; i < this.numVertices; i++) {
            this.adjList.add(new ArrayList<>());
        }
    }

    public void addEdge(int from, int to, int weight) {
        this.adjList.get(from).add(new Edge(to, weight));
    }

    public void removeEdge(int from, int to) {
        this.adjList.get(from).removeIf(edge -> edge.dest == to);
    }

    public void printGraph() {
        for (int i = 0; i < this.numVertices; i++) {
            List<Edge> edges = this.adjList.get(i);
            StringBuilder sb = new StringBuilder();
            for (Edge edge : edges) {
                sb.append(edge.dest).append(" (weight: ").append(edge.weight).append("), ");
            }
            if(!sb.isEmpty()) sb.setLength(sb.length() - 2);
            System.out.println(i + " -> " + sb);
        }
    }

    public int[] lowestWeight() {
        int[] minEdge = {-1,-1};
        int minValue = Integer.MAX_VALUE;

        for (int i = 0; i < this.numVertices; i++) {
            for (Edge edge : adjList.get(i)) {
                if (edge.weight < minValue) {
                    minValue = edge.weight;
                    minEdge[0] = i;
                    minEdge[1] = edge.dest;
                }
            }
        }
        return (minValue == Integer.MAX_VALUE) ? null : minEdge;
    }

    public List<Integer> neighbours(int v) {
        List<Integer> result = new ArrayList<>();
        for (Edge edge : adjList.get(v)) {
            result.add(edge.dest);
        }
        return result;
    }

    public int degree(int v) {
        return this.adjList.get(v).size();
    }

    public List<Integer> listByDegree() {
        List<Integer> vertices = new ArrayList<>();
        for (int i = 0; i < this.numVertices; i++) {
            vertices.add(i);
        }

        vertices.sort((v1, v2) -> degree(v2) - degree(v1));
        return vertices;
    }

    // Breadth First Search
    private void bfs(int v, boolean[] visited) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(v);
        visited[v] = true;

        while (!queue.isEmpty()) {
            int current = queue.poll();
            System.out.println("v = " + current);

            for (int w : neighbours(current)) {
                if (!visited[w]) {
                    visited[w] = true;
                    queue.add(w);
                }
            }
        }
    }

    public int bfsConnectedComponent() {
        boolean[] visited = new boolean[this.numVertices];
        int count = 0;

        for (int i = 0; i < this.numVertices; i++) {
            if (!visited[i]) {
                System.out.println("Component : " + count);
                bfs(i, visited);
                count++;
            }
        }
        return count;
    }

    // Depth-First Search
    public void dfs(int v) {
        boolean[] visited = new boolean[this.numVertices];
        dfsUtil(v, visited);
    }

    private void dfsUtil(int v, boolean[] visited) {
        visited[v] = true;
        System.out.println("Visited: " + v);

        for (int w : neighbours(v)) {
            if (!visited[w]) {
                dfsUtil(w, visited);
            }
        }
    }

    public void dfsIterator(int v) {
        boolean[] visited = new boolean[this.numVertices];
        Stack<Integer> stack = new Stack<>();

        stack.push(v);
        visited[v] = true;

        while (!stack.isEmpty()) {
            v = stack.pop();
            System.out.println("Visited = " + v);

            for (int w : neighbours(v)) {
                if (!visited[w]) {
                    stack.push(w);
                    visited[w] = true;
                }
            }
        }
    }

    public List<Integer> toposortDfs() {
        boolean[] visited = new boolean[this.numVertices];
        LinkedList<Integer> orderedList = new LinkedList<>();

        for (int i = 0; i < this.numVertices; i++) {
            if (!visited[i]) {
                dfsUtilsToposort(i, visited, orderedList);
            }
        }
        return orderedList;
    }

    private void dfsUtilsToposort(int v, boolean[] visited, LinkedList<Integer> orderedList) {
        visited[v] = true;
        System.out.println("Visited " + v);

        for (int w : neighbours(v)) {
            if (!visited[w]) {
                dfsUtilsToposort(w, visited, orderedList);
            }
        }
        orderedList.addFirst(v);
    }

    public boolean hasCycle() {
        boolean[] visited = new boolean[numVertices];
        boolean[] recStack = new boolean[numVertices];

        for (int i = 0; i < numVertices; i++) {
            if (!visited[i]) {
                if (hasCycleUtil(i, visited, recStack)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean hasCycleUtil(int v, boolean[] visited, boolean[] recStack) {
        visited[v] = true;
        recStack[v] = true;

        for (int neighbor : neighbours(v)) {
            if (!visited[neighbor]) {
                if (hasCycleUtil(neighbor, visited, recStack)) {
                    return true;
                }
            } else if (recStack[neighbor]) {
                return true;
            }
        }

        recStack[v] = false;
        return false;
    }

    public Pair<List<Integer>, List<Integer>> dijkstra(int source) {
        int[] dist = new int[this.numVertices];
        int[] previous = new int[this.numVertices];
        boolean[] visited = new boolean[this.numVertices];

        Arrays.fill(dist, Integer.MAX_VALUE);
        Arrays.fill(previous, -1);

        for (int k = 0; k < this.numVertices; k++) {
            int current = -1;

            for (int i = 0; i < this.numVertices; i++) {
                if (visited[i]) continue;
                if (current == -1 || dist[i] < dist[current]) {
                    current = i;
                }
            }

            if (current == -1) break;
            visited[current] = true;

            for (Edge edge : this.adjList.get(current)) {
                int neighbor = edge.dest;
                int weight = edge.weight;

                if (dist[current] + weight < dist[neighbor]) {
                    dist[neighbor] = dist[current]  + weight;
                    previous[neighbor] = current;
                }
            }
        }
        List<Integer> distList = new ArrayList<>();
        List<Integer> prevList = new ArrayList<>();
        for (int i = 0; i < this.numVertices; i++) {
            distList.add(dist[i]);
            prevList.add(previous[i]);
        }

        return new Pair<>(distList, prevList);
    }


    // Bellman-Ford
    public List<int[]> getAllEdges() {
        List<int[]> edges = new ArrayList<>();
        for (int u = 0; u < this.numVertices; u++) {
            for (Edge edge : adjList.get(u)) {
                edges.add(new int[]{u, edge.dest, edge.weight});
            }
        }
        return edges;
    }

    public List<Integer> bellmanFord(int source) {
        List<Integer> dist = new ArrayList<>();
        for (int i = 0; i < this.numVertices; i++) {
            dist.add(Integer.MAX_VALUE);
        }
        dist.set(source, 0);

        List<int[]> edges = getAllEdges();

        for (int i = 0; i < this.numVertices - 1; i++) {
            for (int[] edge : edges) {
                int u = edge[0];
                int v = edge[1];
                int w = edge[2];

                if (dist.get(u) != Integer.MAX_VALUE && dist.get(u) + w < dist.get(v)) {
                    dist.set(v, dist.get(u) + w);
                }
            }
        }

        // verify negative cycles
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            int w = edge[2];

            if (dist.get(u) != Integer.MAX_VALUE && dist.get(u) + w < dist.get(v)) {
                System.out.println("Graph contains negative weight cycle");
                return Collections.emptyList();
            }
        }

        return dist;
    }


    // dijkstra, BFS, DFS, Bellman-Ford
    public List<Integer> recoverPath(int s, List<Integer> previous) {
        List<Integer> path = new ArrayList<>();
        int current = s;
        path.add(current);

        while (previous.get(current) != current && previous.get(current) != -1) {
            current = previous.get(current);
            path.add(current);
        }

        Collections.reverse(path);
        return path;
    }



    // Floyd-Warshall
    public List<List<Integer>> floydWarshall() {
        int INF = Integer.MAX_VALUE;
        List<List<Integer>> dist = new ArrayList<>();

        // Initialize distance matrix
        for (int i = 0; i < this.numVertices; i++) {
            List<Integer> row = new ArrayList<>();
            for (int j = 0; j < this.numVertices; j++){
                if (i == j) {
                    row.add(0);
                } else {
                    row.add(INF);
                }
            }
            dist.add(row);
        }

        // Set initial distances based on matrix existing edges
        for (int u = 0; u < this.numVertices; u++) {
            for (Edge edge : adjList.get(u)) {
                dist.get(u).set(edge.dest, edge.weight);
            }
        }

        // Floyd-Warshall algorithm
        for (int k = 0; k < this.numVertices; k++) {
            for (int i = 0; i < this.numVertices; i++) {
                for (int j = 0; j < this.numVertices; j++) {
                    int ik = dist.get(i).get(k);
                    int kj = dist.get(k).get(j);
                    int ij = dist.get(i).get(j);
                    if (ik != INF && kj != INF && ik + kj < ij) {
                        dist.get(i).set(j, ik + kj);
                    }
                }
            }
        }

        return dist;
    }

    // Before use these methods below, you must transform to undirected and weighted graph

    // Disjoint Set Union (Union-Find)
    public void enableDisjointSet() {
        if (this.parentDisjointSet == null) {
            this.parentDisjointSet = new DisjointSet(this.numVertices);
        }
    }

    public int find(int x) {
        enableDisjointSet();
        return this.parentDisjointSet.find(x);
    }

    public void union(int x, int y) {
        enableDisjointSet();
        this.parentDisjointSet.union(x, y);
    }

    // for path compression (more efficient)
    public int findWithCompression(int x) {
        enableDisjointSet();
        return this.parentDisjointSet.findWithCompression(x);
    }

    public MinimumSpanningTree kruskal() {
        List<int[]> sortedEdges = new ArrayList<>(getAllEdges());
        sortedEdges.sort(Comparator.comparingInt(edge -> edge[2]));

        enableDisjointSet();
        DisjointSet disjointSet = this.parentDisjointSet;
        List<int[]> mst = new ArrayList<>();
        int totalWeight = 0;

        for (int[] edge : sortedEdges) {
            int u = edge[0];
            int v = edge[0];
            int weight = edge[0];

            if (disjointSet.findWithCompression(u) != disjointSet.findWithCompression(v)) {
                disjointSet.union(u, v);
                mst.add(new int[]{u, v, weight});
                totalWeight += weight;
            }
        }
        return new MinimumSpanningTree(mst, totalWeight);
    }






    // Prim - Minimum Spanning Tree - just for undirected but weighted graphs
    public MinimumSpanningTree primMST(int source) {
        MinHeap minHeap = new MinHeap();
        boolean[] visited = new boolean[this.numVertices];
        List<int[]> mstEdges = new ArrayList<>();
        int totalWeight = 0;

        visited[source] = true;
        for (Edge edge : this.adjList.get(source)) {
            minHeap.insert(new int[]{source, edge.dest, edge.weight});
        }

        while (!minHeap.isEmpty() && mstEdges.size() < this.numVertices -1) {
            int[] edge = minHeap.extractMin();
            int from = edge[0];
            int to = edge[1];
            int weight = edge[2];

            if (visited[to]) continue;

            visited[to] = true;
            mstEdges.add(edge);
            totalWeight += weight;

            for (Edge next : this.adjList.get(to)) {
                if (!visited[next.dest]) {
                    minHeap.insert(new int[]{to, next.dest, next.weight});
                }
            }
        }

        for (boolean v : visited) {
            if (!v) return null;
        }

        return new MinimumSpanningTree(mstEdges, totalWeight);
    }

}
