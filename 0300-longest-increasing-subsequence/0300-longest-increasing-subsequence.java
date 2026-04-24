class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        List<Integer> sorted = new ArrayList<>();

        for(int i = 0; i < n; i++) {
            int index = binarySearch(nums[i], sorted);

            if(index == sorted.size()) sorted.add(nums[i]);
            else sorted.set(index, nums[i]);
        }
        return sorted.size();
    }
    private int binarySearch(int target, List<Integer> sorted) {
        int left = 0; int right = sorted.size();
        int result = sorted.size();

        while(left < right) {
            int mid = left + (right-left) / 2;
            if(sorted.get(mid) < target) {
                left = mid + 1;
            } else {
                right = mid;
                result = mid;
            }
        }
        return result;
    }
}