class Solution {
    public static void dfs(int[] nums, List<List<Integer>> ans, List<Integer> cur, int i, int n, int target, int total) {
        if(total == target) {
            ans.add(new ArrayList(cur));
            return;
        }
        if(i >= n || total > target) return;

        cur.add(nums[i]);
        dfs(nums, ans, cur, i+1, n, target, total + nums[i]);
        cur.removeLast();

        while(i+1<n && nums[i] == nums[i+1]) i++;
        dfs(nums, ans, cur, i+1, n, target, total);
    }
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(candidates);
        dfs(candidates, ans, new ArrayList<>(), 0, candidates.length, target, 0);
        return ans;
    }
}