class Solution {
    public int f(int[] p, int n, int fee, int[][] dp, int i, int buy) {
        if(i == n) return 0;
        if(dp[i][buy] != -1) return dp[i][buy];

        if(buy == 1) {
            return dp[i][buy] = Math.max( -p[i] + f(p, n, fee, dp, i+1, 0),
                                            0 + f(p, n, fee, dp, i+1, 1));
        } else {
            return dp[i][buy] = Math.max( p[i] - fee + f(p, n, fee, dp, i+1, 1),
                                            0 + f(p, n, fee, dp, i+1, 0));
        }
    }
    public int maxProfit(int[] prices, int fee) {
        int n = prices.length;
        int[][] dp = new int[n][2];
        for(int[] row: dp) Arrays.fill(row, -1);
        return f(prices, n, fee, dp, 0, 1);
    }
}