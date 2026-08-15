class Solution {
    private static int robSpaceOptimized(int[] nums) {
        int n = nums.length;
        if(n == 0) return 0;
        int last = nums[n-1];
        int secondLast = 0;
        for(int i = n-1; i >= 0; i--) {
            int rob = nums[i];
            if(i < n-2) rob += last;
            int notRob = secondLast;
            int cur = Math.max(rob, notRob); 
            last = secondLast;
            secondLast = cur;
        }
        return secondLast;
    }
    public int rob(int[] nums) {
        int n = nums.length;
        int[] numsls = new int[n-1];
        int[] numsrs = new int[n-1];
        
        if(n == 1) return nums[0];
        for(int i = 0; i < n; i++) {
            if(i != 0) numsrs[i-1] = nums[i];
            if(i != n-1) numsls[i] = nums[i];
        }
        return Math.max(robSpaceOptimized(numsls), robSpaceOptimized(numsrs));   
    }
}