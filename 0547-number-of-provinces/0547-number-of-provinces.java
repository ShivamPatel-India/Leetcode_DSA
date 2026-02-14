class Solution {
    public void dfs(int node, ArrayList<ArrayList<Integer>> adj, boolean[] vis) {
        vis[node] = true;
        for(int it: adj.get(node)) if(!vis[it]) dfs(it, adj, vis);
    }
    public int findCircleNum(int[][] isConnected) {
        int V = isConnected.length;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>();
        for(int i = 0; i <= V; i++) {
            adj.add(new ArrayList<>());
        }
        for(int i = 0 ; i < V; i++) {
            for(int j = 0; j < V; j++) {
                if(isConnected[i][j] != 0) {
                    adj.get(i+1).add(j+1);
                    adj.get(j+1).add(i+1);
                }
            }
        }
        int count = 0;
        boolean[] vis = new boolean[V+1];
        for(int i = 1; i <= V; i++) {
            if(!vis[i]) {
                count++;
                dfs(i, adj, vis);
            }
        }
        return count;
    }
}