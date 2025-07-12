class Solution {
    public int memoize(String s1, int i, String s2, int j, int[][] dp) {
        if(i < 0) return j+1; // delete operations
        if(j < 0) return i+1; // insert operations
        if(dp[i][j] != -1) return dp[i][j];

        if(s1.charAt(i) == s2.charAt(j)) {
            return dp[i][j] = memoize(s1, i-1, s2, j-1, dp);
        } else {
            return dp[i][j] = 1 + Math.min(memoize(s1, i, s2, j-1, dp), // insert
                                            Math.min(memoize(s1, i-1, s2, j, dp), // delete
                                                        memoize(s1, i-1, s2, j-1, dp))); // replace
        }
        
    }
    public int tabulation(String s, String t) {
        int n = s.length();
        int m = t.length();

        int[][] dp = new int[n+1][m+1];

        for(int i = 0; i <= n; i++) dp[i][0] = i;
        for(int j = 0; j <= m; j++) dp[0][j] = j;

        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= m; j++) {
                if(s.charAt(i-1) == t.charAt(j-1)) {
                    dp[i][j] = dp[i-1][j-1];
                } else {
                    dp[i][j] = 1 + Math.min(dp[i-1][j-1], Math.min(dp[i-1][j], dp[i][j-1]));
                }
            }
        }
        return dp[n][m];
    }
    public int minDistance(String word1, String word2) {
        // int n = word1.length();
        // int m = word2.length();
        // int[][] dp = new int[n][m];
        // for(int[] row: dp)
        //     Arrays.fill(row, -1);
        // return memoize(word1, n-1, word2, m-1, dp);

        return tabulation(word1, word2);
    }
}