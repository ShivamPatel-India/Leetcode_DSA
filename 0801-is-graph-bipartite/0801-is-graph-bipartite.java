class Solution {
    public boolean dfs(int node, int clr, int[][] graph, int[] color) {
        color[node] = clr;

        for(int i = 0; i < graph[node].length; i++) {
            int v = graph[node][i];
            if(color[v] == -1) {
                if(!dfs(v,1-clr,graph,color)) return false;
            } else if (color[v] == clr) return false;
        }
        return true;
    }
    public boolean isBipartite(int[][] graph) {
        int V = graph.length;
        int[] color = new int[V];

        for(int i = 0; i < V; i++) {
            color[i] = -1;
        }

        for(int i = 0; i < V; i++) {
            if(color[i] == -1) {
                if(!dfs(i,0,graph, color)) return false;
            }
        }
        return true;
    }
}