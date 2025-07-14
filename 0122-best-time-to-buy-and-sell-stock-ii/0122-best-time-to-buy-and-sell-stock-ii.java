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
    public int f_tabulation(int[] p) {
        int n = p.length;

        int[][] dp = new int[n+1][2];

        // base case i == n, profit is zero regardless of buy is 1 or 0
        dp[n][1] = 0;
        dp[n][0] = 0;
        
        for(int i = n-1; i >= 0; i--) {
            for(int buy = 1; buy >= 0; buy--) {
                if(buy == 0) { // we can sell the stock
                    dp[i][buy] = Math.max(p[i] + dp[i+1][1], 0 + dp[i+1][0]);
                } else if(buy == 1) { // we can buy
                    dp[i][buy] = Math.max(0 + dp[i+1][1] , -p[i] + dp[i+1][0]);
                }
            }
        }
        return dp[0][1];
    }
    public int f_spaceOptimize(int[] p) {
        int n = p.length;

        int[] ahead = new int[2];

        // no stock to buy or sell so profit 0;
        ahead[0] = ahead[1] = 0;

        for(int i = n-1; i >= 0; i--) {
            int[] cur = new int[2];
            for(int buy = 1; buy >=0; buy--) {
                if(buy == 0) {
                    // we can not buy means we can sell
                    cur[buy] = Math.max(p[i] + ahead[1] , 0 + ahead[0]);
                } else if (buy == 1) {
                    // we can buy
                    cur[buy] = Math.max(-p[i] + ahead[0], 0 + ahead[1]);
                }
            }
            ahead = cur;
        }
        return ahead[1];
    }
    public int ultraSpaceOptimize(int[] p) {
        int n = p.length;

        int aheadBuy, aheadNotBuy, curBuy, curNotBuy;

        // base cases:
        aheadBuy = aheadNotBuy = 0;
        int profit = 0;
        for(int i = n-1; i >=0; i--) {
            curBuy = Math.max(-p[i] + aheadNotBuy, 0 + aheadBuy);

            curNotBuy = Math.max(p[i] + aheadBuy, 0 + aheadNotBuy);

            aheadBuy = curBuy;
            aheadNotBuy = curNotBuy;
        }
        return aheadBuy;
    }
    public int maxProfit(int[] prices) {
        // int n = prices.length;
        // int[][] dp = new int[n][2];
        // for(int[] row: dp) Arrays.fill(row, -1);
        // return f(prices, 0, 1, dp, n);

        // return f_tabulation(prices);

        // return f_spaceOptimize(prices);

        return ultraSpaceOptimize(prices);
    }
}