class Solution {
    public void solve(ArrayList<ArrayList<Integer>> adj, boolean[] vis, int node, ArrayList<Integer> ans) {
        vis[node] = true;
        ans.add(node);
        for(int adjNode: adj.get(node)) {
            if(!vis[adjNode]) solve(adj, vis, adjNode, ans);
        }
    }
    public ArrayList<Integer> dfs(ArrayList<ArrayList<Integer>> adj) {
        ArrayList<Integer> ans = new ArrayList<>();
        int n = adj.size();
        boolean[] vis = new boolean[n];
        solve(adj, vis, 0, ans);
        return ans;
    }
}