class Solution {
    private void dfs(int node, int[][] isConnected, boolean[] vis) {
        vis[node] = true;
        int n = isConnected.length;
        for(int i = 0; i < n; i++) {
            if(isConnected[node][i] == 1 && !vis[i]) {
                dfs(i, isConnected, vis);
            }
        }
    }
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        int province = 0;
        boolean[] vis = new boolean[n];
        for(int i = 0; i < n; i++) {
            if(!vis[i]) {
                province++;
                dfs(i, isConnected, vis);
            }
        }
        return province;
    }
}