import java.util.*;
class Solution {
    private static final int INF = 1000000000;

    public int memoized(int[][] a, int[][] dp, int i, int j) {
        if(j < 0 || j >= a[0].length) return INF;
        if(i == 0) return a[0][j];
        if(dp[i][j] != -1) return dp[i][j];

        int straight = a[i][j] + memoized(a, dp, i-1, j);
        int left_diag = a[i][j] + memoized(a, dp, i-1, j-1);
        int right_diag = a[i][j] + memoized(a, dp, i-1, j+1);

        return dp[i][j] = Math.min(straight, Math.min(left_diag, right_diag));
    }

    public int tabulation(int[][] a, int n) {
        int[][] dp = new int[n][n];
        for(int j = 0; j < n; j++) {
            dp[0][j] = a[0][j];
        }
        for(int i = 1; i < n; i++) {
            for(int j = 0; j < n; j++) {
                int straight = a[i][j] + dp[i-1][j];
                
                int left_diag = a[i][j];
                if(j-1>=0) left_diag += dp[i-1][j-1];
                else left_diag = INF;

                int right_diag = a[i][j]; 
                if(j+1<n) right_diag += dp[i-1][j+1];
                else right_diag = INF;

                dp[i][j] = Math.min(straight, Math.min(left_diag, right_diag));
            }
        }
        int mini = INF;
        for(int j = 0; j < n; j++) {
            mini = Math.min(mini, dp[n-1][j]);
        }
        return mini;
    }
    public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;
        // int[][] dp = new int[n][n];
        // for(int i = 0; i < n; i++) {
        //     Arrays.fill(dp[i], -1);
        // }
        // int mini = Integer.MAX_VALUE;
        // for(int j = 0; j < n; j++) {
        //     mini = Math.min(mini, memoized(matrix, dp, n-1, j));
        // }
        // return mini;
        return tabulation(matrix, n);
    }
}