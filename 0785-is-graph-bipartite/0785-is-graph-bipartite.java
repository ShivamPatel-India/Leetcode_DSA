class Solution {
    private boolean dfs(int node, int[][] graph, int[] color, int clr) {
        color[node] = clr;
        for(int adjNode: graph[node]) {
            if(color[adjNode] == -1) {
                if(!dfs(adjNode, graph, color, 1-clr)) return false;
            } 
            else if(color[adjNode] == clr) return false;
        }
        return true;
    }
    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        int[] color = new int[n];
        Arrays.fill(color, -1);

        for(int i = 0; i < n; i++) if(color[i] == -1) if(!dfs(i, graph, color, 0)) return false;
        return true;
    }
}