class Solution {
    public boolean isBipartite(int[][] graph) {
        int V = graph.length;
        int[] color = new int[V];

        for(int i = 0; i < V; i++) {
            color[i] = -1;
        }
        
        // queue will contain adjacent node and its color
        Queue<int[]> q = new LinkedList<>();
        for(int i = 0; i < V; i++) {
            if(color[i] != -1) continue; // already visited so skip

            // starting fresh BFS with every new component
            q.offer(new int[]{i,0});
            color[i] = 0;

            while(!q.isEmpty()) {
                int node = q.peek()[0];
                int nodeColor = q.peek()[1];
                q.poll();

                for(int adjNode: graph[node]) {
                    if(color[adjNode] == -1) {
                        q.offer(new int[]{adjNode, 1-nodeColor});
                        color[adjNode] = 1-nodeColor;
                    } else if(color[adjNode] == nodeColor) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}