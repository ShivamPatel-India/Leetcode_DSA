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
        
        for(Pair pair: adj.get(node)) {
            int adjNode = pair.v;
            if(!vis[adjNode]) dfs(adjNode, adj, vis, st);
        }
        st.add(node);
    }
    public int[] shortestPath(int V, int E, int[][] edges) {
        // need to create an adjList out of edges array
        List<List<Pair>> adj = new ArrayList<>();
        for(int i = 0; i < V; i++) adj.add(new ArrayList<>());
        
        for(int edge[]: edges) {
            int u = edge[0];
            int v = edge[1];
            int wt = edge[2];
            adj.get(u).add(new Pair(v, wt));
        }
        
        // now perform a topo sort and store it in stack
        Stack<Integer> st = new Stack<>();
        boolean[] vis = new boolean[V];
        for(int i = 0; i < V; i++) {
            if(!vis[i]) dfs(i, adj, vis, st);
        }
        
        int[] dist = new int[V];
        Arrays.fill(dist, (int)1e9);
        
        dist[0] = 0;
        while(!st.isEmpty()) {
            int node = st.pop();
            int d = dist[node];
            
            for(Pair p: adj.get(node)) {
                int adjNode = p.v;
                int wt = p.wt;
                
                if(d + wt < dist[adjNode]) {
                    dist[adjNode] = d + wt;
                }
            }
        }
        
        for(int i = 0; i < V; i++) {
            if(dist[i] == (int)1e9) dist[i] = -1;
        }
        
        return dist;
    }
}