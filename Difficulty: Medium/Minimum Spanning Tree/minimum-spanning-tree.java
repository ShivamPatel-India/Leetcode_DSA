class Solution {
    public int spanningTree(int V, int[][] edges) {
        List<List<int[]>> adj = new ArrayList<>();
        for(int i = 0; i < V; i++) adj.add(new ArrayList<>());
        
        for(int[] edge: edges) {
            adj.get(edge[0]).add(new int[]{edge[1], edge[2]});
            adj.get(edge[1]).add(new int[]{edge[0], edge[2]});
        }
        
        int sum = 0;    
        boolean[] vis = new boolean[V];
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        
        pq.add(new int[]{0,0});
    
        while(!pq.isEmpty()) {
            int node = pq.peek()[0];
            int wt = pq.peek()[1];
            pq.poll();
            
            if(vis[node]) continue;
            vis[node] = true;
            sum += wt;
            
            for(int[] neighbour: adj.get(node)) {
                int adjNode = neighbour[0];
                int adjWt = neighbour[1];
                    
                if(!vis[adjNode]) pq.add(new int[]{adjNode, adjWt});
            }
        }
        return sum;
    }
}
