class Solution {
    private int n;
    private int m;
    private void dfs(int[][] image, int sr, int sc, int color, int originalColor) {
        if(sr < 0 || sc < 0 || sr >= m || sc >= n || image[sr][sc] != originalColor || image[sr][sc] == color) return;
        image[sr][sc] = color;
        dfs(image, sr+1, sc, color, originalColor);
        dfs(image, sr-1, sc, color, originalColor);
        dfs(image, sr, sc+1, color, originalColor);
        dfs(image, sr, sc-1, color, originalColor);
    }
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        // in this problem, we can just apply the bfs and repaint every cell
        m = image.length;
        n = image[0].length;
        int originalColor = image[sr][sc];
        dfs(image, sr, sc, color, originalColor);
        return image;
    }
}