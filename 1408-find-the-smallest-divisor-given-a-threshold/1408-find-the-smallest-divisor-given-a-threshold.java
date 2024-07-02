class Solution {
    public int calculateSum(int[] nums, int divisor, int n) {
        int sum = 0;
        for(int i=0; i<n; i++) {
            sum += Math.ceil((double)nums[i]/(double)divisor);
        }
        return sum;
    }
    public int smallestDivisor(int[] nums, int threshold) {
        int high = Integer.MIN_VALUE;
        int n = nums.length;
        for(int i = 0; i < n; i++) {
            high = Math.max(nums[i], high);
        }
        int low = 1;
        int ans = Integer.MAX_VALUE;
        while(low <= high) {
            int mid = low + (high - low) / 2;

            int sum = calculateSum(nums, mid, n);

            if(sum <= threshold) {
                ans = Math.min(ans, mid);
                high = mid - 1;
            } else low = mid + 1;
        }
        return ans;
    }
}