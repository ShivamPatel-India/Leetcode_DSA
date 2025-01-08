class Solution {
    public void dfs(int row, int col, int[][] vis, char[][] board, int[] delrow, int[] delcol) {
        vis[row][col] = 1;
        int n = board.length;
        int m = board[0].length;

        for(int i= 0; i < 4; i++) {
            int nrow = row + delrow[i];
            int ncol = col + delcol[i];

            if(nrow>=0 && nrow < n && ncol>=0 && ncol<m && vis[nrow][ncol] == 0 && board[nrow][ncol]=='O') 
                dfs(nrow, ncol, vis, board, delrow, delcol);
        }
    }

    public void solve(char[][] board) {
        int row = board.length;
        int col = board[0].length;
        int vis[][] = new int[row][col];
        int delrow[] = {-1,0,+1,0};
        int delcol[] = {0,-1,0,+1};

        for(int j = 0; j < col; j++) {
            // first row
            if(vis[0][j] == 0 && board[0][j] == 'O') {
                dfs(0, j, vis, board, delrow, delcol);
            } 

            // last row
            if(vis[row-1][j] == 0 && board[row-1][j] == 'O') {
                dfs(row-1, j, vis, board, delrow, delcol);
            }
        }    

        for(int i = 0; i < row; i++) {
            // first col
            if(vis[i][0] == 0 && board[i][0] == 'O') {
                dfs(i, 0, vis, board, delrow, delcol);
            }

            // last col
            if(vis[i][col-1] == 0 && board[i][col-1] == 'O') {
                dfs(i, col-1, vis, board, delrow, delcol);
            }
        }

        for(int i = 0; i < row; i++) {
            for(int j = 0; j < col; j++) {
                if(vis[i][j] == 0 && board[i][j] == 'O') 
                    board[i][j] = 'X';
            }
        }
    }
}