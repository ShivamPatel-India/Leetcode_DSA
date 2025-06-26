import java.util.*;

class Solution {
    public int recursion(int[][] grid, int i, int j) {
        // recursive approach might give TLE
        if(i == 0 && j == 0) return grid[i][j];
        if(i < 0 || j < 0) return Integer.MAX_VALUE;
        else {
            int up = Integer.MAX_VALUE;
            int left = Integer.MAX_VALUE;
            if(i > 0) up = grid[i][j] + recursion(grid, i-1, j);
            if(j > 0) left = grid[i][j] + recursion(grid, i, j-1);
            return Math.min(up, left);
        }
    }

    public int memoization(int [][] grid, int [][] dp, int i, int j) {
        if(i == 0 && j == 0) return grid[0][0];
        if(i < 0 || j < 0) return Integer.MAX_VALUE;        
        if(dp[i][j] != -1) return dp[i][j];
        else {
            int up = Integer.MAX_VALUE;
            int left = Integer.MAX_VALUE;
            if(i > 0) up = grid[i][j] + memoization(grid, dp, i-1, j);
            if(j > 0) left = grid[i][j] + memoization(grid, dp, i, j-1);
            dp[i][j] = Math.min(up, left);
        }
        return dp[i][j];
    }
    public int tabulation(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int[][] dp = new int[m][n];

        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(i == 0 && j == 0) dp[i][j] = grid[i][j];
                else {
                    int up = grid[i][j];
                    if(i > 0) up += dp[i-1][j];
                    else up = Integer.MAX_VALUE;
                    int left = grid[i][j];
                    if(j > 0) left += dp[i][j-1];
                    else left = Integer.MAX_VALUE;
                    dp[i][j] = Math.min(up, left);
                }
            }
        }
        return dp[m-1][n-1];

    }
    public int minPathSum(int[][] grid) {
        // int[][] dp = new int[grid.length][grid[0].length];
        // for(int i = 0; i < grid.length; i++) {
        //     Arrays.fill(dp[i], -1);
        // }
        // return memoization(grid, dp, grid.length-1, grid[0].length-1);
        return tabulation(grid);
    }
}