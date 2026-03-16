class Solution {
    private boolean dfs(int node, ArrayList<ArrayList<Integer>> adj, int[] vis, int[] curPath) {
        vis[node] = 1;
        curPath[node] = 1;
        
        for(int adjNode: adj.get(node)) {
            if(vis[adjNode]==0) {
                if(dfs(adjNode, adj, vis, curPath)) return true;
            } else if(curPath[adjNode] == 1) {
                return true;
            }
        }
        curPath[node] = 0;
        return false;
    }
    public boolean isCyclic(int V, int[][] edges) {
        // create a adjList out of edges
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i = 0; i < V; i++) adj.add(new ArrayList<>());
        
        // directed graph
        for(int[] edge: edges) {
            adj.get(edge[0]).add(edge[1]);
        }
        
        int[] vis = new int[V];
        int[] curPath = new int[V];
        
        for(int i = 0; i < V; i++) {
            if(vis[i]==0) {
                if(dfs(i, adj, vis, curPath)) return true;
            }
        }
        return false;
    }
}