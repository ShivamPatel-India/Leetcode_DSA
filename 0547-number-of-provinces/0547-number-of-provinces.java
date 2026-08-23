class Solution {
    private int n;
    public void dfs(int[][] isConnected, boolean[] vis, int node) {
        vis[node] = true;
        for(int i = 0; i < n; i++) {
            if(isConnected[node][i] == 1 && !vis[i]) {
                dfs(isConnected, vis, i);
            }
        }
    }
    public int findCircleNum(int[][] isConnected) {
        n = isConnected.length;
        boolean[] vis = new boolean[n];

        int province = 0;
        for(int i = 0; i < n; i++) {
            if(!vis[i]) {
                province++;
                dfs(isConnected, vis, i);
            }
        }
        return province;
    }
}