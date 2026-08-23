class Solution {
    private int m;
    private int n;
    private void dfs(int[][] image, int i, int j, int color, int originalColor) {
        if(i < 0 || j < 0 || i >= m || j >= n || image[i][j] == color || image[i][j] != originalColor) return;
        image[i][j] = color;
        dfs(image, i+1, j, color, originalColor);
        dfs(image, i-1, j, color, originalColor);
        dfs(image, i, j+1, color, originalColor);
        dfs(image, i, j-1, color, originalColor);
    }
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        m = image.length;
        n = image[0].length;
        int originalColor = image[sr][sc];
        dfs(image, sr, sc, color, originalColor);
        return image;
    }
}