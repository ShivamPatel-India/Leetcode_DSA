class Solution {
    private static int m;
    private static int n;
    private static int[][] dp;
    private static int solve(String s1, String s2, int i, int j) {
        if(i == m) {
            return n-j;
        } else if(j == n) {
            return m-i;
        }
        
        if(dp[i][j] != -1) return dp[i][j];
        
        if(s1.charAt(i) == s2.charAt(j)) {
            return dp[i][j] = 1 + solve(s1, s2, i+1, j+1);
        } else {
            return dp[i][j] = 1 + Math.min(solve(s1, s2, i+1, j), 
                                solve(s1, s2, i, j+1));
        }
    }
    public static int minSuperSeq(String s1, String s2) {
        m = s1.length();
        n = s2.length();
        dp = new int[m+1][n+1];
        for(int[] row: dp) Arrays.fill(row, -1);
        return solve(s1, s2, 0, 0);
    }
}