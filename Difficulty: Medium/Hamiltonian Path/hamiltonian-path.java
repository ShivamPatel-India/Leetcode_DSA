// User function Template for Java
class Solution {
    private boolean DFS(int node, List<List<Integer>> adj, boolean[] vis, int count) {
        vis[node] = true;
        count++;
        
        if(count == adj.size()-1) return true;
        
        for(int adjNode: adj.get(node)) {
            if(!vis[adjNode] && DFS(adjNode, adj, vis, count)) {
                return true;
            }
        }
        vis[node] = false;
        count--;
        return false;
    }
    boolean check(int n, int m, ArrayList<ArrayList<Integer>> edges) {
        List<List<Integer>> adj = new ArrayList<>();
        for(int i = 0; i <= n; i++) adj.add(new ArrayList<>());
        for(ArrayList<Integer> edge: edges) {
            adj.get(edge.get(0)).add(edge.get(1));
            adj.get(edge.get(1)).add(edge.get(0));
        }
        
        boolean[] vis = new boolean[n+1];
        int count = 0;
        for(int i = 0; i < n; i++) {
            if(DFS(i, adj, vis, count)) return true; 
        }
        return false;
    }
}