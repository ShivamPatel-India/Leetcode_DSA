class Solution {
    private void sync(int i, int j, char[][] board) {
        if(i < 0 || i >= board.length || j < 0 || j >= board[0].length || board[i][j] == '.') return;
        board[i][j] = '.';
        sync(i, j+1, board);
        sync(i, j-1, board);
        sync(i+1, j, board);
        sync(i-1, j, board);
    }
    public int countBattleships(char[][] board) {
        int battleShips = 0;
        int m = board.length;
        int n = board[0].length;

        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(board[i][j] == 'X') {
                    battleShips++;
                    sync(i,j,board);
                }
            }
        }
        return battleShips;
    }
}