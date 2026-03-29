class Solution {
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

        public int findUPar(int node) {
            if(parent[node] == node) return node;
            return parent[node] = findUPar(parent[node]);
        }

        public void union(int u, int v) {
            int ulp_u = findUPar(u);
            int ulp_v = findUPar(v);
            
            if(ulp_u == ulp_v) return;

            if(rank[ulp_u] < rank[ulp_v]) {
                parent[ulp_u] = ulp_v;
            } else if (rank[ulp_v] < rank[ulp_u]) {
                parent[ulp_v] = ulp_u;
            } else {
                parent[ulp_v] = ulp_u;
                rank[ulp_u]++;
            }
        }
    }
    public int makeConnected(int n, int[][] connections) {
        DSU ds = new DSU(n);
        int extraEdges = 0;
        for(int[] c: connections) {
            if(ds.findUPar(c[0]) == ds.findUPar(c[1])) extraEdges++;
            else ds.union(c[0],c[1]);
        }

        int components = 0;
        for(int i = 0; i < n; i++) {
            if(ds.parent[i] == i) components++;
        }

        return extraEdges >= (components - 1) ? (components - 1) : -1;
    }
}