class Solution {
    // check if string a palindrome or not
    private boolean isPalindrome(String s, int start, int end) {
        while(start < end) {
            if(s.charAt(start) != s.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
    // recursive helper with memoization to find min cuts from index 'start'
    private int minCutsHelper(String s, int start, int[] dp) {
        int n = s.length();

        // return 0 if reached to the end or string is already palindrome
        if(start == n || isPalindrome(s, start, n-1)) return 0;

        // return memoized value if already computed
        if(dp[start] != -1) return dp[start];

        int minCuts = Integer.MAX_VALUE;

        // try all possible partitions
        for(int end = start; end < n; end++) {
            if(isPalindrome(s, start, end)) {
                // 1 cut plus cuts for the remaining substring
                int cuts = 1 + minCutsHelper(s, end + 1, dp);
                minCuts = Math.min(minCuts, cuts); 
            }
        }
        return dp[start] = minCuts;
    }
    public int minCut(String s) {
        int n = s.length();
        int[] dp = new int[n];
        Arrays.fill(dp, -1);
        return minCutsHelper(s, 0, dp);
    }
}