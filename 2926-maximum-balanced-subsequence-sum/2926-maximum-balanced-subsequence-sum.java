class Solution {
    public long maxBalancedSubsequenceSum(int[] nums) {
        int n = nums.length;
        long ans = Long.MIN_VALUE;
        TreeMap<Integer, Long> map = new TreeMap<>();
        int[] arr = new int[n];
        for(int i = 0; i < n; i++) {
            arr[i] = nums[i] - i;
        }
        for(int i = 0; i < n; i++) {
            if(nums[i] <= 0) {
                ans = Math.max(nums[i], ans);
            } else {
                long temp = nums[i];
                if(map.floorKey(arr[i]) != null) {
                    temp += map.get(map.floorKey(arr[i]));
                }
                while(map.ceilingKey(arr[i]) != null && map.get(map.ceilingKey(arr[i])) < temp) map.remove(map.ceilingKey(arr[i]));
                if(map.floorKey(arr[i]) == null || map.get(map.floorKey(arr[i])) < temp) map.put(arr[i], temp);
                ans = Math.max(ans, temp);
            }
        }
        return ans;
    }
}