class Solution {
    private static int[] dp;
    private static int robRecursive(int[] nums, int index) {
        // index represents the current house
        if(index >= nums.length) return 0;
        if(dp[index] != -1) return dp[index];
        int rob = nums[index] + robRecursive(nums, index + 2); // index + 2 cause we cannot rob the next house which is adjacent to current house 
        int notRob = 0 + robRecursive(nums, index+1); // since current house not robbed, next house can be robbed
        return dp[index] = Math.max(rob, notRob);

    }
    private static int tabulation(int[] nums) {
        int n = nums.length;
        dp = new int[n+1];
        dp[n] = nums[n-1];
        for(int i = n-1; i >= 0; i--) {
            int rob = nums[i];
            if(i < n-2) rob += dp[i+2];
            int notRob = dp[i+1];
            dp[i] = Math.max(rob, notRob);
        }
        return dp[0];
    }
    public int rob(int[] nums) {
        // we have two options at each house - to rob or not to rob
        
        // int n = nums.length;
        // dp = new int[n+1];
        // Arrays.fill(dp, -1);
        // return robRecursive(nums, 0);

        return tabulation(nums);
    }
}