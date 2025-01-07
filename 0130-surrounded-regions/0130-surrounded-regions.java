class Solution {
    public void dfs(int row, int col, int[][] vis, char[][] board, int[] delRow, int[] delCol) {
        vis[row][col] = 1;
        int n = board.length;
        int m = board[0].length;

        for(int i = 0; i < 4; i++) {
            int nrow = row + delRow[i];
            int ncol = col + delCol[i];

            if(nrow >= 0 && nrow < n && ncol >= 0 && ncol < m && vis[nrow][ncol] == 0
            && board[nrow][ncol] == 'O') {
                dfs(nrow, ncol, vis, board, delRow, delCol);
            }  
        }

    }

    public void solve(char[][] board) {
        int row = board.length;
        int col = board[0].length;

        int[][] vis = new int[row][col];
        int[] delRow = {-1,0,+1,0};
        int[] delCol = {0,-1,0,+1};

        // traverse the first row and last row and apply dfs if found '0' in them;
        for(int j = 0; j < col; j++) {
            // first row
            if(vis[0][j] == 0 && board[0][j] == 'O') {
                dfs(0,j,vis,board,delRow,delCol);
            }

            // last row
            if(vis[row-1][j] == 0 && board[row-1][j] == 'O') {
                dfs(row-1,j,vis,board,delRow,delCol);
            }
        }

        // traverse the first and last column and apply dfs if found 0
        for(int i = 0; i < row; i++) {
            // first col
            if(vis[i][0] == 0 && board[i][0] == 'O') {
                dfs(i,0,vis,board,delRow,delCol);
            }

            // last col
            if(vis[i][col-1] == 0 && board[i][col-1] == 'O') {
                dfs(i,col-1,vis,board,delRow,delCol);
            }
        }

        // if unvisited 0 then convert it to X
        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++) {
                if(vis[i][j] != 1 && board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
            }
        }
    }
}