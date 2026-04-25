class Solution {
    public int longestIdealString(String s, int k) {
        int n = s.length();
        char[] ch = s.toCharArray();
        int[] dp = new int[26];
        int ans = 0;

        for(int i = 0; i < n; i++) {
            int curr = ch[i] - 'a';
            int left = Math.max(0,curr-k);
            int right = Math.min(25, curr+k);

            int longest = 0;
            for(int j = left; j <= right; j++) longest = Math.max(longest, dp[j]);

            dp[curr] = longest + 1;
            ans = Math.max(ans, dp[curr]);
        }
        return ans;
    }
}