class Solution {
    public int maxProfit(int[] prices) {
        int mini = prices[0];
        int maxProfit = 0;

        for(int i = 1; i < prices.length; i++) {
            int profit = prices[i] - mini;
            maxProfit = Math.max(profit, maxProfit);
            mini = Math.min(prices[i], mini);
        }
        return maxProfit;
    }
}