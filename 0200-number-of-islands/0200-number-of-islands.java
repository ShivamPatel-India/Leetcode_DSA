class Solution {
    private void dfs(int x, int y, char[][] grid, boolean[][] vis) {
        if(x >= 0 && y >= 0 && x < grid.length && y < grid[0].length && grid[x][y] == '1' && !vis[x][y]) {
            vis[x][y] = true;
            dfs(x+1, y, grid, vis);
            dfs(x, y+1, grid, vis);
            dfs(x-1, y, grid, vis);
            dfs(x, y-1, grid, vis);
        } else return;
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