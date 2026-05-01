class Solution {
    public int countSubstrings(String s) {
        int n = s.length();
        int count = 0;
        boolean[][] dp = new boolean[n+1][n+1];

        for(int L = 1; L <= n; L++) {
            for(int i = 0; i+L-1 < n; i++) {
                int j = i + L - 1;

                if(i==j) dp[i][j] = true;
                else if(i+1 == j) {
                    dp[i][j] = (s.charAt(i) == s.charAt(j));
                } else {
                    dp[i][j] = (s.charAt(i) == s.charAt(j) && dp[i+1][j-1]);
                }
                if(dp[i][j] == true) count++;
            }
        }
        return count;
    }
}