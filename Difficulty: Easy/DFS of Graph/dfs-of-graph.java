class Solution {
    public void dfs_helper(ArrayList<ArrayList<Integer>> adj, int node, boolean[] vis, ArrayList<Integer> ans) {
        vis[node] = true;
        ans.add(node);
        for(int adjNode: adj.get(node)) {
            if(!vis[adjNode]) dfs_helper(adj, adjNode, vis, ans);
        }
    }
    public ArrayList<Integer> dfs(ArrayList<ArrayList<Integer>> adj) {
        // code here
        int n = adj.size();
        ArrayList<Integer> ans = new ArrayList<>();
        boolean[] vis = new boolean[n];
        dfs_helper(adj, 0, vis, ans);
        return ans;
    }
}