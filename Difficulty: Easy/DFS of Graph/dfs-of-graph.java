class Solution {
    private int n;
    private ArrayList<Integer> ans;
    private void dfs(ArrayList<ArrayList<Integer>> adj, boolean[] vis, int node) {
        vis[node] = true;
        ans.add(node);
        for(int adjNode: adj.get(node)) {
            if(!vis[adjNode]) {
                dfs(adj, vis, adjNode);
            }
        }
    }
    public ArrayList<Integer> dfs(ArrayList<ArrayList<Integer>> adj) {
        // code here
        ans = new ArrayList<>();
        n = adj.size(); // to get the total nodes
        boolean[] vis = new boolean[n];
        dfs(adj, vis, 0);
        return ans;
    }
}