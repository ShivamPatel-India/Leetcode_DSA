class Solution {
    public int calculateSum(int[] nums, int n, int divisor) {
        int sum = 0;

        for(int i=0; i<n; i++) {
            sum += (int)Math.ceil((float)(nums[i])/(float)(divisor));
        }
        return sum;
    }
    public int smallestDivisor(int[] nums, int threshold) {
        int max = Integer.MIN_VALUE;

        int n = nums.length;
        for(int i=0; i<n; i++) {
            max = Math.max(max, nums[i]);
        }
        int low = 1;
        int high = max;

        while(low<=high) {
            int mid = low + (high - low)/2;

            int sum = calculateSum(nums,n,mid);

            if(sum<=threshold) high = mid-1;
            else low = mid+1;
        }
        return low; 
    }
}