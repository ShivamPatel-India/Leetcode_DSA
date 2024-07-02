class Solution {

    private int smallestDivisorHelper(int[] nums, int d) {
        int sum = 0;
        for (int i=0;i<nums.length;i++) {
            sum += Math.ceil((double)(nums[i])/(double)(d));
        }
        return sum;
    }

    public int smallestDivisor(int[] nums, int threshold) {
        int n = nums.length;

        int maxi = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            maxi = Math.max(maxi, nums[i]);
        }

        int low = 1;
        int high = maxi;


        while(low<=high) {
            int mid = low + (high-low)/2;

            int sum = smallestDivisorHelper(nums,mid);

            if (sum <= threshold) high = mid-1;
            else if (sum > threshold) low = mid+1;
        }
        return low;
    }
}