class Solution {
    public void subSeq(int[] nums, List<List<Integer>> ans, List<Integer> seq,int index, int n) {
        if(index >= n) {
            ans.add(new ArrayList<>(seq));
            return;
        }
        seq.add(nums[index]);
        subSeq(nums, ans, seq, index + 1, n);
        seq.removeLast();
        subSeq(nums,ans, seq, index + 1, n);
    }
    public List<List<Integer>> subsets(int[] nums) {
        int n = nums.length;
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> seq = new ArrayList<>();
        subSeq(nums, ans, seq, 0, n);
        return ans;
    }
}