class Solution {
    private int m;
    private int n;
    private int[][] dp;
    private int solve(String s1, String s2, int i, int j) {
        if(i == m) return n-j;
        if(j == n) return m-i;
        if(dp[i][j] != -1) return dp[i][j];
        if(s1.charAt(i) == s2.charAt(j)) {
            return dp[i][j] = solve(s1, s2, i+1, j+1);
        } else {
            int insert = 1 + solve(s1, s2, i, j+1);
            int delete = 1 + solve(s1, s2, i+1, j);
            int replace = 1 + solve(s1, s2, i+1, j+1);
            return dp[i][j] = Math.min(insert, Math.min(delete, replace));
        }
    }
    public int minDistance(String word1, String word2) {
        m = word1.length();
        n = word2.length();
        dp = new int[m+1][n+1];
        for(int[] row: dp) Arrays.fill(row, -1);
        return solve(word1, word2, 0, 0);
    }
}