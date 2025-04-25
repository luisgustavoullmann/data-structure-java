package graphs.adj_list;

import java.util.ArrayList;
import java.util.List;

public class DisjointSet {
    private List<Integer> parent;

    public DisjointSet(int n) {
        this.parent = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            parent.add(i);
        }
    }

    // Finds the representative (root) of the set containing x
    public int find(int x) {
        while (!parent.get(x).equals(x)) {
            x = parent.get(x);
        }
        return x;
    }

    // Unites the sets containing x and y
    public void union(int x, int y) {
        int rootX = findWithCompression(x);
        int rootY = findWithCompression(y);

        if (rootX != rootY) {
            parent.set(rootY, rootX);
        }
    }

    // for path compression (more efficient)
    public int findWithCompression(int x) {
        if (!parent.get(x).equals(x)) {
            parent.set(x, findWithCompression(parent.get(x)));
        }
        return parent.get(x);
    }
}
