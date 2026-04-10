class Solution {
    private boolean DFS(int node, int target, List<List<Integer>> adj, boolean[] vis) {
        vis[node] = true;
        if(node == target) return true;
        for(int adjNode: adj.get(node)) {
            if(!vis[adjNode]) if(DFS(adjNode, target, adj, vis)) return true;
        }
        return false;
    }
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        List<List<Integer>> adj = new ArrayList<>();
        for(int i = 0; i < n; i++) adj.add(new ArrayList<>());
        for(int[] e: edges) {
            adj.get(e[0]).add(e[1]);
            adj.get(e[1]).add(e[0]);
        }
        boolean[] vis = new boolean[n];
        return DFS(source, destination, adj, vis);
        
    }
}