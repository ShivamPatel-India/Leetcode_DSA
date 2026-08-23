class Solution {
    private int n;
    private int m;
    private int[][] time;
    public void dfs(int[][] grid, int i, int j, int currTime) {
        if(i < 0 || j < 0 || i >= m || j >= n || grid[i][j] == 0 || currTime >= time[i][j]) return;
        time[i][j] = currTime;
        dfs(grid, i+1, j, currTime + 1);
        dfs(grid, i-1, j, currTime + 1);
        dfs(grid, i, j+1, currTime + 1);
        dfs(grid, i, j-1, currTime + 1);
    }
    public int orangesRotting(int[][] grid) {
        m = grid.length;
        n = grid[0].length;

        // we can run dfs from every rotten orange and record a time in separate 2D array
        time = new int[m][n];
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(grid[i][j] != 0) time[i][j] = Integer.MAX_VALUE;
            }
        }

        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(grid[i][j] == 2) {
                    dfs(grid, i, j, 0);
                }
            }
        }
        int minTime = Integer.MIN_VALUE;
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(time[i][j] == Integer.MAX_VALUE) return -1;
                minTime = Math.max(minTime, time[i][j]);
            }
        }
        return minTime;
    }
}