class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int maxLIS = 1;
        int[] dp = new int[n];
        Arrays.fill(dp, 1); 

        for(int i = 1; i < n; i++) {
            for(int j = 0; j < i; j++) {
                if(nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], 1 + dp[j]);
                    maxLIS = Math.max(dp[i], maxLIS);
                }
            }
        }
        return maxLIS;
    }
}