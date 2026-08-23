class Solution {
    public void dfs(ArrayList<ArrayList<Integer>> adj, ArrayList<Integer> ans, boolean[] vis, int node) {
        vis[node] = true;
        ans.add(node);
        for(int adjNode: adj.get(node)) {
            if(!vis[adjNode]) dfs(adj, ans, vis, adjNode);
        }
    }
    public ArrayList<Integer> dfs(ArrayList<ArrayList<Integer>> adj) {
        // code here
        int n = adj.size();
        boolean[] vis = new boolean[n];
        ArrayList<Integer> ans = new ArrayList<>();
        dfs(adj, ans, vis, 0);
        return ans;
    }
}