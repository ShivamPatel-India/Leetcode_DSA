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
    public int coinChange(int[] coins, int amount) {
        int[][] dp = new int[coins.length][amount+1];
        for(int[] row: dp) {
            Arrays.fill(row, -1);
        }
        int ans = memoized(coins, amount, dp, coins.length-1);
        if(ans >= (int)Math.pow(10,9)) return -1;
        return ans;
    }
}