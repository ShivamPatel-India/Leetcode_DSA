class Solution {
    public String longestPalindrome(String s) {
        int n = s.length();
        boolean[][] dp = new boolean[n+1][n+1];
        int maxlen = Integer.MIN_VALUE;
        int sp = 0;

        for(int i = 0; i < n; i++) {
            dp[i][i] = true;
            maxlen = 1;
        }

        for(int L = 2; L <= n; L++) {
            for(int i = 0; i+L-1 < n; i++) {
                int j = i+L-1;

                if(s.charAt(i) == s.charAt(j) && L == 2) {
                    maxlen = 2;
                    sp = i;
                    dp[i][j] = true;
                } else if((s.charAt(i) == s.charAt(j)) && (dp[i+1][j-1] == true)) {
                    dp[i][j] = true;
                    if(j-i+1 > maxlen) {
                        maxlen = j-i+1;
                        sp = i;
                    }
                } else {
                    dp[i][j] = false;
                }
            }
        }
        return s.substring(sp, sp+maxlen);
    }
}