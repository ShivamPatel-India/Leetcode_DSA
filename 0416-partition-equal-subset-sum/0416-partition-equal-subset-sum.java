class Solution {
    public boolean subsetSumEqualK(int[] nums, int k, int n) {
        boolean[][] dp = new boolean[n][k+1];

        for(int i = 0; i < n; i++) dp[i][0] = true;

        if(k >= nums[0]) dp[0][nums[0]] = true;

        for(int ind = 1; ind < n; ind++) {
            for(int target = 1; target <= k; target++) {
                boolean notTake = dp[ind - 1][target];

                boolean take = false;
                if(target >= nums[ind]) take = dp[ind - 1][target - nums[ind]];

                dp[ind][target] = take || notTake;
            }
        }
        return dp[n-1][k];
    }
    public boolean canPartition(int[] nums) {
        int n = nums.length;

        int sum = 0;
        for(int num: nums) sum += num;
        if(sum %2 != 0) return false;
        else return subsetSumEqualK(nums, (int)sum/2, n);
    }
}