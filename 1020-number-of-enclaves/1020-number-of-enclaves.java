class Solution {
    // we can use the same trick as we used in surrounded regions (LC-130).
    // run the dfs/bfs from all the outer most rows/colums where cell contains 1 and mark all connected components visited
    // and then find out all the unvisited ones that'll be our answer
    private int[] dx = {-1,1,0,0};
    private int[] dy = {0,0,-1,1};
    private void dfs(int x, int y, int[][] grid) {
        if(x<0 || y<0 || x>=grid.length || y>=grid[0].length || grid[x][y]==0) return;
        grid[x][y] = 0;
        dfs(x+1, y, grid);
        dfs(x, y+1, grid);
        dfs(x-1, y, grid);
        dfs(x, y-1, grid);
    }
    public int numEnclaves(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        // first row - last row
        for(int k = 0; k < n; k++) {
            if(grid[0][k] == 1) dfs(0,k,grid);
            if(grid[m-1][k] == 1) dfs(m-1,k,grid);
        }
        //first column - last column
        for(int k = 0; k < m; k++) {
            if(grid[k][0] == 1) dfs(k,0,grid);
            if(grid[k][n-1] == 1) dfs(k,n-1,grid);
        }
        int count = 0;
        for(int[] g: grid) for(int i: g) if(i == 1) count++;
        return count;
    }
}