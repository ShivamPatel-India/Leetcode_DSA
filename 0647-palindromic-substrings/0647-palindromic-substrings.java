class Solution {
    private int n;
    private int[][] dp;
    private int check(String s, int i, int j) {
        if(i > j) return 1;
        if(dp[i][j] != -1) return dp[i][j];
        if(s.charAt(i) == s.charAt(j)) {
            return dp[i][j] = check(s, i+1, j-1);
        } 
        return dp[i][j] = 0;
    }
    public int countSubstrings(String s) {
        n = s.length();
        dp = new int[n+1][n+1];
        for(int[] row: dp) Arrays.fill(row, -1);
        int count = 0;
        for(int i = 0; i < n; i++) {
            for(int j = i; j < n; j++) {
                if(check(s, i, j) == 1) {
                    count++;
                }
            }
        }
        return count;
    }
}