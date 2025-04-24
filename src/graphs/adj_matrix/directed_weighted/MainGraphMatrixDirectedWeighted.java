package graphs.adj_matrix.directed_weighted;

public class MainGraphMatrixDirectedWeighted {
    public static void main(String[] args) {
        GraphMatrixDirectedWeighted graph = new GraphMatrixDirectedWeighted(4);
        graph.addEdge(0, 1, 5);
        graph.addEdge(0, 2, 3);
        graph.addEdge(2, 3, 2);
        graph.addEdge(1, 3, 8);

        graph.printGraph();
        System.out.println();

        graph.listByDegree();
        System.out.println();

        int[] minEdge = graph.lowestDegree();
        if (minEdge != null) {
            System.out.println("Lowest weight degree: (" + minEdge[0] + " -> " + minEdge[1] + ")");
        } else {
            System.out.println("Graph without degrees.");
        }
    }
}
