class Solution {
    public int f(int[] p, int k, int n, int[][][] dp, int i, int buy) {
        if(k==0) return 0;
        if(i == n) return 0;
        if(dp[i][buy][k] != -1) return dp[i][buy][k];

        if(buy == 1) {
            return dp[i][buy][k] = Math.max(-p[i] + f(p, k, n, dp, i+1, 0), f(p, k, n, dp, i+1, 1));
        } else {
            return dp[i][buy][k] = Math.max(p[i] + f(p, k-1, n, dp, i+1, 1), f(p, k, n, dp, i+1, 0));
        }
    }
    public int maxProfit(int[] prices) {
        int k = 2;
        int n = prices.length;

        int[][][] dp = new int[n][2][k+1];
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < 2; j++) {
                Arrays.fill(dp[i][j], -1);
            }
        }
        return f(prices, k, n, dp, 0 ,1);
    }
}