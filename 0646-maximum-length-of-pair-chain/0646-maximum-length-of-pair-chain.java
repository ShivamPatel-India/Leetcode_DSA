class Solution {
    public int findLongestChain(int[][] pairs) {
        int n = pairs.length;
        int[] dp = new int[n];
        Arrays.sort(pairs, (a, b) -> a[0] - b[0]);
        Arrays.fill(dp, 1);
        int maxLIS = 1;

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < i; j++) {
                if(pairs[j][1] < pairs[i][0]) {
                    dp[i] = Math.max(dp[i], 1 + dp[j]);
                    maxLIS = Math.max(maxLIS, dp[i]);
                }
            }
        }
        return maxLIS;
    }
}