class Solution {
    public int f(int[] nums, int i, int pi) {
        // pure recursive solution gives TLE

        // i = index, pi = previous index
        if(i == nums.length) return 0;

        int take = 0 + f(nums, i + 1, pi);
        int notTake = 0;
        if(pi == -1 || nums[i] > nums[pi]) {
            notTake = 1 + f(nums, i+1, i);
        }
        return Math.max(take, notTake);
    }
    public int memoized(int[] nums, int n, int i, int pi, int[][] dp) {
        // recusion with memoization
        if(i == n) return 0;
        if(dp[i][pi+1] != -1) return dp[i][pi+1];

        int take = 0 + memoized(nums, n, i+1, pi, dp);
        int notTake = 0;
        if(pi == -1 || nums[i] > nums[pi]) {
            notTake = 1 + memoized(nums, n, i+1, i, dp);
        }
        return dp[i][pi+1] = Math.max(take, notTake);
    }
    public int lengthOfLIS(int[] nums) {
        // return f(nums, 0, -1);
        int n = nums.length;

        // dp array for memoization with co-ordinate shift bcz arrays dont support -1 index
        int[][] dp = new int[n][n+1];
        for(int[] row: dp) Arrays.fill(row, -1);
        return memoized(nums, n, 0, -1, dp);
    }
}