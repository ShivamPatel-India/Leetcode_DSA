class Solution {
    public void dfs(int[][] image, int[][] ans, int initialColor, int sr, int sc, int color, int[] dx, int[] dy) {  
        ans[sr][sc] = color;
        int rows = image.length;
        int cols = image[0].length;

        for(int i = 0; i < 4; i++) {
            int x = dx[i] + sr;
            int y = dy[i] + sc;

            if(x>=0 && y>=0 && x<rows && y<cols && image[x][y]==initialColor && ans[x][y]!=color) dfs(image, ans, initialColor, x, y, color, dx, dy);
        } 
    }
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int initialColor = image[sr][sc];
        int ans[][] = image;
        int[] dx = {-1,1,0,0};
        int[] dy = {0,0,-1,1};
        dfs(image, ans, initialColor, sr, sc, color, dx, dy);
        return ans;
    }
}