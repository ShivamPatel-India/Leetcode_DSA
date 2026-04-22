class Solution {
    private int n;
    private int[][] dp;
    private boolean isPredecessor(String a, String b) {
        int alen = a.length();
        int blen = b.length();
        if(blen + 1 != alen) return false;
        
        int first = 0;
        int second = 0;
        while(first < alen) {
            if(second < blen && a.charAt(first) == b.charAt(second)) {
                first++;
                second++;
            } else first++;
        }
        return first == alen && second == blen;
    }
    private int solve(int i, String[] words, int pi) {
        if(i >= n) return 0;

        if(pi != -1 && dp[i][pi] != -1) return dp[i][pi];
        int take = 0;
        if(pi == -1 || isPredecessor(words[i], words[pi])) {
            take = 1 + solve(i+1, words, i);
        } 
        int skip = solve(i+1, words, pi);
        if(pi != -1) dp[i][pi] = Math.max(take, skip);
        return Math.max(take, skip);
    }
    public int longestStrChain(String[] words) {
        n = words.length;
        dp = new int[n+1][n+1];
        for(int[] row: dp) Arrays.fill(row, -1);
        Arrays.sort(words, (a, b) -> a.length()-b.length());
        return solve(0, words, -1);
    }
}