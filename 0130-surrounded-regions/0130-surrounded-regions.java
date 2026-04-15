class Solution {
    // the trick here is to hit the dfs/bfs from all the 'O' present in the corners(first-last row and column) and mark them as visited.
    // after that we can find other unvisited 'O' in the matrix and can say they essentially form a surrounded region and we can mark them as 'X'
    private int[] dx = {-1,1,0,0};
    private int[] dy = {0,0,-1,1};
    private void dfs(int x, int y, char[][] board, boolean[][] vis) {
        vis[x][y] = true;
        for(int k = 0; k < 4; k++) {
            int nx = x + dx[k];
            int ny = y + dy[k];
            if(nx<0 || ny<0 || nx>=board.length || ny>=board[0].length || vis[nx][ny] || board[nx][ny] == 'X') continue;
            dfs(nx, ny, board, vis);
        }
    }
    public void solve(char[][] board) {
        int m = board.length;
        int n = board[0].length;
        boolean[][] vis = new boolean[m][n];

        // first row - last row
        for(int k = 0; k < n; k++) {
            if(board[0][k] == 'O' && !vis[0][k]) dfs(0,k,board,vis);
            if(board[m-1][k] == 'O' && !vis[m-1][k]) dfs(m-1,k,board,vis);
        }

        // fist column - last column
        for(int k = 0; k < m; k++) {
            if(board[k][0] == 'O' && !vis[k][0]) dfs(k,0,board,vis);
            if(board[k][n-1] == 'O' && !vis[k][n-1]) dfs(k,n-1,board,vis);
        }
        
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(!vis[i][j] && board[i][j] == 'O') board[i][j] = 'X';
            }
        }
    }
}