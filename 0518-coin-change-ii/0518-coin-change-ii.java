
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
    public int change(int amount, int[] coins) {
        int[][] dp = new int[coins.length][amount+1];
        for(int[] row: dp) Arrays.fill(row, -1);
        return memoized(amount, coins, dp, coins.length-1);
    }
}