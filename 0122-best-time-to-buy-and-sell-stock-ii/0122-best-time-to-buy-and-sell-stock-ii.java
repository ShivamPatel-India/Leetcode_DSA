class Solution {
    public int f(int[] prices, int i, int buy, int[][] dp, int n) {
        // base case:
        // if buy == 1, that means buying allowed but there is no stock left to buy so profit 0
        // if buy == 0, that means bought a stock but didn't sell it (hold the stock) so profit is 0
        if(i == n) return 0;
        if(dp[i][buy] != -1) return dp[i][buy];

        if(buy == 1) {
            return dp[i][buy] = Math.max(-prices[i] + f(prices, i+1, 0, dp, n), 0 + f(prices, i+1, 1, dp, n));
        } else {
            return dp[i][buy] = Math.max(prices[i] + f(prices, i+1, 1, dp, n), 0 + f(prices, i+1, 0, dp, n));
        }
    }
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[][] dp = new int[n][2];
        for(int[] row: dp) Arrays.fill(row, -1);
        return f(prices, 0, 1, dp, n);
    }
}