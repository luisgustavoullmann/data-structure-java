package graphs.adj_list;

import java.util.List;

// Minimum Spanning Tree
public class MinimumSpanningTree {
    private List<int[]> mstEdges;
    private int totalWeight;

    public MinimumSpanningTree(List<int[]> mstEdges, int totalWeight) {
        this.mstEdges = mstEdges;
        this.totalWeight = totalWeight;
    }

    public List<int[]> getMstEdges() {
        return mstEdges;
    }

    public void setMstEdges(List<int[]> mstEdges) {
        this.mstEdges = mstEdges;
    }

    public int getTotalWeight() {
        return totalWeight;
    }

    public void setTotalWeight(int totalWeight) {
        this.totalWeight = totalWeight;
    }
}
