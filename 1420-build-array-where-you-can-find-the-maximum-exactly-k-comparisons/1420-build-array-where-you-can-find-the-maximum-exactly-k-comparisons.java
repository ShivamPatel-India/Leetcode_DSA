class Solution {
    // According to problme statement, we need to find the number of ways in which we can build the array of length n with each element value ranging from 1 to m (inclusive) and search_cost musk be k.

    // for every position [0 to n-1] there are 1 to m possibilities.
    private int N, M, K;
    private int MOD = 1_000_000_007;   
    private int dp[][][] = new int[51][51][101];
    private int solve(int idx, int sc, int max) {
        if(idx == N) {
            if(sc == K) return 1;
            return 0;
        }
        if(dp[idx][sc][max] != -1) return dp[idx][sc][max];
        int result = 0;
        for(int i = 1; i <= M; i++) {
            if(i > max) result = (result + solve(idx + 1, sc + 1, i)) % MOD;
            else result = (result + solve(idx + 1, sc, max)) % MOD;
        }
        return dp[idx][sc][max] = result % MOD;
    }
    public int numOfArrays(int n, int m, int k) {
        N = n; M = m; K = k;
        for(int[][] arr: dp) {
            for(int[] row: arr) {
                Arrays.fill(row, -1);
            }
        }
        return solve(0, 0, 0);

    }
}