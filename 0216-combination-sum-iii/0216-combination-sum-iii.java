class Solution {
    public static void dfs(int[] nums, List<List<Integer>> ans, List<Integer> cur, int i, int n, int target, int total, int len) {
        if(total == target) {
            if(cur.size() == len) {
                ans.add(new ArrayList(cur));
            }
            return;
        }
        if(i >= n || total > target) return;
        if(cur.size() > len) return;

        cur.add(nums[i]);
        dfs(nums, ans, cur, i+1, n, target, total + nums[i], len);
        cur.removeLast();

        while(i+1<n && nums[i] == nums[i+1]) i++;
        dfs(nums, ans, cur, i+1, n, target, total, len);
    }
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> ans = new ArrayList<>();
        int[] nums = new int[]{1,2,3,4,5,6,7,8,9};
        dfs(nums, ans, new ArrayList<>(), 0,  nums.length, n, 0, k);
        return ans;

    }
}