// User function Template for Java
class Solution {
    class Pair {
        int v, wt;
        Pair(int _v, int _wt) {
            this.v = _v;
            this.wt = _wt;
        }
    }
    private void dfs(int node, List<List<Pair>> adj, boolean[] vis, Stack<Integer> st) {
        vis[node] = true;
        for(Pair p: adj.get(node)) {
            int adjNode = p.v;
            
            if(!vis[adjNode]) dfs(adjNode, adj, vis, st);
        }
        st.add(node);
    }
    public int[] shortestPath(int V, int E, int[][] edges) {
        List<List<Pair>> adj = new ArrayList<>();
        for(int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }
        
        int[] dist = new int[V];
        Arrays.fill(dist, (int)1e9);
        dist[0] = 0;
        
        for(int[] edge: edges) {
            adj.get(edge[0]).add(new Pair(edge[1],edge[2]));
        }
        
        boolean[] vis = new boolean[V];
        Stack<Integer> st = new Stack<>();
        for(int i = 0; i < V; i++) {
            if(!vis[i]) dfs(i, adj, vis, st);
        }
        
        while(!st.isEmpty()) {
            int node = st.pop();
            
            for(Pair p: adj.get(node)) {
                int adjNode = p.v;
                int wt = p.wt;
                
                if(dist[adjNode] > dist[node] + wt) {
                    dist[adjNode] = dist[node] + wt;
                }
            }
        }
        for(int i = 0; i < V; i++) {
            if(dist[i] == (int)1e9) dist[i] = -1;
        }
        return dist;
    }
}