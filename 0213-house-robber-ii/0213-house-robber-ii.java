class Solution {
    public int robSpaceOptimized(int[] nums) {
        int prev = nums[0];
        int prev2 = 0;

        for(int i = 1; i < nums.length; i++) {
            int take = nums[i];
            if(i > 1) take += prev2;
            int notTake = 0 + prev;

            int curi = Math.max(take, notTake);
            prev2 = prev;
            prev = curi;
        }
        return prev;
    }
    public int rob(int[] nums) {
        int[] numslh = new int[nums.length - 1]; // array that includes last house
        int[] numsfh = new int[nums.length - 1]; // array that includes first house

        int n = nums.length;
        if(n == 1) return nums[0];

        for(int i = 0 ; i < n; i++) {
            if(i != 0) numslh[i-1] = nums[i];
            if(i != n-1) numsfh[i] = nums[i]; 
        }

        return Math.max(robSpaceOptimized(numsfh), robSpaceOptimized(numslh));
    }
}