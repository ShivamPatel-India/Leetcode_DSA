class Solution {
    class Pair {
        int v, wt;
        Pair(int _v, int _wt) {
            this.v = _v;
            this.wt = _wt;
        }
    }
    public int[] dijkstra(int V, int[][] edges, int src) {
        List<List<Pair>> adj = new ArrayList<>();
        for(int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }
        
        for(int[] edge: edges) {
            adj.get(edge[0]).add(new Pair(edge[1], edge[2]));
            adj.get(edge[1]).add(new Pair(edge[0], edge[2]));
        }
        
        int[] dist = new int[V];
        Arrays.fill(dist, (int)1e9);
        
        PriorityQueue<Pair> pq = new PriorityQueue<>((x, y) -> x.wt - y.wt);
        
        dist[src] = 0;
        pq.add(new Pair(src, 0));
        
        while(!pq.isEmpty()) {
            int node = pq.peek().v;
            int d = pq.peek().wt;
            pq.remove();
            
            for(Pair p: adj.get(node)) {
                int adjNode = p.v;
                int wt = p.wt;
                
                if(dist[adjNode] > d + wt) {
                    dist[adjNode] = d + wt;
                    pq.add(new Pair(adjNode, d + wt));
                }
            }
        }
        return dist;
    }
}