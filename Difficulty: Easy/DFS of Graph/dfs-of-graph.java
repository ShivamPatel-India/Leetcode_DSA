class Solution {
    public void f(int node, boolean[] vis, ArrayList<ArrayList<Integer>> adj, ArrayList<Integer> ans) {
        vis[node] = true;
        ans.add(node);
        
        for(int it: adj.get(node)) {
            if(!vis[it]) f(it, vis, adj, ans);
        }
    }
    public ArrayList<Integer> dfs(ArrayList<ArrayList<Integer>> adj) {
        // code here
        ArrayList<Integer> ans = new ArrayList<>();
        boolean[] vis = new boolean[adj.size()];
        f(0, vis, adj, ans);
        return ans;
    }
}