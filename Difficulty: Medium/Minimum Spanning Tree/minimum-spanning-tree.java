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
    public int spanningTree(int V, int[][] edges) {
        DSU ds = new DSU(V);
        Arrays.sort(edges, (a, b) -> a[2] - b[2]);
        int count = 0;
        int sum = 0;
        for(int[] e: edges) {
            int u = e[0], v = e[1], w = e[2];
            if(ds.findParent(u) != ds.findParent(v)) {
                ds.union(u,v);
                sum += w;
                if(++count == V-1) break;
            }
        }
        return sum;
    }
}
