class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> mp = new HashMap<>();

        for(int i =0; i<nums.length; i++) {
            int num = nums[i];
            int moreNeeded = target - num;

            if(mp.containsKey(moreNeeded)) {
                return new int[]{mp.get(moreNeeded),i};
            }

            mp.put(nums[i],i);
        }

        return new int[]{};
    }
}