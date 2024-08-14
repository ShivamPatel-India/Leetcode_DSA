class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int n = nums.length;

        int count = 0;
        int maxConsecutive = 0;
        for(int i=0; i< n; i++) {
            if(nums[i] == 1) {
                count++;
            } else {
                count = 0;
            }

            maxConsecutive = Math.max(maxConsecutive, count);
        }
        return maxConsecutive;
    }
}