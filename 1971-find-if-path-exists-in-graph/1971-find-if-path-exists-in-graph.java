class Solution {
    private void DFS(int node, int target, List<List<Integer>> adj, boolean[] vis) {
        vis[node] = true;
        for(int adjNode: adj.get(node)) {
            if(!vis[adjNode]) DFS(adjNode, target, adj, vis);
        }
    }
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        List<List<Integer>> adj = new ArrayList<>();
        for(int i = 0; i < n; i++) adj.add(new ArrayList<>());
        for(int[] e: edges) {
            adj.get(e[0]).add(e[1]);
            adj.get(e[1]).add(e[0]);
        }
        boolean[] vis = new boolean[n];
        DFS(source, destination, adj, vis);
        return vis[destination];
    }
}