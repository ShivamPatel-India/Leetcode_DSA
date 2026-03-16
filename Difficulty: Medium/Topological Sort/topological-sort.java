class Solution {
    private void dfs(int node, ArrayList<ArrayList<Integer>> adj, boolean[] vis, Stack<Integer> st) {
        vis[node] = true;
        for(int adjNode: adj.get(node)) {
            if(!vis[adjNode]) dfs(adjNode, adj, vis, st);
        }
        st.push(node);
    }
    public ArrayList<Integer> topoSort(int V, int[][] edges) {
        // code here
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i = 0; i < V; i++) adj.add(new ArrayList<>());
        
        for(int[] edge: edges) {
            adj.get(edge[0]).add(edge[1]);
        }
        
        boolean[] vis = new boolean[V];
        Stack<Integer> st = new Stack<>();
        ArrayList<Integer> ans = new ArrayList<>();
        
        for(int i = 0; i < V; i++) {
            if(!vis[i]) dfs(i, adj, vis, st);
        }
        
        while(!st.isEmpty()) {
            ans.add(st.peek());
            st.pop();
        }
        return ans;
    }
}