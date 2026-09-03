class Solution {
    private void dfs(int[][] isConnected, int node, boolean[] vis, int n) {
        vis[node] = true;
        for(int i = 0; i < n; i++) {
            if(isConnected[node][i] == 1 && !vis[i]) {
                dfs(isConnected, i, vis, n);
            }
        }
    }
    // isConnected[][]
    //  | 0 1 2
    // -|-------------
    // 0| 1 1 0
    // 1| 1 1 0
    // 2| 0 0 1
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        boolean[] vis = new boolean[n+1];
        int province = 0;
        for(int i = 0; i < n; i++) {
            if(!vis[i]) {
                province++;
                dfs(isConnected, i, vis, n);
            }
        }
        return province;
    }
}