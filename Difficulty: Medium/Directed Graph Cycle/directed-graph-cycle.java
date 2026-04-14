class Solution {
    private boolean dfs(int node, List<List<Integer>> adj, boolean[] vis, boolean[] pathVis) {
        vis[node] = true;
        pathVis[node] = true;
        for(int adjNode: adj.get(node)) {
            if(!vis[adjNode]) {
                if(dfs(adjNode, adj, vis, pathVis)) return true;
            } else if(pathVis[adjNode]) return true;
        }
        pathVis[node] = false;
        return false;
    }
    public boolean isCyclic(int V, int[][] edges) {
        List<List<Integer>> adj = new ArrayList<>();
        for(int i = 0; i < V; i++) adj.add(new ArrayList<>());
        for(int[] e: edges) {
            adj.get(e[0]).add(e[1]);
        }
        
        boolean[] vis = new boolean[V];
        boolean[] pathVis = new boolean[V];
        for(int i = 0; i < V; i++) {
            if(!vis[i]) {
                if(dfs(i, adj, vis, pathVis)) return true;
            }
        }
        return false;
    }
}