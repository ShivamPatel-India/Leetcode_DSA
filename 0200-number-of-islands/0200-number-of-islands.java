class Solution {
    private void dfs(int row, int col, boolean[][] vis, char[][] grid, int[] dx, int[] dy) {
        vis[row][col] = true;
        for(int i = 0; i < 4; i++) {
            int nrow = dx[i] + row;
            int ncol = dy[i] + col;

            if(nrow>=0 && ncol>=0 && nrow<grid.length && ncol<grid[0].length && !vis[nrow][ncol] && grid[nrow][ncol] == '1') {
                dfs(nrow, ncol, vis, grid, dx, dy);
            }
        }
    }
    public int numIslands(char[][] grid) {
        int count = 0;
        int n = grid.length;
        int m = grid[0].length;
        boolean[][] vis = new boolean[n][m];
        int[] dx = {-1,1,0,0};
        int[] dy = {0,0,-1,1};

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(!vis[i][j] && grid[i][j] == '1') {
                    count++;
                    dfs(i, j, vis, grid, dx, dy);
                }
            }
        }
        return count;
    }
}