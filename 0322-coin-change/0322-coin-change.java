import java.util.*;

class Solution {
    public int memoized(int[] coins, int amount, int[][] dp, int index) {
        if(index == 0) {
            if(amount % coins[index] == 0) return (int)amount/coins[index];
            else return (int)Math.pow(10,9);
        }
        if(dp[index][amount] != -1) return dp[index][amount];

        int notTake = 0 + memoized(coins, amount, dp, index-1);

        int take = (int)Math.pow(10,9);
        if(coins[index] <= amount) take = 1 + memoized(coins, amount-coins[index], dp, index);
        return dp[index][amount] = Math.min(take, notTake);
    }

    public int tabulation(int[] coins, int k) {
        int n = coins.length;
        int[][] dp = new int[n][k+1];

        for(int t = 1; t <= k; t++) {
            if(t % coins[0] == 0) dp[0][t] = (int)t/coins[0];
            else dp[0][t] = (int) Math.pow(10, 9);
        }

        for(int i = 1; i < n; i++) {
            for(int t = 1; t <= k; t++) {
                int notTake = 0 + dp[i-1][t];

                int take = (int)Math.pow(10, 9);
                if(coins[i] <= t) take = 1 + dp[i][t-coins[i]];
                dp[i][t] = Math.min(take, notTake);
            }
        }
        return dp[n-1][k];
    }
    public int spaceOptimized(int[] coins, int k) {
        int n = coins.length;
        int[] prev = new int[k+1];
        
        for(int t = 1; t <= k; t++) {
            if(t % coins[0] == 0) prev[t] = (int)t/coins[0];
            else prev[t] = (int)Math.pow(10,9);
        }

        for(int i = 0; i < n; i++) {
            int[] cur = new int[k+1];
            for(int t = 1; t <= k; t++) {
                int notTake = 0 + prev[t];

                int take = (int)Math.pow(10, 9);
                if(coins[i] <= t) take = 1 + cur[t-coins[i]];

                cur[t] = Math.min(take, notTake);
            }
            prev = cur;
        }
        return prev[k];
    }
    public int coinChange(int[] coins, int amount) {
        // int[][] dp = new int[coins.length][amount+1];
        // for(int[] row: dp) {
        //     Arrays.fill(row, -1);
        // }
        // int ans = memoized(coins, amount, dp, coins.length-1);
        // int ans = tabulation(coins, amount);
        int ans = spaceOptimized(coins, amount);
        if(ans >= (int)Math.pow(10,9)) return -1;
        return ans;
    }
}