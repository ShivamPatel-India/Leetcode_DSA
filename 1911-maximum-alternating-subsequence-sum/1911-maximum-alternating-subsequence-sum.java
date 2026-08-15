class Solution {
    public long maxAlternatingSum(int[] nums) {
        int n = nums.length;
        // DP table: t[i][0] stores max sum for odd-length subsequence,
        // t[i][1] stores max sum for even-length subsequence.
        long[][] t = new long[n+1][2];

        for(int i = 1; i < n+1; i++) {
            // Even-length sequence (t[i][1]):
            // Either include current number as a subtraction (from an odd-length prefix),
            // or skip it (inherit the best even-length sum found so far).
            t[i][1] = Math.max(t[i-1][0] - nums[i-1], t[i-1][1]);

            // Odd-length sequence (t[i][0]):
            // Either include current number as an addition (to an even-length prefix),
            // or skip it (inherit the best odd-length sum found so far).
            t[i][0] = Math.max(t[i-1][1] + nums[i-1], t[i-1][0]);
        }

        // The answer is the maximum sum possible ending at the last element,
        // regardless of whether the subsequence length is odd or even.
        return Math.max(t[n][0], t[n][1]);
    }
}