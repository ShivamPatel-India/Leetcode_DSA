class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        int[] prev_index = new int[n];
        Arrays.fill(prev_index, -1);

        int maxL = 1;
        int last_chosen_index = 0;
        for(int i = 1; i < n; i++) {
            for(int j = 0; j < i; j++) {
                if(nums[i] % nums[j] == 0) {
                    if(dp[i] < dp[j] + 1) {
                        dp[i] = dp[j] + 1;
                        prev_index[i] = j;
                    }
                    if(dp[i] > maxL) {
                        maxL = dp[i];
                        last_chosen_index = i;
                    }
                }
            }
        }
        List<Integer> ans = new ArrayList<>();
        while(last_chosen_index != -1) {
            ans.add(nums[last_chosen_index]);
            last_chosen_index = prev_index[last_chosen_index];
        }
        return ans;
    }
}