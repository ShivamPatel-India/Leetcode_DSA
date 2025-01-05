class Solution {
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        boolean[] vis = new boolean[n];
        int numOfProvince = 0;

        for(int i = 0; i < n; i++) {
            if(vis[i] == false) {
                numOfProvince++;
                dfs(i, isConnected, vis);
            }
        }
        return numOfProvince;
    }

    public static void dfs(int currentNode, int[][] isConnected, boolean[] vis) {
        vis[currentNode] = true;
        for(int i = 0; i < isConnected.length; i++) {
            if(isConnected[currentNode][i] == 1 && !vis[i]) {
                dfs(i, isConnected, vis);
            }
        }
    }
}