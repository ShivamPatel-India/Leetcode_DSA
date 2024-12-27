class Solution {
    public static void dfs(int node, ArrayList<ArrayList<Integer>> adj, int[] vis) {
        vis[node] = 1;
        for(Integer it: adj.get(node)) {
            if(vis[it] == 0) {
                dfs(it, adj, vis);
            }
        }
    }

    public int findCircleNum(int[][] isConnected) {
        // first of all lets change adj matrix to adj list
        int V = isConnected.length;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>();
        for(int i = 0; i<=V; i++) {
            adj.add(new ArrayList<Integer>());
        }

        for(int i = 0; i < V; i++) {
            for(int j = 0; j < V; j++) {
                if(isConnected[i][j] == 1 && i != j){
                    adj.get(i+1).add(j+1);
                    adj.get(j+1).add(i+1);
                }
            }
        }
        int vis[] = new int[V+1];
        int count = 0;
        for(int i = 1; i <= V; i++) {
            if(vis[i] == 0) {
                count++;
                dfs(i, adj, vis);
            }
        }
        return count;
    }
}