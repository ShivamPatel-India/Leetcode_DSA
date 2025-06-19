class Solution {
    public static void dfs(List<List<Integer>> ans, int[] nums, List<Integer> cur, int i, int n, int target, int total) {
        if(total == target) {
            ans.add(new ArrayList<>(cur));
            return;
        }
        if(i >= n || total > target) return;

        cur.add(nums[i]);
        dfs(ans, nums, cur, i, n, target, total + nums[i]);
        cur.removeLast();
        dfs(ans, nums, cur, i + 1, n, target, total);
    }
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        dfs(ans, candidates, new ArrayList<>(), 0, candidates.length, target, 0);
        return ans;
    }
}