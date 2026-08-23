class Solution {
    private int m;
    private int n;
    private int[][] time;
    private void dfs(int i, int j, int[][] grid, int currTime) {
        if(i < 0 || j < 0 || i >= m || j >= n || grid[i][j] == 0 || time[i][j] <= currTime) return;
        time[i][j] = currTime;
        dfs(i+1, j, grid, currTime + 1);
        dfs(i-1, j, grid, currTime + 1);
        dfs(i, j+1, grid, currTime + 1);
        dfs(i, j-1, grid, currTime + 1);
    }
    public int orangesRotting(int[][] grid) {
        m = grid.length;
        n = grid[0].length;
        time = new int[m][n];
        for(int i = 0 ; i < m; i++) 
            for(int j = 0; j < n; j++) 
                if(grid[i][j] != 0) time[i][j] = Integer.MAX_VALUE;
        
        for(int i = 0; i < m; i++) 
            for(int j = 0; j < n; j++)
                if(grid[i][j] == 2) dfs(i, j, grid, 0);

        int t = Integer.MIN_VALUE;
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(time[i][j] == Integer.MAX_VALUE) return -1;
                t = Math.max(t, time[i][j]);
            }
        }
        return t;
    }
}