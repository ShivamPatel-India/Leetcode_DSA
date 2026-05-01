class Solution {
    private int[][] dp;
    private int n;
    private int check(int i, int j, String s) {
        if(i >= j) return dp[i][j] = 1;
        if(dp[i][j] != -1) return dp[i][j];
        if(s.charAt(i) == s.charAt(j)) {
            return dp[i][j] = check(i+1, j-1, s);
        }
        return dp[i][j] = 0;
    }
    public String longestPalindrome(String s) {
        n = s.length();
        dp = new int[n+1][n+1];
        for(int[] row: dp) Arrays.fill(row, -1);
        int maxlen = Integer.MIN_VALUE;
        int sp = -1; // starting point

        for(int i = 0; i < n; i++) {
            for(int j = i; j < n; j++) {
                if(check(i, j, s) == 1) {
                    if(j-i+1 > maxlen) {
                        maxlen = j-i+1;
                        sp = i;
                    }
                }
            }
        }
        return s.substring(sp, sp+maxlen);
    }
}