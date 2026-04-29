class Solution {
    public String shortestCommonSupersequence(String s1, String s2) {
        int m = s1.length();
        int n = s2.length();
        int[][] dp = new int[m+1][n+1];

        for(int i = 0 ; i <= m; i++) {
            for(int j = 0; j <= n; j++) {
                if(i == 0 || j == 0) {
                    dp[i][j] = i+j;
                } else if(s1.charAt(i-1) == s2.charAt(j-1)) {
                    dp[i][j] = 1 + dp[i-1][j-1];
                } else {
                    dp[i][j] = 1 + Math.min(dp[i-1][j], dp[i][j-1]);
                }
            }
        }

        int i = m;
        int j = n;
        StringBuilder sb = new StringBuilder();
        while(i > 0 && j > 0) {
            if(s1.charAt(i-1) == s2.charAt(j-1)) {
                sb.append(s1.charAt(i-1));
                i--;
                j--;
            } else if(dp[i-1][j] < dp[i][j-1]) {
                // go up
                sb.append(s1.charAt(i-1));
                i--;
            } else if(dp[i][j-1] <= dp[i-1][j]) {
                // go left
                sb.append(s2.charAt(j-1));
                j--;
            }
        }
        while(i > 0) {
            sb.append(s1.charAt(i-1));
            i--;
        }
        while(j > 0) {
            sb.append(s2.charAt(j-1));
            j--;
        }
        return sb.reverse().toString();
    }
}