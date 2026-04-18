class Solution {
    private int n;
    private long[][] dp;

    private long solve(int idx, int[] nums, int flag) { // int flag instead of boolean for dp indexing
        if(idx >= n) return 0;
        if(dp[idx][flag] != -1) return dp[idx][flag];

        long skip = solve(idx+1, nums, flag); // skip current element
        long val = (flag == 1) ? nums[idx] : -nums[idx]; // add or subtract
        long take = solve(idx+1, nums, 1-flag) + val; // flip flag after taking

        return dp[idx][flag] = Math.max(skip, take);
    }

    public long maxAlternatingSum(int[] nums) {
        n = nums.length;
        dp = new long[n][2];
        for(long[] row: dp) Arrays.fill(row, -1);
        return solve(0, nums, 1); // start with flag=1 meaning we add first
    }
}