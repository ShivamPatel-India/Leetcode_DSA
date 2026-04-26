class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        List<Integer> sorted = new ArrayList<>();
        sorted.add(nums[0]);
        for(int i = 1; i < n; i++) {
            if(nums[i] > sorted.get(sorted.size()-1)) sorted.add(nums[i]);
            else {
                int index = lowerBound(sorted, nums[i]);
                sorted.set(index, nums[i]);
            }
        }
        return sorted.size();
    }
    private int lowerBound(List<Integer> sorted, int target) {
        int left = 0;
        int right = sorted.size();
        int result = sorted.size();

        while(left < right) {
            int mid = left + (right - left) / 2;

            // we need to find the smallest greater or equal element
            if(sorted.get(mid) >= target) {
                result = mid;
                right = mid;
            } else left = mid + 1;
        }
        return result;
    }
}