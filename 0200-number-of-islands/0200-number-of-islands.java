class Solution {
    private int[] dx = {-1, 1, 0, 0};
    private int[] dy = {0, 0, 1, -1};
    private void dfs(int x, int y, char[][] grid, boolean[][] vis) {
        vis[x][y] = true;
        for(int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            // if this new coordinates are valid and the node on this coordinate is unvisited then only we fire dfs from this coords
            if(nx >=0 && ny >= 0 && nx < grid.length && ny < grid[0].length && grid[nx][ny] == '1' && !vis[nx][ny]) {
                dfs(nx, ny, grid, vis);
            }
        }
    }
    public int numIslands(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        // since node is represented in matrix, each node would have its (x,y) to describe its position, so we need 2D vis array to check if this co-ordinate has been visited or not.
        boolean[][] vis = new boolean[m][n];
        int islands = 0;
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(grid[i][j] == '1' && !vis[i][j]) {
                    islands++;
                    dfs(i, j, grid, vis);
                }
            }
        }
        return islands;
    }
}