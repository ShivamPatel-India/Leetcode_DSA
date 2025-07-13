// 1-based indexing
class Solution {
    public int isAllStars(String p, int i) {
        for(int ind = i; ind > 0; ind--) {
            if(p.charAt(ind-1) != '*') return 0;
        }
        return 1;
    }
    public int f(String p, String s, int i, int j, int[][] dp) {
        if(i == 0 && j == 0) return 1;
        if(i == 0 && j > 0) return 0;
        if(i > 0 && j == 0) return isAllStars(p, i);
        if(dp[i][j] != -1) return dp[i][j];

        if(p.charAt(i-1) == s.charAt(j-1) || p.charAt(i-1) == '?') 
            return dp[i][j] = f(p, s, i-1, j-1, dp);
        else if (p.charAt(i-1) == '*') 
            return dp[i][j] = (f(p, s, i-1, j, dp) == 1 || f(p, s, i, j-1, dp) == 1) ? 1 : 0;
        else 
            return 0;
    }
    public boolean f_tabulation(String p, String s) {
        int n = p.length();
        int m = s.length();

        int[][] dp = new int[n+1][m+1];
        dp[0][0] = 1;

        for(int j = 1; j <= m; j++) dp[0][j] = 0;
        for(int i = 1; i <= n; i++) dp[i][0] = isAllStars(p, i);

        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= m; j++) {
                if(p.charAt(i-1) == s.charAt(j-1) || p.charAt(i-1) == '?') dp[i][j] = dp[i-1][j-1];
                else if(p.charAt(i-1) == '*') dp[i][j] = (dp[i-1][j] == 1 || dp[i][j-1] == 1) ? 1 : 0;
                else dp[i][j] = 0;
            }
        }
        return dp[n][m] == 1 ? true : false;
    }
    public boolean isMatch(String s, String p) {
        // p is pattern and s is string
        
        // int n = p.length();
        // int m = s.length();
        // int[][] dp = new int[n+1][m+1];
        // for(int[] row: dp) Arrays.fill(row, -1);
        // return f(p, s, n, m, dp) == 1 ? true : false;

        return f_tabulation(p, s);
    }
}