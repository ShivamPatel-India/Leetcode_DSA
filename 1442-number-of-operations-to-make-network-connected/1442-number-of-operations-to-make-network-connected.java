class DisjointSet {
    List<Integer> parent = new ArrayList<>();
    List<Integer> rank = new ArrayList<>();
    DisjointSet(int n) {
        for(int i = 0; i <= n; i++) {
            parent.add(i);
            rank.add(0);
        }
    }

    public int findUPar(int node) {
        if(node == parent.get(node)) return node;
        else {
            int ulp = findUPar(parent.get(node));
            parent.set(node,ulp);
            return parent.get(node);
        }
    }

    public void unionByRank(int u, int v) {
        int ulp_u = findUPar(u);
        int ulp_v = findUPar(v);

        if(ulp_u == ulp_v) return;
        
        if(rank.get(ulp_v) < rank.get(ulp_u)) {
            parent.set(ulp_v, ulp_u);
        } else if(rank.get(ulp_u) < rank.get(ulp_v)) {
            parent.set(ulp_u, ulp_v);
        } else {
            parent.set(ulp_v, ulp_u);
            int rankU = rank.get(ulp_u);
            rank.set(ulp_u, rankU+1);
        }
    }
}
class Solution {
    public int makeConnected(int n, int[][] connections) {
        DisjointSet ds = new DisjointSet(n);
        int extraEdges = 0;
        int edges = connections.length;
        for(int i = 0; i < edges; i++) {
            int u = connections[i][0];
            int v = connections[i][1];
            if(ds.findUPar(u) == ds.findUPar(v)) extraEdges++;
            else ds.unionByRank(u, v);
        }

        int cntC = 0;
        for(int i = 0; i < n; i++) {
            if(ds.parent.get(i) == i) cntC++;
        }
        int ans = cntC - 1;
        if(extraEdges >= ans) return ans;
        return -1;
    }
}