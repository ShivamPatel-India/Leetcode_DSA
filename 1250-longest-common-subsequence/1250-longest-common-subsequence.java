import java.util.*;
class Solution {
    public int memoized(String s1, String s2, int i, int j, int[][] dp) {
        if(i < 0 || j < 0) return 0;
        if(dp[i][j] != -1) return dp[i][j];
        if(s1.charAt(i) == s2.charAt(j)) return dp[i][j] = 1 + memoized(s1, s2, i-1, j-1, dp);
        return dp[i][j] = Math.max(memoized(s1, s2, i-1, j, dp), memoized(s1, s2, i, j-1, dp));
    }
    public int longestCommonSubsequence(String text1, String text2) {
        int n1 = text1.length();
        int n2 = text2.length();
        int[][] dp = new int[n1][n2];
        for(int[] row: dp) Arrays.fill(row, -1);
        return memoized(text1, text2, n1-1, n2-1, dp);
    }
}