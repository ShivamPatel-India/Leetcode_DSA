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
    // tabulation approach to find min cuts
    private int minCutsHelper(String s) {
        int n = s.length();
        int[] dp = new int[n+1];
        dp[n] = -1;
        // fill dp array from end to start
        for(int i = n-1; i >= 0; i--) {
            int minCuts = Integer.MAX_VALUE;

            for(int j = i; j < n; j++) {
                if(isPalindrome(s, i, j)) {
                    int cuts = 1 + dp[j+1];
                    minCuts = Math.min(minCuts, cuts);
                }
            } 
            dp[i] = minCuts;
        }
        return dp[0];
    }
    public int minCut(String s) {
        return minCutsHelper(s);
    }
}