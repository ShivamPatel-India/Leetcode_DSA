class Solution {
    private int n;
    private boolean[] vis;
    private ArrayList<Integer> ans;
    private void dfs(int node, ArrayList<ArrayList<Integer>> adj) {
        vis[node] = true;
        ans.add(node);
        for(int adjNode: adj.get(node)) if(!vis[adjNode]) dfs(adjNode, adj);
    }
    public ArrayList<Integer> dfs(ArrayList<ArrayList<Integer>> adj) {
        ans = new ArrayList<>();
        n = adj.size();
        vis = new boolean[n];
        dfs(0, adj);
        return ans;
    }
}