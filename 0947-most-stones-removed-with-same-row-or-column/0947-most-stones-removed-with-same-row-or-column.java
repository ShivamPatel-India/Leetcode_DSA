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
            } else if(rank[ulp_v] < rank[ulp_u]) {
                parent[ulp_v] = ulp_u;
            } else {
                parent[ulp_u] = ulp_v;
                rank[ulp_v]++;
            }
        }
    }
    public int removeStones(int[][] stones) {
        int n = stones.length;
        DSU ds = new DSU(n);
        for(int i = 0; i < n; i++) {
            for(int j = i+1; j < n; j++) {
                if(stones[i][0] == stones[j][0] || stones[i][1] == stones[j][1]) {
                    ds.union(i, j);
                }
            }
        }  

        int components = 0;
        for(int i = 0; i < n; i++) {
            if(ds.parent[i] == i) components++;
        }  
        return n-components;
    }
}