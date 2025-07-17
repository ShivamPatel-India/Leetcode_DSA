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
    public int tabulation(int[] p, int fee) {
        int n = p.length;
        int[][] dp = new int[n+1][2];

        for(int i = n-1; i >= 0; i--) {
            for(int buy = 0; buy <= 1; buy++) {
                if(buy == 0) { // we can sell the stock
                    dp[i][buy] = Math.max(p[i] - fee + dp[i+1][1], 0 + dp[i+1][0]);
                } else if(buy == 1) { // we can buy
                    dp[i][buy] = Math.max(0 + dp[i+1][1] , -p[i] + dp[i+1][0]);
                } 
            }
        }
        return dp[0][1];
    }
    public int spaceOptimizeV1(int[] p, int fee) {
        int n = p.length;
        int[] ahead = new int[2];

        for(int i = n-1; i >= 0; i--) {
            int[] cur = new int[2];
            for(int buy = 0; buy <= 1; buy++) {
                if(buy == 0) { // we can sell the stock
                    cur[buy] = Math.max(p[i] - fee + ahead[1], 0 + ahead[0]);
                } else if(buy == 1) { // we can buy
                    cur[buy] = Math.max(0 + ahead[1] , -p[i] + ahead[0]);
                } 
            }
            ahead = cur;
        }
        return ahead[1];
    }
    public int maxProfit(int[] prices, int fee) {
        // int n = prices.length;
        // int[][] dp = new int[n][2];
        // for(int[] row: dp) Arrays.fill(row, -1);
        // return f(prices, n, fee, dp, 0, 1);

        // return tabulation(prices, fee);

        return spaceOptimizeV1(prices, fee);
    }
}