class Solution {
    private void dfs(int node, ArrayList<ArrayList<Integer>> adj, boolean[] vis, ArrayList<Integer> ans) {
        vis[node] = true;
        ans.add(node);
        for(int adjNode: adj.get(node)) {
            if(!vis[adjNode]) dfs(adjNode, adj, vis, ans);
        }
    }
    public ArrayList<Integer> dfs(ArrayList<ArrayList<Integer>> adj) {
        ArrayList<Integer> ans = new ArrayList<>();
        int n = adj.size();
        boolean[] vis = new boolean[n];
        for(int i = 0; i < n; i++) {
            if(!vis[i]) dfs(i, adj, vis, ans);
        }
        return ans;
    }
}