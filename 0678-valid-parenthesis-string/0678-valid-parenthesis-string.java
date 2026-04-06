class Solution {
    // Brute force - recursion - trying all combination - gives TLE
    private boolean f(String s, int ind, int count, int n) {
        if(count < 0) return false;
        if(ind == n) {
            return count == 0;
        }
        if(s.charAt(ind) == '(') return f(s, ind+1 , count+1, n);
        else if(s.charAt(ind) == ')') return f(s, ind+1, count-1, n);
        return f(s, ind+1, count+1, n) || f(s, ind+1, count-1, n) || f(s, ind+1, count, n); 
    }
    // memoization
    private int f_memo(String s, int ind, int count, int[][] memo, int n) {
        if(count < 0) return 0; // false
        if(ind == n) {
            return count == 0 ? 1 : 0; // true or false
        }

        int result;
        if(memo[ind][count] != -1) return memo[ind][count];
        if(s.charAt(ind) == '(') result = f_memo(s, ind+1, count+1, memo, n);
        else if(s.charAt(ind) == ')') result = f_memo(s, ind+1, count-1, memo, n);
        else result = (f_memo(s, ind+1, count+1, memo, n) == 1
                    || f_memo(s, ind+1, count-1, memo, n) == 1
                    || f_memo(s, ind+1, count, memo, n) == 1) ? 1 : 0;
        return memo[ind][count] = result;
    }
    private boolean f_tabulation(String s) {
        int n = s.length();

        // dp[ind][count] = can s[ind..n-1] be valid given 'count' open brackets so far
        boolean[][] dp = new boolean[n+1][n+1];

        // base case: reached end of the string, valid only if count = 0;
        dp[n][0] = true;

        for(int i = n-1; i >= 0; i--) {
            for(int count = 0; count <= n; count++) {
                boolean result;

                if(s.charAt(i) == '(') {
                    result = (count+1 <= n) && dp[i+1][count+1];
                } else if (s.charAt(i) == ')') {
                    result = (count-1 >= 0) && dp[i+1][count-1];
                } else {
                    boolean treatAsOpen = (count+1 <= n) && dp[i+1][count+1];
                    boolean treatAsClose = (count-1 >= 0) && dp[i+1][count-1];
                    boolean treatAsEmpty = dp[i+1][count];
                    result = treatAsOpen || treatAsClose || treatAsEmpty;
                }
                dp[i][count] = result;
            }
        }
        return dp[0][0];
    }
    public boolean checkValidString(String s) {
        // return f(s, 0, 0, s.length());

        // int n = s.length();
        // int[][] memo = new int[n][n+1]; // ind: 0..n-1, count: 0..n
        // for(int[] row: memo) Arrays.fill(row, -1);
        // return f_memo(s, 0, 0, memo, n) == 1; 

        return f_tabulation(s);
    }
}