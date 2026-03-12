class Solution {
    public boolean dfs(int node, int[][] graph, int[] color, int colorCode) {
        color[node] = colorCode;

        for(int i = 0; i < graph[node].length; i++) {
            int adjNode = graph[node][i];
            if(color[adjNode] == -1) {
                if(dfs(adjNode, graph, color, 1-colorCode) == false) return false;
            }
            else if(color[adjNode] == colorCode) return false;
        }
        return true;
    }
    public boolean isBipartite(int[][] graph) {
        int V = graph.length;
        int[] color = new int[V];

        // initially all the nodes are uncolored i.e., -1
        for(int i = 0; i < V; i++) color[i] = -1;

        // 1. colors being used: 0 and 1
        // 2. graph may not be  connected so we need to consider all the components
        for(int i = 0; i < V; i++) {
            if(color[i] == -1) {
                if(dfs(i, graph, color, 0) == false) return false;
            }
        }
        return true;


    }
}