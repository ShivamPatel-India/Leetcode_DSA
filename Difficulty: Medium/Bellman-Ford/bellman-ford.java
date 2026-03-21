// User function Template for Java

class Solution {
    public int[] bellmanFord(int V, int[][] edges, int src) {
        int[] dist = new int[V];
        Arrays.fill(dist, (int)1e8);
        
        dist[src] = 0;
        
        for(int i = 0; i < V-1; i++) {
            for(int[] edge: edges) {
                if(dist[edge[0]] != (int)1e8 && dist[edge[0]] + edge[2] < dist[edge[1]]) {
                    dist[edge[1]] = dist[edge[0]] + edge[2];
                }
            }
        }
        
        for(int[] edge: edges) {
            if(dist[edge[0]] != (int)1e8 && dist[edge[0]] + edge[2] < dist[edge[1]]) {
                return new int[]{-1};
            }
        }
        return dist;
    }
}
