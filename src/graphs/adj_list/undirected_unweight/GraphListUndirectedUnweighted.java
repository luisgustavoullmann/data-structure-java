package graphs.adj_list.undirected_unweight;

import graphs.adj_list.directed_weighted.DisjointSet;

import java.util.*;

public class GraphListUndirectedUnweighted {
    private int numVertices;
    private List<List<Integer>> adjList;
    private DisjointSet parentDisjointSet = null;

    public GraphListUndirectedUnweighted(int numVertices) {
        this.numVertices = numVertices;
        this.adjList = new ArrayList<>();
        for (int i =0;  i < this.numVertices; i++) {
            this.adjList.add(new ArrayList<>());
        }
    }

    public void addEdge(int v1, int v2) {
        this.adjList.get(v1).add(v2);
        this.adjList.get(v2).add(v1);
    }

    public void removeEdge(int v1, int v2) {
        this.adjList.get(v1).remove(Integer.valueOf(v2));
        this.adjList.get(v2).remove(Integer.valueOf(v1));
    }

    public void printGraph() {
        for (int i = 0; i < this.numVertices; i++) {
            List<Integer> edges = this.adjList.get(i);
            System.out.println(i + " -> " + edges.toString().replaceAll("[\\[\\]]", ""));
        }
    }

    public int degree(int v) {
        return this.adjList.get(v).size();
    }

    public void listByDegree() {
        List<Integer> vertices = new ArrayList<>();
        for (int i = 0; i < this.numVertices; i++) {
            vertices.add(i);
        }

        vertices.sort((v1, v2) -> degree(v2) - degree(v1));

        System.out.println("Vertices sorted by degree: ");
        for (int v : vertices) {
            System.out.println("Vertex " + v + " - Degree: " + degree(v));
        }
    }

    // Breadth First Search
    private void bfs(int v, boolean[] visited) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(v);
        visited[v] = true;

        while (!queue.isEmpty()) {
            int current = queue.poll();
            System.out.println("v = " + current);

            for (int w : this.adjList.get(current)) {
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

        for (int w : this.adjList.get(v)) {
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

            for (int w : this.adjList.get(v)) {
                if (!visited[w]) {
                    stack.push(w);
                    visited[w] = true;
                }
            }
        }
    }

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
}
