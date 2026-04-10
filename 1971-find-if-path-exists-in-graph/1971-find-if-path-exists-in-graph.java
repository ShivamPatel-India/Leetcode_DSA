class Solution {
    // can we solve it using Disjoint set? Yes we can and we'll
    class DSU {
        int[] parent, rank;

        public DSU(int n) {
            parent = new int[n];
            rank = new int[n];
            for(int i = 0; i < n; i++) {
                parent[i] = i;
                rank[i] = 0;
            }
        }

        public int findPar(int node) {
            if(parent[node] == node) return node;
            return parent[node] = findPar(parent[node]);
        }

        public void union(int u, int v) {
            int pu = findPar(u);
            int pv = findPar(v);
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
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        DSU ds = new DSU(n);
        for(int[] e: edges) {
            int u = e[0], v = e[1];
            ds.union(u, v);
            if(ds.findPar(source) == ds.findPar(destination)) return true;
        }
        return ds.findPar(source) == ds.findPar(destination);
    }
}