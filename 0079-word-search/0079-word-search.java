class Solution {
    public boolean exist(char[][] board, String word) {
        int rows = board.length;
        int cols = board[0].length;
        boolean[][] path = new boolean[rows][cols];

        for(int i = 0; i < rows; i++) {
            for(int j = 0; j < cols; j++) {
                if(dfs(board, word, 0, i, j, path)) return true;
            }
        }
        return false;
    }
    private boolean dfs(char[][] board, String word, int i, int r, int c, boolean[][] path) {
        if(i == word.length()) return true;
        if(r<0 || c<0 || r>= board.length || c>= board[0].length || path[r][c] == true || word.charAt(i) != board[r][c]) return false;
        path[r][c] = true;
        boolean res = (dfs(board, word, i+1, r+1, c, path) ||
                        dfs(board, word, i+1, r-1, c, path) ||
                        dfs(board, word, i+1, r, c+1, path) ||
                        dfs(board, word, i+1, r, c-1, path));

        path[r][c] = false;
        return res;
    }
}