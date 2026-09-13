class Solution {
    private void dfs(ArrayList<ArrayList<Integer>> adj, boolean[] vis, int node) {
        vis[node] = true;
        for(int adjNode: adj.get(node)) {
            if(!vis[adjNode]) dfs(adj, vis, adjNode);
        }
    }
    int countConnected(int V, ArrayList<ArrayList<Integer>> edges) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i = 0; i < V; i++) adj.add(new ArrayList<>());
        for(ArrayList<Integer> e: edges) {
            adj.get(e.get(0)).add(e.get(1));
            adj.get(e.get(1)).add(e.get(0));
        }
        int components = 0;
        boolean[] vis = new boolean[V];
        
        for(int i = 0; i < V; i++) {
            if(!vis[i]) {
                components++;
                dfs(adj, vis, i);
            }
        }
        return components;
    }
}