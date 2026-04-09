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
    public boolean areSimilar(String s1, String s2) {
        int count = 0;
        int n = s1.length();
        for(int i = 0; i < n; i++) {
            if(s1.charAt(i) != s2.charAt(i)) {
                count++;
                if(count > 2) return false;
            }
        }
        return true;
    }
    public int numSimilarGroups(String[] strs) {
        int n = strs.length;
        DSU ds = new DSU(n);
        for(int i = 0; i < n; i++) {
            for(int j = i + 1; j < n; j++) {
                if(areSimilar(strs[i], strs[j]) && ds.findParent(i) != ds.findParent(j)) {
                    ds.union(i, j);
                }
            }
        }
        int groups = 0;
        for(int i = 0; i < n; i++) {
            if(ds.findParent(i)==i) groups++;
        }
        return groups;
    }
}