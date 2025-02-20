class Solution {
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        int numOfProvince = 0;
        boolean[] vis = new boolean[n];

        for(int i = 0; i < n; i++) {
            if(!vis[i]) numOfProvince++;
            dfs(i, isConnected, vis);
        }
        return numOfProvince;
    }
    public void dfs(int cn, int[][] isConnected, boolean[] vis) {
        vis[cn] = true;
        for(int i = 0; i < isConnected.length; i++) 
            if(isConnected[cn][i] == 1 && !vis[i])
                dfs(i, isConnected, vis);
    }
}