class Solution {
    class Pair {
        int node;
        int wt;
        Pair(int _node, int _wt) {
            this.node = _node;
            this.wt = _wt;
        }
    }
    public int spanningTree(int V, int[][] edges) {
        List<List<Pair>> adj = new ArrayList<>();
        for(int i = 0; i < V; i++) adj.add(new ArrayList<>());
        
        for(int[] edge: edges) {
            adj.get(edge[0]).add(new Pair(edge[1], edge[2]));
            adj.get(edge[1]).add(new Pair(edge[0], edge[2]));
        }
        
        int sum = 0;
        boolean[] vis = new boolean[V];
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> a.wt - b.wt);
        pq.add(new Pair(0,0));
        
        while(!pq.isEmpty()) {
            Pair p = pq.poll();
            int node = p.node;
            int wt = p.wt;
            
            if(vis[node]) continue;
            vis[node] = true;
            sum += wt;
            
            for(Pair np: adj.get(node)) {
                int adjNode = np.node;
                int adjWt = np.wt;
                
                if(!vis[adjNode]) pq.add(new Pair(adjNode, adjWt));
            }
        }
        return sum;
    }
}
