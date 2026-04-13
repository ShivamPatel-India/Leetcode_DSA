class Solution {
    class DSU {
        int[] parent;
        int[] rank;

        public DSU(int n) {
            parent = new int[n];
            rank = new int[n];
            for(int i = 0; i < n; i++) {
                parent[i] = i;
                rank[i] = 0;
            }
        }
        public int findParent(int node) {
            if(parent[node] == node) return node;
            return parent[node] = findParent(parent[node]);
        }
        public void union(int u, int v) {
            int pu = findParent(u);
            int pv = findParent(v);
            int rpu = rank[pu];
            int rpv = rank[pv];
            if(rpu < rpv) {
                parent[pu] = pv;
            } else if(rpv < rpu) {
                parent[pv] = pu;
            } else {
                parent[pv] = pu;
                rank[pu]++;
            }
        }
    }
    public int findCircleNum(int[][] isConnected) {
        List<List<Integer>> adj = new ArrayList<>();
        int n = isConnected.length;
        DSU ds = new DSU(n);
        for(int i = 0; i < n; i++) adj.add(new ArrayList<>());
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(isConnected[i][j] == 1 && ds.findParent(i) != ds.findParent(j)) {
                    ds.union(i, j);
                }
            }
        }
        int components = 0;
        for(int i = 0; i < n; i++) {
            if(ds.parent[i] == i) components++;
        }
        return components;
    }
}