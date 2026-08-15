class Solution {
    private int n;
    private long[][] dp;
    private long solve(int[] nums, int idx, int flag) {
        if(idx >= n) return 0;
        if(dp[idx][flag] != -1) return dp[idx][flag];
        long val = (flag == 1) ? nums[idx] : -nums[idx];
        long take = val + solve(nums, idx + 1, 1-flag);
        long notTake = solve(nums, idx + 1, flag);
        return dp[idx][flag] = Math.max(take, notTake);
    }
    public long maxAlternatingSum(int[] nums) {
        n = nums.length;
        dp = new long[n][2];
        for(long[] row: dp) Arrays.fill(row, -1);
        return solve(nums, 0, 1);
    }
}