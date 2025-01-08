class Solution {
    public void bfs(int row, int col, int[][] vis, int[][] grid, Queue<int[]> q, int[] delrow, int[] delcol) {
        q.add(new int[]{row, col});
        vis[row][col] = 1;
        int n = grid.length;
        int m = grid[0].length;

        while(!q.isEmpty()) {
            int x = q.peek()[0];
            int y = q.peek()[1];
            q.remove();

            for(int i = 0; i<4; i++) {
                int nrow = x + delrow[i];
                int ncol = y + delcol[i];

                if(nrow>=0 && nrow<n && ncol>=0 && ncol<m && vis[nrow][ncol] == 0 && 
                grid[nrow][ncol] == 1) {
                    vis[nrow][ncol] = 1;
                    q.add(new int[]{nrow,ncol});
                }
            }
        }
    }
    public int numEnclaves(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        int delrow[] = {-1,0,+1,0};
        int delcol[] = {0,-1,0,+1};
        int vis[][] = new int[rows][cols];
        Queue<int[]> q = new LinkedList<>();

        // first and last rows
        for(int j = 0; j < cols; j++) {
            if(vis[0][j] == 0 && grid[0][j] == 1) {
                bfs(0, j, vis, grid, q, delrow, delcol);
            }

            if(vis[rows-1][j] == 0 && grid[rows-1][j] == 1) {
                bfs(rows-1, j, vis, grid, q, delrow, delcol);
            }
        }

        // first and last cols
        for(int i = 0; i < rows; i++) {
            if(vis[i][0] == 0 && grid[i][0] == 1) {
                bfs(i, 0, vis, grid, q, delrow, delcol);
            }

            if(vis[i][cols-1] == 0 && grid[i][cols-1] == 1) {
                bfs(i, cols-1, vis, grid, q, delrow, delcol);
            }
        }

        int count = 0;
        for(int i = 0; i < rows; i++) {
            for(int j = 0; j < cols; j++) {
                if(vis[i][j]==0 && grid[i][j] == 1) 
                    count++;
            }
        }
        return count;
    }
}