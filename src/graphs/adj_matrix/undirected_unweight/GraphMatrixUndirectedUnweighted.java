package graphs.adj_matrix.undirected_unweight;


import java.util.ArrayList;

public class GraphMatrixUndirectedUnweighted {

    private int numVertices;
    private int[][] adjMatrix;

    public GraphMatrixUndirectedUnweighted(int numVertices) {
        this.numVertices = numVertices;
        this.adjMatrix = new int[numVertices][numVertices];
        for(int i = 0; i < this.numVertices; i++) {
           for (int j = 0; j < this.numVertices; j++) {
               this.adjMatrix[i][j] = 0;
           }
        }
    }

    public void addEdge(int v1, int v2) {
        this.adjMatrix[v1][v2] = 1;
        this.adjMatrix[v2][v1] = 1;
    }

    public void removeEdge(int v1, int v2) {
        this.adjMatrix[v1][v2] = 0;
        this.adjMatrix[v2][v1] = 0;
    }

    public void printGraph() {
        for (int i = 0; i < numVertices; i++) {
            for (int j = 0; j < numVertices; j++) {
                System.out.print(adjMatrix[i][j]);
                if (j < numVertices - 1) {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }


    public int degree(int v) {
        int count = 0;
        for (int i = 0; i < this.numVertices; i++) {
            if (this.adjMatrix[v][i] == 1) {
                count++;
            }
        }
        return count;
    }

    public void listByDegree() {
        ArrayList<ArrayList<Integer>> degrees = new ArrayList<>();

        for (int i = 0; i <= numVertices; i++) {
            degrees.add(new ArrayList<>());
        }

        for (int i = 0; i < numVertices; i++) {
            int degree = degree(i);
            degrees.get(degree).add(i);
        }

        for (int i = 0; i <= numVertices; i++) {
            ArrayList<Integer> vertices = degrees.get(i);
            System.out.print("degree=" + i + ":{");
            for (int j = 0; j < vertices.size(); j++) {
                System.out.print(vertices.get(j));
                if (j < vertices.size() - 1) {
                    System.out.print(", ");
                }
            }
            System.out.println("}");
        }
    }
}


