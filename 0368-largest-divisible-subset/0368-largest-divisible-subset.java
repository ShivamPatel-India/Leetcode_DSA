class Solution {
    public List<Integer> printLDS(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;

        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        int[] hash = new int[n];

        for(int i = 1; i < n; i++) {
            hash[i] = i;
            for(int prev = 0; prev < i; prev++) {
                if(nums[i] % nums[prev] ==0  && 1 + dp[prev] > dp[i]) {
                    dp[i] = 1 + dp[prev];
                    hash[i] = prev;
                }
            }
        }
        int lastIndex = -1;
        int ans = -1;
        for(int i = 0; i < n; i++) {
            if(ans < dp[i]) {
                ans = dp[i];
                lastIndex = i;
            }
        }
        List<Integer> temp = new ArrayList<>();
        temp.add(nums[lastIndex]);

        while(hash[lastIndex] != lastIndex) {
            lastIndex = hash[lastIndex];
            temp.add(nums[lastIndex]);
        }
        Collections.sort(temp);
        return temp;
    }

    public List<Integer> largestDivisibleSubset(int[] nums) {
        return printLDS(nums);
    }
}