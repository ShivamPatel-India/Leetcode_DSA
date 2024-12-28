class Solution {
    public void dfs(int row, int col, int[][] image, int[][] ans, int[] dx, int[] dy,int color, int initialColor) {
        ans[row][col] = color;
        int rowCount = image.length;
        int colCount = image[0].length;
        for(int  i = 0; i < 4; i++) {
            int nrow = row + dx[i];
            int ncol = col + dy[i];

            if(nrow>=0 && nrow<rowCount && ncol>=0 && ncol<colCount && ans[nrow][ncol]!=color &&
            image[nrow][ncol]==initialColor) {
                dfs(nrow, ncol, image, ans, dx, dy, color, initialColor);
            }
        }
    }
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        // get the initial color
        int initialColor = image[sr][sc];

        // ans array to return the final output
        int[][] ans = image;

        // arrays defining the changes in direction coordinates
        int[] dx = {0,0,1,-1};
        int[] dy = {1,-1,0,0};

        // start the dfs recursion
        dfs(sr,sc,image,ans,dx,dy,color,initialColor);

        return ans;
    }
}