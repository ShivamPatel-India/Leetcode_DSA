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
    public int f_tabulation(int[] p) {
        int n = p.length;
        int[][] dp = new int[n+2][2];

        for(int i = n-1; i >= 0; i--) {
            for(int buy = 0; buy <=1; buy++) {
                if(buy == 1) dp[i][buy] = Math.max(-p[i] + dp[i+1][0], 0 + dp[i+1][1]);
                else dp[i][buy] = Math.max(p[i] + dp[i+2][1], 0 + dp[i+1][0]);
            }
        }
        return dp[0][1];
    }
    public int maxProfit(int[] prices) {
        // int n = prices.length;
        // int[][] dp = new int[n][2];
        // for(int[] row: dp) Arrays.fill(row, -1);
        // return f(prices, n, dp, 0, 1);

        return f_tabulation(prices);
    }
}