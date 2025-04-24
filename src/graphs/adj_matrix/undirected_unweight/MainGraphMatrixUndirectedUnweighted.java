package graphs.adj_matrix.undirected_unweight;

public class MainGraphMatrixUndirectedUnweighted {
    public static void main(String[] args) {
        GraphMatrixUndirectedUnweighted graph = new GraphMatrixUndirectedUnweighted(5);
        graph.addEdge(0 , 1);
        graph.addEdge(0 , 2);
        graph.addEdge(1 , 2);
        graph.addEdge(3 , 4);


        graph.printGraph();
        System.out.println();

        graph.listByDegree();

        System.out.println();
        graph.addEdge(3 , 2);
        graph.listByDegree();


        graph.removeEdge(3, 2);
        graph.printGraph();
        System.out.println();
    }
}
