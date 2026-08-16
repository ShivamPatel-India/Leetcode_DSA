class Solution {
    public long maxAlternatingSum(int[] nums) {
        int n = nums.length;
        long[][] t = new long[n+1][2]; // 0: odd, 1: even

        // what does t[i][0 or 1] define? 
        // It defines the maximum alternating subsequence sum till index i in the array. And subseq can be of odd or even length (0 for odd, 1 for even)
        for(int i = 1; i <= n; i++) {
            t[i][0] = Math.max(t[i-1][1] + nums[i-1], t[i-1][0]);
            t[i][1] = Math.max(t[i-1][0] - nums[i-1], t[i-1][1]);
        }
        return Math.max(t[n][0], t[n][1]);
    }
}