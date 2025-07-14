class Solution {
    public int f(int[]p, int i, int buy, int cap, int n, int[][][] dp) {
        if(cap == 0) return 0;
        if(i == n) return 0;

        if(dp[i][buy][cap] != -1) return dp[i][buy][cap];

        if(buy == 1) {
            return dp[i][buy][cap] = Math.max(-p[i] + f(p, i+1, 0, cap, n, dp), 0 + f(p, i+1, 1, cap, n, dp));
        } else {
            return dp[i][buy][cap] = Math.max(p[i] + f(p, i+1, 1, cap-1, n, dp), 0 + f(p, i+1, 0, cap, n, dp));
        }
    }
    public int maxProfit(int[] prices) {
        int cap = 2;
        int n = prices.length;
        int[][][] dp = new int[n][2][3];
        
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < 2; j++) {
                Arrays.fill(dp[i][j], -1);
            }
        }
        return f(prices, 0, 1, cap, n, dp);
    }
}