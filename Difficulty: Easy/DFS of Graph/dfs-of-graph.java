class Solution {
    public void f(int node, boolean[] vis, ArrayList<Integer> ans, ArrayList<ArrayList<Integer>> adj) {
        vis[node] = true;
        ans.add(node); 
        
        for(int it: adj.get(node)) {
            if(!vis[it]) f(it, vis, ans, adj);
        }
    }
    public ArrayList<Integer> dfs(ArrayList<ArrayList<Integer>> adj) {
        // code here
        ArrayList<Integer> ans = new ArrayList<>();
        int n = adj.size();
        boolean[] vis = new boolean[n];
        f(0, vis, ans, adj);
        return ans;
    }
}