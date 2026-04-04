class Solution {
    private void DFS(int node, List<List<Integer>> adj, boolean[] vis, Stack<Integer> st) {
        vis[node] = true;
        for(int adjNode: adj.get(node)) {
            if(!vis[adjNode]) DFS(adjNode, adj, vis, st);
        }
        st.push(node);
    }
    private void DFSNormal(int node, List<List<Integer>> adj, boolean[] vis) {
        vis[node] = true;
        for(int adjNode: adj.get(node)) {
            if(!vis[adjNode]) DFSNormal(adjNode, adj, vis);
        }
    }
    // Function to find number of strongly connected components in the graph
    public int kosaraju(int V, int[][] edges) {
        boolean[] vis = new boolean[V];
        List<List<Integer>> adj = new ArrayList<>();
        for(int i = 0; i < V; i++) adj.add(new ArrayList<>());
        for(int[] e: edges) adj.get(e[0]).add(e[1]);
        
        Stack<Integer> st = new Stack<>();
        for(int i = 0; i < V; i++) {
            if(!vis[i]) DFS(i, adj, vis, st);
        }
        
        List<List<Integer>> adjT = new ArrayList<>();
        for(int i = 0; i < V; i++) adjT.add(new ArrayList<>());
        for(int i = 0; i < V; i++) {
            vis[i] = false;
            for(int it: adj.get(i)) {
                adjT.get(it).add(i);
            }
        }
        
        int scc = 0;
        while(!st.isEmpty()) {
            int node = st.pop();
            if(!vis[node]) {
                scc++;
                DFSNormal(node, adjT, vis);
            }
        }
        return scc;
    }
}