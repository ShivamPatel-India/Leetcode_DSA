class Solution {
    public int findCircleNum(int[][] isConnected) {
       int n = isConnected.length;
       boolean[] vis = new boolean[n];
        int numOfProvince = 0;

       for(int i = 0; i < n; i++) {
            if(!vis[i]) {
                numOfProvince++;
                dfs(i, vis, isConnected);
            }
       } 
       return numOfProvince;
    }
    
    public void dfs(int currentNode, boolean[] vis, int[][] isConnected) {
        vis[currentNode] = true;
        for(int i = 0; i < isConnected.length; i++) {
            if(isConnected[currentNode][i] == 1 && !vis[i]) {
                dfs(i, vis, isConnected);
            }
        }
    }
}