class Solution {
    private int[][] dp;
    private int solve(String s, int n, int i, int j) {
        if(i > j) return 0;
        if(dp[i][j] != -1) return dp[i][j];
        if(s.charAt(i) == s.charAt(j)) {
            return dp[i][j] = solve(s, n, i+1, j-1);
        } else {
            return dp[i][j] = 1 + Math.min(solve(s, n, i+1, j) , solve(s, n, i, j-1));
        }
    }
    public int minInsertions(String s) {
        int n = s.length();
        dp = new int[n+1][n+1];
        for(int[] row: dp) Arrays.fill(row, -1);
        return solve(s, n, 0, n-1);
    }
}