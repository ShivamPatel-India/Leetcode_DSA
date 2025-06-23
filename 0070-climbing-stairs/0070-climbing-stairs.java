import java.util.*;

class Solution {
    public int recursive(int n) {
        // top-down approach
        if(n == 0 || n == 1) return 1;
        return recursive(n-1) + recursive(n-2);
    }
    public int memoized(int n, int[] dp) {
        // top-down approach with memoization
        if(n == 0 || n == 1) return 1;
        if(dp[n] != -1) return dp[n];

        return dp[n] = memoized(n-1, dp) + memoized(n-2, dp);
    }
    public int tabulation(int n, int[] dp) {
        // bottom-up approach
        dp[0] = 1;
        dp[1] = dp[0];
        for(int i = 2; i <= n; i++) {
            dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[n];
    }
    public int spaceOptimized(int n) {
        int prev = 1; // 1 way to get to the 0th stair
        int prev2 = 1; // 1 way to get to the 1st stair

        for(int i = 2; i <= n ; i++) {
            int curi = prev + prev2;
            prev2 = prev;
            prev = curi;
        }
        return prev;
    }
    public int climbStairs(int n) {
        // return recursive(n); // recursive approach will give TLE
        int[] dp = new int[n+1];
        Arrays.fill(dp, -1);
        // return memoized(n, dp);
        // return tabulation(n, dp);
        return spaceOptimized(n);
    }
}