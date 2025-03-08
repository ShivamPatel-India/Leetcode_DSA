class Solution {
    public void dfs(int row, int col, int[][] image, int[][] ans,int color, int initialColor,int[] dx, int[] dy) {
        ans[row][col] = color;
        int rows = image.length;
        int cols = image[0].length;
        for(int i = 0 ; i < 4; i++) {
            int x = row + dx[i];
            int y = col + dy[i];

            if(x>=0 && y>=0 && x<rows && y<cols && ans[x][y]!=color && image[x][y]==initialColor) 
                dfs(x,y,image,ans,color,initialColor,dx,dy);
        }
    }
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int[][] ans = image;
        int initialColor = image[sr][sc];
        int[] dx = {-1,1,0,0};
        int[] dy = {0,0,-1,1};

        dfs(sr,sc,image,ans,color,initialColor,dx,dy);
        return ans;
    }
}