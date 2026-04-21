class Solution {
    private int n;
    private int[][] dp;
    private int solve(int i, int[] nums, int previ) {
        if(i >= n) return 0;
        if(previ != -1 && dp[i][previ] != -1) return dp[i][previ];

        int take = 0;
        if(previ == -1 || nums[i] > nums[previ]) {
            take = 1 + solve(i+1, nums, i);
        }
        int skip = solve(i+1, nums, previ);
        if(previ != -1) {
            dp[i][previ] = Math.max(take, skip);
        }
        return Math.max(take, skip);
    }
    public int lengthOfLIS(int[] nums) {
        n = nums.length;
        dp = new int[n+1][n+1];
        for(int[] row: dp) Arrays.fill(row, -1);
        return solve(0, nums, -1);
    }
}