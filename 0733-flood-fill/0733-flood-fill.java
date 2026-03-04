class Solution {
    public void dfs(int row, int col, int[][] image, int[][] ans, int[] dx, int[] dy, int initialColor, int color) {
        ans[row][col] = color;
        for(int i = 0; i < 4; i++) {
            int x = dx[i] + row;
            int y = dy[i] + col;

            if(x>=0 && y >=0 && x<image.length && y<image[0].length && image[x][y] == initialColor && ans[x][y] != color) {
                dfs(x, y, image, ans, dx, dy, initialColor, color);
            }
        }
    }
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int initialColor = image[sr][sc];
        int ans[][] = image;
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};
        dfs(sr, sc, image, ans, dx, dy, initialColor, color);
        return ans;
    }
}