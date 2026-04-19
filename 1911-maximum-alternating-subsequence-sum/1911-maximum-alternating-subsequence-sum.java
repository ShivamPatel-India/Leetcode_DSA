class Solution {
    public long maxAlternatingSum(int[] nums) {
        int n = nums.length;
        long[][] t = new long[n+1][2];
        for(int i = 1; i < n+1; i++) { // 1 : even, 0 : odd
            // even
            t[i][1] = Math.max(t[i-1][0] - nums[i-1], t[i-1][1]);
            // odd
            t[i][0] = Math.max(t[i-1][1] + nums[i-1], t[i-1][0]);
        }
        return Math.max(t[n][0], t[n][1]);
    }
}