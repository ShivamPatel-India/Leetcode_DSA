class Solution {
    private void dfs(int node, List<List<Integer>> adj, boolean[] vis, ArrayList<Integer> cmp) {
        vis[node] = true;
        cmp.add(node);
        for(int adjNode: adj.get(node)) {
            if(!vis[adjNode]) dfs(adjNode, adj, vis, cmp);
        }
    }
    public ArrayList<ArrayList<Integer>> getComponents(int V, int[][] edges) {
        List<List<Integer>> adj = new ArrayList<>();
        for(int i = 0; i < V; i++) adj.add(new ArrayList<>());
        for(int[] e: edges) {
            adj.get(e[0]).add(e[1]);
            adj.get(e[1]).add(e[0]);
        }
        boolean[] vis = new boolean[V];
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        for(int i = 0; i < V; i++) {
            if(!vis[i]) {
                ArrayList<Integer> cmp = new ArrayList<>();
                dfs(i, adj, vis, cmp);
                ans.add(cmp);
            }
        }
        return ans;
    }
}