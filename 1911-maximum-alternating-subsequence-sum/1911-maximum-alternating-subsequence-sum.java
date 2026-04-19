class Solution {
    public int n;
    public long[][] dp;
    public long solve(int idx, int[] nums, int isEven) {
        if(idx >= n) return 0;
        if(dp[idx][isEven] != -1) return dp[idx][isEven];
        long skip = solve(idx + 1, nums, isEven);
        long val = (isEven == 1) ? nums[idx] : -nums[idx];
        long take = solve(idx + 1, nums, 1-isEven) + val;
        return dp[idx][isEven] = Math.max(take, skip);
    }
    public long maxAlternatingSum(int[] nums) {
        n = nums.length;
        dp = new long[n][2];
        for(long[] row: dp) Arrays.fill(row, -1);
        return solve(0, nums, 1);
    }
}