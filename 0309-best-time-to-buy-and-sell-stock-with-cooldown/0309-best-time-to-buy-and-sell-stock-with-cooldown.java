class Solution {
    public int f(int[] p, int n, int[][] dp, int i, int buy) {
        if(i >= n) return 0; // >= n bcz we are doing i+2 for the sell
        if(dp[i][buy] != -1) return dp[i][buy];

        if(buy == 1) {
            return dp[i][buy] = Math.max(-p[i] + f(p, n, dp, i+1, 0),
                                            0 + f(p, n, dp, i+1, 1));
        } else {
            return dp[i][buy] = Math.max(p[i] + f(p, n, dp, i+2, 1),
                                            0 + f(p, n, dp, i+1, 0));
        }
    }
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[][] dp = new int[n][2];
        for(int[] row: dp) Arrays.fill(row, -1);
        return f(prices, n, dp, 0, 1);
    }
}