class Solution {
    public int n;
    public long[][] dp;
    public long solve(int idx, int[] nums, int isEven) {
        if(idx >= n) return 0;
        if(dp[idx][isEven] > -1) return dp[idx][isEven];
        long skip = solve(idx + 1, nums, isEven);
        long val = nums[idx];
        if(isEven == 0) val = -val;
        long take = solve(idx + 1, nums, 1-isEven) + val;
        return dp[idx][isEven] = Math.max(take, skip);
    }
    public long maxAlternatingSum(int[] nums) {
        n = nums.length;
        dp = new long[100001][2];
        for(int i = 0; i < dp.length; i++) Arrays.fill(dp[i], -1);
        return solve(0, nums, 1);
    }
}