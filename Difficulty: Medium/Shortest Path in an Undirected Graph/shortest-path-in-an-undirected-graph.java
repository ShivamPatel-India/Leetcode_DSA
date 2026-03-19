class Solution {
    class Pair {
        int v, wt;
        Pair(int _v, int _wt) {
            this.v = _v;
            this.wt = _wt;
        }
    }
    public List<Integer> shortestPath(int n, int m, int edges[][]) {
        List<List<Pair>> adj = new ArrayList<>();
        for(int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
        }
        
        for(int[] edge: edges) {
            adj.get(edge[0]).add(new Pair(edge[1], edge[2]));
            adj.get(edge[1]).add(new Pair(edge[0], edge[2]));
        }
        
        int[] dist = new int[n+1];
        for(int i = 0; i <= n; i++) dist[i] = (int)1e9;
        
        int[] parent = new int[n+1];
        for(int i = 0; i <= n; i++) parent[i] = i;
        
        PriorityQueue<Pair> pq = new PriorityQueue<>((x, y) -> x.wt - y.wt);
        
        dist[1] = 0;
        pq.add(new Pair(1, 0));
        
        while(!pq.isEmpty()) {
            int node = pq.peek().v;
            int d = pq.peek().wt;
            pq.remove();
            
            for(Pair p: adj.get(node)) {
                int adjNode = p.v;
                int wt = p.wt;
                if(dist[adjNode] > d + wt) {
                    dist[adjNode] = d + wt;
                    parent[adjNode] = node;
                    pq.add(new Pair(adjNode, d + wt));
                }
            }
        }
        
        List<Integer> path = new ArrayList<>();
        if(dist[n] == (int)1e9) {
            path.add(-1);
            return path;
        }
        
        int node = n;
        while(parent[node] != node) {
            path.add(node);
            node = parent[node];
        }
        path.add(1);
        Collections.reverse(path);
        
        path.add(0,dist[n]);
        return path;
    }
}