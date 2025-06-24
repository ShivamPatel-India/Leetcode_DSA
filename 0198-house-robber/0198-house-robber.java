class Solution {
    // recursive soltion
    private static int rob(int[] nums, int index) {
        if(index == 0) return nums[index];
        if(index < 0) return 0;

        int pick = nums[index] + rob(nums,index-2);
        int notPick = 0 + rob(nums, index-1);

        return Math.max(pick, notPick);
    }

    private static int robMemoized(int[] nums, int index, int[] dp) {
        // Memoized approach
        if(index == 0) return nums[index];
        if(index < 0) return 0;
        if(dp[index] != -1) {
            return dp[index];
        }

        int pick = nums[index] + robMemoized(nums, index-2, dp);
        int notPick = 0 + robMemoized(nums, index-1, dp);

        return dp[index] = Math.max(pick, notPick);
    }
    private static int robTabulation(int[] nums, int index, int[] dp) {
        // Tabulation method
        dp[0] = nums[0];
        for(int i = 1 ; i < nums.length; i++) {
            int pick = nums[i];
            if(i > 1) pick += dp[i-2];
            int notPick = 0 + dp[i-1];
            dp[i] = Math.max(pick, notPick);
        }
        return dp[nums.length - 1];
    }
    private static int robSpaceOptimized(int[] nums) {
        // space optimization
        int prev = nums[0];
        int prev2 = 0;

        for(int i = 1; i < nums.length; i++) {
            int take = nums[i];
            if(i > 1) take += prev2;
            int notTake = 0 + prev;
            int curi = Math.max(take, notTake);
            prev2 = prev;
            prev = curi;
        }
        return prev;
    }
    public int rob(int[] nums) {
        return robSpaceOptimized(nums);
    }
}