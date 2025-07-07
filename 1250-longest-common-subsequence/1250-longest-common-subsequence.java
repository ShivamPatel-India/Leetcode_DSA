import java.util.*;
class Solution {
    public int memoized(String s1, String s2, int i, int j, int[][] dp) {
        if(i < 0 || j < 0) return 0;
        if(dp[i][j] != -1) return dp[i][j];
        if(s1.charAt(i) == s2.charAt(j)) return dp[i][j] = 1 + memoized(s1, s2, i-1, j-1, dp);
        return dp[i][j] = Math.max(memoized(s1, s2, i-1, j, dp), memoized(s1, s2, i, j-1, dp));
    }
    public int tabulation(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();

        // create an 2D array to store result of subproblems
        int[][] dp  = new int[n+1][m+1];

        for(int[] row: dp) Arrays.fill(row, -1);

        // initialize first row and column with 0 as LCS of empty strings will be 0
        for(int i = 0; i <= n; i++) dp[i][0] = 0;
        for(int i = 0; i <= m; i++) dp[0][i] = 0;

        // fill the dp array using dynamic programming
        for(int ind1 = 1; ind1 <= n; ind1++) {
            for(int ind2 = 1; ind2 <= m; ind2++) {
                // If characters at the current indices are same, increment the LCS length
                if(s1.charAt(ind1-1) == s2.charAt(ind2-1)) {
                    dp[ind1][ind2] = 1 + dp[ind1-1][ind2-1];
                }
                // if the character are different, choose the maximum LCS length by either excluding
                // a character in s1 or excluding a character in s2
                else dp[ind1][ind2] = Math.max(dp[ind1-1][ind2], dp[ind1][ind2-1]);
            }
        }
        return dp[n][m];
    }
    public int longestCommonSubsequence(String text1, String text2) {
        // int n1 = text1.length();
        // int n2 = text2.length();
        // int[][] dp = new int[n1][n2];
        // for(int[] row: dp) Arrays.fill(row, -1);
        // return memoized(text1, text2, n1-1, n2-1, dp);
        return tabulation(text1, text2);
    }
}