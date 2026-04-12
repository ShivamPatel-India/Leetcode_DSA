class Solution {
    private int[] dx = {-1,1,0,0};
    private int[] dy = {0,0,-1,1};

    private int dfs(int x, int y, int[][] grid, boolean[][] vis) {
        vis[x][y] = true;
        int fishCaught = grid[x][y];

        for(int k = 0; k < 4; k++) {
            int nx = x + dx[k];
            int ny = y + dy[k];

            if(nx < 0 || ny < 0 || nx >= grid.length || ny >= grid[0].length || vis[nx][ny] || grid[nx][ny] == 0) continue;
            fishCaught += dfs(nx, ny, grid, vis); 
        }
        return fishCaught;
    }
    public int findMaxFish(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        boolean[][] vis = new boolean[m][n];
        int maxFish = 0;

        for(int i = 0 ; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(grid[i][j] != 0 && !vis[i][j]) {
                    maxFish = Math.max(maxFish, dfs(i, j, grid, vis));
                }
            }
        }
        return maxFish;
    }
}