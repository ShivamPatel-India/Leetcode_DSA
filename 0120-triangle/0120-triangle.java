import java.util.*;
class Solution {
    public int recursive(List<List<Integer>> t, int n, int i, int j) {
        if(i == n-1) return t.get(n-1).get(j);
        int down = t.get(i).get(j) + recursive(t, n, i+1, j);
        int diag = t.get(i).get(j) + recursive(t, n, i+1, j+1);
        return Math.min(down, diag);
    }
    public int memoized(List<List<Integer>> t, int n, int i, int j, int[][] dp) {
        if(i == n-1) return t.get(n-1).get(j);
        if(dp[i][j] != -1) return dp[i][j];
        int down = t.get(i).get(j) + memoized(t, n, i+1, j, dp);
        int diag = t.get(i).get(j) + memoized(t, n, i+1, j+1, dp);
        return dp[i][j] = Math.min(down, diag);
    }
    public int tabulation(List<List<Integer>> t, int n) {
        int[][] dp = new int[n][n];
        for(int j = 0; j < n; j++) {
            dp[n-1][j] = t.get(n-1).get(j);
        }
        for(int i = n-2; i >=0; i--) {
            for(int j = i; j >= 0; j--) {
                int down = t.get(i).get(j) + dp[i+1][j];
                int diag = t.get(i).get(j) + dp[i+1][j+1];
                dp[i][j] = Math.min(down, diag);
            }
        }
        return dp[0][0];
    }
    public int spaceOptimized(List<List<Integer>> t, int n) {
        int[] front = new int[n];
        for(int j = 0; j < n; j++) front[j] = t.get(n-1).get(j);
        for(int i = n-2; i >= 0; i--) {
            int[] cur = new int[n];
            for(int j = i; j >= 0; j--) {
                int down = t.get(i).get(j) + front[j];
                int diag = t.get(i).get(j) + front[j+1];
                cur[j] = Math.min(down, diag);
            }
            front = cur;
        }
        return front[0];
    }
    public int minimumTotal(List<List<Integer>> triangle) {
        // number of rows is equal to number of columns.
        int n = triangle.size();
        int[][] dp = new int[n][n];
        for(int i = 0; i < n; i++) {
            Arrays.fill(dp[i],-1);
        }
        // return recursive(triangle, n, 0, 0);
        // return memoized(triangle, n, 0, 0, dp);
        // return tabulation(triangle, n);
        return spaceOptimized(triangle, n);
    }
}