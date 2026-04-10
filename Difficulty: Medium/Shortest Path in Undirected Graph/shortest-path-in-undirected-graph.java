class Solution {
    public int[] shortestPath(int V, int[][] edges, int src) {
        List<List<Integer>> adj = new ArrayList<>();
        for(int i = 0; i < V; i++) adj.add(new ArrayList<>());
        for(int[] e: edges) {
            adj.get(e[0]).add(e[1]);
            adj.get(e[1]).add(e[0]);
        }
        
        int[] dist = new int[V];
        Arrays.fill(dist, (int)1e9);
        
        Queue<Integer> q = new LinkedList<>();
        q.add(src);
        dist[src] = 0;
        
        while(!q.isEmpty()) {
            int node = q.poll();
            
            for(int adjNode: adj.get(node)) {
                if(dist[adjNode] > 1 + dist[node]) {
                    dist[adjNode] = 1 + dist[node];
                    q.add(adjNode);
                }
            }
        }
        for(int i = 0; i < V; i++) if(dist[i] == (int)1e9) dist[i] = -1;
        return dist;
    }
}
