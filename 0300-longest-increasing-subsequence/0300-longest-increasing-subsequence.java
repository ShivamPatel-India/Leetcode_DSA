class Solution {
    private int n;
    private int[][] dp;
    public int solve(int[] nums, int i, int prev) {
        if(i >= n) return 0;
        if(prev != -1 && dp[i][prev] != -1) return dp[i][prev];

        int take = 0;
        if(prev == -1 || nums[i] > nums[prev]) {
            take = 1 + solve(nums, i+1, i);
        }
        int skip = solve(nums, i+1, prev);
        if(prev != -1) {
            dp[i][prev] = Math.max(take, skip);
        }
        return Math.max(take, skip);
    }
    public int lengthOfLIS(int[] nums) {
        n = nums.length;
        // state definition: dp[i][prev] would define the length of LIS in which the last element comes from "prev" index till the index i
        dp = new int[n+1][n+1]; 
        for(int[] row: dp) Arrays.fill(row, -1);
        return solve(nums, 0, -1);
    }
}