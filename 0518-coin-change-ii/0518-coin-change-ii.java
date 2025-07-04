
class Solution {
    public int memoized(int amount, int[] coins, int[][] dp, int i) {
        if(i == 0) {
            if(amount % coins[0] == 0) return 1;
            else return 0;
        }

        if(dp[i][amount] != -1) return dp[i][amount];

        int notTake = memoized(amount, coins, dp, i-1);
        int take = 0;
        if(coins[i] <= amount) take = memoized(amount-coins[i], coins, dp, i);
        return dp[i][amount] = take + notTake;
    }
    public int tabulation(int[] coins, int amount) {
        int n = coins.length;
        int[][] dp = new int[n][amount+1];

        for(int t = 0; t <= amount; t++) {
            dp[0][t] = (t % coins[0] == 0) ? 1 : 0;
        }

        for(int i = 1; i < n; i++) {
            for(int t = 0; t <= amount; t++) {
                int notTake = dp[i-1][t];
                int take = 0;
                if(coins[i] <= t) take = dp[i][t-coins[i]];
                dp[i][t] = take + notTake;
            }
        }
        return dp[n-1][amount];
    }
    public int spaceOptimized(int[] coins, int amount) {
        int n = coins.length;
        int[] prev = new int[amount+1];
        for(int t = 0; t <= amount; t++) {
            prev[t] = (t % coins[0] == 0) ? 1 : 0;
        }

        for(int i = 1; i < n; i++) {
            int[] cur = new int[amount+1];
            for(int t = 0; t <= amount; t++) {
                int notTake = prev[t];
                int take = 0;
                if(coins[i] <= t) take = cur[t-coins[i]];
                cur[t] = take + notTake;
            }
            prev = cur;
        }
        return prev[amount];
    }
    public int change(int amount, int[] coins) {
        // int[][] dp = new int[coins.length][amount+1];
        // for(int[] row: dp) Arrays.fill(row, -1);
        // return memoized(amount, coins, dp, coins.length-1);
        // return tabulation(coins, amount);
        return spaceOptimized(coins, amount);
    }
}