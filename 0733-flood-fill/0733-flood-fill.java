class Solution {
    public void dfs(int sr,int sc,int[][] image,int color,int initialColor,int[] dx,int[] dy,int[][] ans) {
        ans[sr][sc] = color;
        int rows = image.length;
        int cols = image[0].length;
        for(int i = 0; i < 4; i++) {
            int nrow = sr + dx[i];
            int ncol = sc + dy[i];

            if(nrow>=0 && ncol>=0 && nrow<rows && ncol<cols && ans[nrow][ncol]!=color && image[nrow][ncol]==initialColor) {
                dfs(nrow,ncol,image,color,initialColor,dx,dy,ans);
            }
        }
    }
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int initialColor = image[sr][sc];
        int[][] ans = image;
        int[] dx = {-1,1,0,0};
        int[] dy = {0,0,-1,1};

        dfs(sr,sc,image,color,initialColor,dx,dy,ans);
        return ans;
    }
}