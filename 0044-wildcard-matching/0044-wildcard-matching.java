class Solution {
    public int isAllStars(String p, int i) {
        for(int ind = i; ind >= 0; ind--) {
            if(p.charAt(ind) != '*') return 0;
        }
        return 1;
    }
    public int f(String p, String s, int i, int j, int[][] dp) {
        if(i < 0 && j < 0) return 1;
        if(i < 0 && j >= 0) return 0;
        if(i >= 0 && j < 0) return isAllStars(p, i);
        if(dp[i][j] != -1) return dp[i][j];

        if(p.charAt(i) == s.charAt(j) || p.charAt(i) == '?') 
            return dp[i][j] = f(p, s, i-1, j-1, dp);
        else if (p.charAt(i) == '*') 
            return dp[i][j] = (f(p, s, i-1, j, dp) == 1 || f(p, s, i, j-1, dp) == 1) ? 1 : 0;
        else 
            return 0;
    }

    public boolean isMatch(String s, String p) {
        // p is pattern and s is string
        int n = p.length();
        int m = s.length();
        int[][] dp = new int[n][m];
        for(int[] row: dp) Arrays.fill(row, -1);
        return f(p, s, n-1, m-1, dp) == 1 ? true : false;
    }
}