package graphs.adj_matrix.directed_weighted;

import java.util.ArrayList;

public class GraphMatrixDirectedWeighted {
    private int numVertices;
    private int[][] adjMatrix;

    public GraphMatrixDirectedWeighted(int numVertices) {
        this.numVertices = numVertices;
        this.adjMatrix = new int[numVertices][numVertices];
        for(int i = 0; i < this.numVertices; i++) {
            for (int j = 0; j < this.numVertices; j++) {
                this.adjMatrix[i][j] = -1;
            }
        }
    }

    public void addEdge(int out, int in, int weight) {
        this.adjMatrix[out][in] = weight;
    }

    public void removeEdge(int out, int in) {
        this.adjMatrix[out][in] = -1;
    }

    public void printGraph() {
        for (int i = 0; i < numVertices; i++) {
            for (int j = 0; j < numVertices; j++) {
                System.out.print(adjMatrix[i][j]);
                if (j < numVertices - 1) {
                    System.out.print((this.adjMatrix[i][j] == -1 ? "." : this.adjMatrix[i][j]) + " ");
                }
            }
            System.out.println();
        }
    }

    public int[] lowestDegree() {
        int[] minEdge = {-1, -1};
        int minValue = Integer.MAX_VALUE;

        for (int i = 0; i < this.numVertices; i++) {
            for (int j = 0; j < this.numVertices; j++) {
                if (this.adjMatrix[i][j] != -1 && this.adjMatrix[i][j] < minValue) {
                    minEdge[0] = i;
                    minEdge[1] = j;
                    minValue = this.adjMatrix[i][j];
                }
            }
        }
        return (minValue == Integer.MAX_VALUE) ? null : minEdge;
    }


    public int degree(int v) {
        int count = 0;
        for (int i = 0; i < this.numVertices; i++) {
            if (this.adjMatrix[v][i] != -1) {
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
