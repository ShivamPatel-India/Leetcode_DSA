class Solution {
    public void dfs(int ni, int nj, int[][] image, int color, int oc) {
        if(ni<0 || nj<0 || ni>=image.length || nj>=image[0].length || image[ni][nj]==color || image[ni][nj]!=oc) return;
        image[ni][nj] = color;
        dfs(ni+1, nj, image, color, oc);
        dfs(ni-1, nj, image, color, oc);
        dfs(ni, nj+1, image, color, oc);
        dfs(ni, nj-1, image, color, oc);
    }
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int originalColor = image[sr][sc];
        dfs(sr, sc, image, color, originalColor);
        return image;    
    }
}