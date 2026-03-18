class Solution {
    public int[] shortestPath(int V, int[][] edges, int src) {
        int[] dist = new int[V];
        for(int i = 0; i < V; i++) {
            dist[i] = (int)1e9;
        }
        
        List<List<Integer>> adj = new ArrayList<>();
        for(int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }
        
        for(int[] edge: edges) {
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }
        
        Queue<Integer> q = new LinkedList<>();
        
        dist[src] = 0;
        q.add(src);
        
        while(!q.isEmpty()) {
            int node = q.poll();
            
            for(int adjNode: adj.get(node)) {
                if(dist[adjNode] > dist[node] + 1) {
                    dist[adjNode] = dist[node] + 1;
                    q.add(adjNode);
                }
            }
        }
        
        for(int i = 0; i < V; i++) {
            if(dist[i] == (int)1e9) dist[i] = -1;
        }
        return dist;
    }
}
