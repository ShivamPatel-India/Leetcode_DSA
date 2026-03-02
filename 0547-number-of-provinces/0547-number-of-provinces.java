class Solution {
    public void dfs(int node, boolean[] vis, ArrayList<ArrayList<Integer>> adj) {
        vis[node] = true;
        for(int it: adj.get(node)) if(!vis[it]) dfs(it, vis, adj);
    }
    public int findCircleNum(int[][] isConnected) {
        int V = isConnected.length;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>();
        for(int i = 0; i <= V; i++) {
            adj.add(new ArrayList<>());
        }
        // verticies are starting form 1 that's why [V+1]
        boolean[] vis = new boolean[V+1];

        // converting adj matrix into adj list
        for(int i = 0; i < V; i++) {
            for(int j = 0; j < V; j++) {
                if(isConnected[i][j] != 0) {
                    adj.get(i+1).add(j+1);
                    adj.get(j+1).add(i+1);
                }
            }
        }

        int count = 0;
        for(int i = 1; i <= V; i++) {
            if(!vis[i]) {
                count++;
                dfs(i, vis, adj);
            }
        }
        return count;
    }
}