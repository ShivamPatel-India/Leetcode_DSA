class Solution {
    private void dfs(int x, int y, int[][] image, int originalColor, int color) {
        if(x < 0 || y < 0 || x >= image.length || y >= image[0].length || image[x][y] != originalColor ) return;
        image[x][y] = color;
        dfs(x+1, y, image, originalColor, color);
        dfs(x, y+1, image, originalColor, color);
        dfs(x-1, y, image, originalColor, color);
        dfs(x, y-1, image, originalColor, color);
    }
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int m = image.length;
        int n = image[0].length;
        int originalColor = image[sr][sc];
        if(originalColor == color) return image;
        dfs(sr, sc, image, originalColor, color);
        return image;
    }
}