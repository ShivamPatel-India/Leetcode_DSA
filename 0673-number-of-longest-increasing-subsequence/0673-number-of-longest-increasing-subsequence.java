class Solution {
    public int findNumberOfLIS(int[] nums) {
        int n = nums.length;

        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        int[] ct = new int[n];
        Arrays.fill(ct, 1);

        int maxi = 1;

        for(int i = 0; i < n; i++) {
            for(int prev = 0; prev < i; prev++) {
                if(nums[prev] < nums[i] && (1 + dp[prev]) > dp[i]) {
                    dp[i] = 1 + dp[prev];
                    ct[i] = ct[prev];
                } else if (nums[prev] < nums[i] && (1 + dp[prev]) == dp[i]) {
                    ct[i] = ct[i] + ct[prev];
                }
            }
            maxi = Math.max(maxi, dp[i]);
        }

        int nos = 0;
        for(int i = 0; i < n; i++) {
            if (maxi == dp[i]) {
                nos+=ct[i];
            }
        }
        return nos;
    }
}