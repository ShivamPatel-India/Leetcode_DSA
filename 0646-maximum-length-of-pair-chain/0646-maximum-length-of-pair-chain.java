class Solution {
    private int n;
    private int[][] dp;
    private int solve(int[][] pairs, int i, int pi) {
        if(i >= n) return 0;
        if(pi != -1 && dp[i][pi] != -1) return dp[i][pi];
        int take = 0;
        if(pi == -1 || pairs[pi][1] < pairs[i][0]) {
            take = 1 + solve(pairs, i+1, i);
        }
        int skip = solve(pairs, i+1, pi);
        if(pi != -1) {
            return dp[i][pi] = Math.max(take, skip);
        }
        return Math.max(take, skip);
    }
    public int findLongestChain(int[][] pairs) {
        n = pairs.length;
        dp = new int[n+1][n+1];
        for(int[] row: dp) Arrays.fill(row, -1);
        Arrays.sort(pairs, (a,b) -> a[0] - b[0]);
        return solve(pairs, 0, -1);
    }
}