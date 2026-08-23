class Solution {
    public void dfs(ArrayList<ArrayList<Integer>> adj, ArrayList<Integer> ans, int node, boolean[] vis) {
        vis[node] = true;
        ans.add(node);
        for(int adjNode: adj.get(node)) {
            if(!vis[adjNode]) dfs(adj, ans, adjNode, vis);
        }
    }
    public ArrayList<ArrayList<Integer>> getComponents(int V, int[][] edges) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        for(int i = 0; i < V; i++) adj.add(new ArrayList<>());
        for(int[] edge: edges) {
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }
        boolean[] vis = new boolean[V];
        for(int i = 0; i < V; i++) {
            if(!vis[i]) {
                ArrayList<Integer> temp = new ArrayList<>();
                dfs(adj, temp, i, vis);
                ans.add(temp);
            }
        }
        return ans;
    }
}