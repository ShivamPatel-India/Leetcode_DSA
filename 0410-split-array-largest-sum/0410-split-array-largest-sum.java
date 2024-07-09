class Solution {
    public int countPartition(int[] nums, int possibleMaxSum, int n) {
        int partition = 1;
        int s = 0;

        for(int i = 0; i<n; i++) {
            if(s + nums[i] <= possibleMaxSum) {
                s += nums[i];
            } else {
                partition++;
                s = nums[i];
            }
        }
        return partition;
    }
    public int splitArray(int[] nums, int k) {
        int n = nums.length;
        int low = Integer.MIN_VALUE;
        int high = 0;
        for(int i=0; i<n; i++) {
            low = Math.max(low, nums[i]);
            high += nums[i];
        }
        
        int ans = Integer.MAX_VALUE;
        while(low <= high) {
            int mid = low + (high - low) / 2;

            int partition = countPartition(nums, mid, n);

            if(partition > k) {
                low = mid + 1;
            } else {
                high = mid - 1;
                ans = Math.min(ans, mid);
            }
        }
        return ans;
    }
}