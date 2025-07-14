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

    public int f_tabulation(int[] p) {
        int n = p.length;
        int[][][] dp = new int[n+1][2][3];

        // base cases:
        // cap = 0
        for(int i = 0; i <= n; i++) {
            for(int buy = 1; buy <= 1; buy++) {
                dp[i][buy][0] = 0;
            }
        }
        // index = n
        for(int buy = 0; buy <= 1; buy++) {
            for(int cap = 0; cap <=2 ; cap++) {
                dp[n][buy][cap] = 0;
            }
        }

        for(int i = n-1; i >= 0; i--) {
            for(int buy = 0; buy <= 1; buy++) {
                for(int cap = 1; cap <= 2; cap++) {
                    if(buy == 1) {
                        dp[i][buy][cap] = Math.max(-p[i] + dp[i+1][0][cap], 0 + dp[i+1][1][cap]);
                    } else if(buy == 0) {
                        dp[i][buy][cap] = Math.max(p[i] + dp[i+1][1][cap-1], 0 + dp[i+1][0][cap]);
                    }
                }
            }
        }
        return dp[0][1][2];
    }
    public int maxProfit(int[] prices) {
        // int cap = 2;
        // int n = prices.length;
        // int[][][] dp = new int[n][2][3];
        
        // for(int i = 0; i < n; i++) {
        //     for(int j = 0; j < 2; j++) {
        //         Arrays.fill(dp[i][j], -1);
        //     }
        // }
        // return f(prices, 0, 1, cap, n, dp);

        return f_tabulation(prices);
    }
}