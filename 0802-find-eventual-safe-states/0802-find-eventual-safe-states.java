class Solution {
    public boolean dfs(int node, int[][] graph, boolean[] vis, boolean[] pathVis) {
        vis[node] = true;
        pathVis[node] = true;

        for(int i = 0; i < graph[node].length; i++) {
            int adjNode = graph[node][i];
            if(!vis[adjNode]) {
                if(dfs(adjNode, graph, vis, pathVis)) return true;
            }
            else if (pathVis[adjNode]) return true;
        }
        pathVis[node] = false;
        return false;
    }
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int V = graph.length;
        boolean[] vis = new boolean[V];
        boolean[] pathVis = new boolean[V];

        for(int i = 0; i < V; i++) {
            if(!vis[i]) dfs(i, graph, vis, pathVis);
        }
        List<Integer> ans = new ArrayList<>();
        for(int i = 0; i < V; i++) {
            if(!pathVis[i]) ans.add(i);
        }
        return ans;
    }
}