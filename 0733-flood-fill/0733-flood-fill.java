class Solution {
    public int[] dx = {-1,1,0,0};
    public int[] dy = {0,0,-1,1};
    public void dfs(int i, int j, int[][] image, int color, int oc) {
        image[i][j] = color;
        for(int k = 0; k < 4; k++) {
            int ni = i + dx[k];
            int nj = j + dy[k];

            if(ni<0 || nj<0 || ni>=image.length || nj>=image[0].length || image[ni][nj]==color || image[ni][nj]!=oc) continue;
            dfs(ni, nj, image, color, oc);
        }
    }
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int originalColor = image[sr][sc];
        dfs(sr, sc, image, color, originalColor);
        return image;    
    }
}