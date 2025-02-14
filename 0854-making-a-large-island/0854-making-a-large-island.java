class DisjointSet {
    List<Integer> rank = new ArrayList<>();
    List<Integer> parent = new ArrayList<>();
    List<Integer> size = new ArrayList<>();

    DisjointSet(int n ) {
        for(int i = 0; i <= n; i++) {
            rank.add(0);
            parent.add(i);
            size.add(1);
        }
    }

    public int findUPar(int node) {
        if(node == parent.get(node)) return node;
        else {
            int ulp = findUPar(parent.get(node));
            parent.set(node, ulp);
            return parent.get(node);
        }
    }

    public void unionByRank(int u, int v) {
        int ulp_u = findUPar(u);
        int ulp_v = findUPar(v);

        if(ulp_u == ulp_v) return;

        if(rank.get(ulp_u) > rank.get(ulp_v)) parent.set(ulp_v, ulp_u);
        else if(rank.get(ulp_v) > rank.get(ulp_u)) parent.set(ulp_u, ulp_v);
        else {
            parent.set(ulp_v, ulp_u);
            int rankU = rank.get(ulp_u);
            rank.set(ulp_u, rankU+1);
        }
    }

    public void unionBySize(int u, int v) {
        int ulp_u = findUPar(u);
        int ulp_v = findUPar(v);

        if(ulp_u == ulp_v) return;

        if(size.get(ulp_u) > size.get(ulp_v)) {
            parent.set(ulp_v, ulp_u);
            size.set(ulp_u, size.get(ulp_u) + size.get(ulp_v));
        } else {
            parent.set(ulp_u, ulp_v);
            size.set(ulp_v, size.get(ulp_u) + size.get(ulp_v));
        }
    }
}
class Solution {
    private boolean isValid(int newr, int newc, int n) {
        return newr >= 0 && newc >= 0 && newr < n && newc < n;
    }
    public int largestIsland(int[][] grid) {
        int n = grid.length;
        DisjointSet ds = new DisjointSet(n*n);

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(grid[i][j] == 0) continue;
                int[] dr = {-1,0,1,0};
                int[] dc = {0,-1,0,1};
                for(int k = 0; k < 4; k++) {
                    int newr = i + dr[k];
                    int newc = j + dc[k];
                    if(isValid(newr,newc,n) && grid[newr][newc] == 1) {
                        int nodeNo = i * n + j;
                        int adjNodeNo = newr * n + newc;
                        ds.unionBySize(nodeNo, adjNodeNo);
                    }
                }
            }
        }

        int mx = 0;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(grid[i][j] == 1) continue;
                HashSet<Integer> components = new HashSet<>();
                int[] dr = {-1,0,1,0};
                int[] dc = {0,-1,0,1};
                for(int k = 0; k < 4; k++) {
                    int newr = i + dr[k];
                    int newc = j + dc[k];
                    if(isValid(newr,newc,n)) {
                        if(grid[newr][newc] == 1) 
                            components.add(ds.findUPar(newr * n + newc));
                    }
                }
                int size = 0;
                for(Integer parent: components) size += ds.size.get(parent);
                mx = Math.max(mx, size + 1);
            }
        }

        for(int i = 0 ; i < n*n; i++) {
            mx = Math.max(mx, ds.size.get(ds.findUPar(i)));
        }

        return mx;
    }
}