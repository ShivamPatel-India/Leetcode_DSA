class Solution {
    private void dfs(int node, boolean[] vis, ArrayList<Integer> ans, ArrayList<ArrayList<Integer>> adj) {
        vis[node] = true;
        ans.add(node);
        for(int adjNode: adj.get(node)) {
            if(!vis[adjNode]) dfs(adjNode, vis, ans, adj);
        }
    }
    public ArrayList<Integer> dfs(ArrayList<ArrayList<Integer>> adj) {
        int V = adj.size();
        boolean[] vis = new boolean[V];
        ArrayList<Integer> ans = new ArrayList<>();
        dfs(0, vis, ans, adj);
        return ans;
    }
}