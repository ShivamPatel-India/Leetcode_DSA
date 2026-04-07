class Solution {
    public boolean checkPossibility(int[] nums) {
        int dip = -1;
        int n = nums.length;
        
        for(int i = 0; i < n-1; i++) {
            if(nums[i+1] < nums[i]) {
                if(dip != -1) return false; // 2 dip found
                dip = i;
            }
        }

        if(dip == -1) return true; // no dip 
        
        // dip on teh edges
        else if(dip == 0 || dip == n-2) return true;
        else if(nums[dip] <= nums[dip+2]) return true;
        else if(nums[dip-1] <= nums[dip+1]) return true;
        return false;
    }
}