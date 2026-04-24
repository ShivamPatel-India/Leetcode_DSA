class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        List<Integer> sorted = new ArrayList<>();

        for(int i = 0; i < n; i++) {
            int index = binarySearch(sorted, nums[i]);
            
            if(index == sorted.size()) {
                sorted.add(nums[i]);
            } else {
                sorted.set(index, nums[i]);
            }
        }
        return sorted.size();
    }
    private int binarySearch(List<Integer> sorted, int target) {
        int l = 0, r = sorted.size();
        int result = sorted.size();

        while(l < r) {
            int m = l + (r - l) / 2;
            if(sorted.get(m) < target) {
                l = m + 1;
            } else {
                result = m;
                r = m;
            }
        }
        return result;
    }
}