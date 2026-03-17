class Solution {
    public boolean dfs(int node, List<List<Integer>> adj, boolean[] vis, boolean[] pathVis) {
        vis[node] = true;
        pathVis[node] = true;
        
        for(int adjNode: adj.get(node)) {
            if(!vis[adjNode]) {
                if(dfs(adjNode, adj, vis, pathVis)) return true;
            } else if(pathVis[adjNode])return true;
        }
        pathVis[node] = false;
        return false;
    }
    public boolean isCyclic(int V, int[][] edges) {
        List<List<Integer>> adj = new ArrayList<>();
        for(int i = 0; i < V; i++) adj.add(new ArrayList<>());
        
        for(int[] edge: edges) adj.get(edge[0]).add(edge[1]);
        
        // to keep track of the already visited nodes
        boolean[] vis = new boolean[V];
        
        // to keep track of the already visited nodes in the current path
        boolean[] pathVis = new boolean[V];
        
        for(int i = 0; i < V; i++) {
            if(!vis[i]) {
                if(dfs(i, adj, vis, pathVis)) return true;
            }
        }
        return false;
    }
}