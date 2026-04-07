class Solution {
    public boolean checkPossibility(int[] nums) {
        int n = nums.length;
        int dip = -1;

        // Step 1: find the dip
        for(int i = 0; i < n-1; i++) {
            if(nums[i+1] < nums[i]) {
                if(dip != -1) return false; // two dips → impossible
                dip = i;
            }
        }

        if(dip == -1)    return true; // no dip → already sorted
        if(dip == 0)     return true; // dip at start → remove first element
        if(dip == n-2)   return true; // dip at end → remove last element

        // Step 2: try both removals
        if(nums[dip-1] <= nums[dip+1]) return true; // remove HIGH (dip)
        if(nums[dip]   <= nums[dip+2]) return true; // remove LOW  (dip+1)

        return false;
    }
}