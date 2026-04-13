class Solution {
    private void dfs(int i, int j, int[][] grid, int[][] time, int currTime) {
        if(i<0 || j<0 || i>=grid.length || j>=grid[0].length || grid[i][j]==0 || currTime>=time[i][j]) return;
        time[i][j] = currTime;
        dfs(i+1, j, grid, time, currTime + 1);
        dfs(i-1, j, grid, time, currTime + 1);
        dfs(i, j+1, grid, time, currTime + 1);
        dfs(i, j-1, grid, time, currTime + 1);
    }
    public int orangesRotting(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] time = new int[m][n];
        for(int i  = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(grid[i][j] != 0) time[i][j] = Integer.MAX_VALUE;
            }
        }
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(grid[i][j] == 2) dfs(i, j, grid, time, 0);
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