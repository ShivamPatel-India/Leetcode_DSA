class Solution {
    public static void subSet(int[] nums, List<List<Integer>> ans, List<Integer> seq, int i, int n) {
        if(i >= n) {
            ans.add(new ArrayList<>(seq));
            return;
        }
        seq.add(nums[i]);
        subSet(nums, ans, seq, i + 1, n);
        seq.removeLast();
        while(i+1 < n && nums[i] == nums[i+1]) i++;
        subSet(nums, ans, seq, i + 1, n);
    }   
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);
        subSet(nums, ans, new ArrayList<>(), 0, nums.length);
        return ans;
    }
}