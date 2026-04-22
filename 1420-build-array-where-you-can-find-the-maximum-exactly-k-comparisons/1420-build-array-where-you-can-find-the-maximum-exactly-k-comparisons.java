class Solution {
    private int N, M, K;
    private int MOD = 1_000_000_007;
    private int[][][] dp;
    private int solve(int idx, int sc, int max) {
        if(idx == N) {
            if(sc == K) return 1;
            return 0;
        }
        if(dp[idx][sc][max] != -1) return dp[idx][sc][max];
        int result = 0;
        for(int i = 1; i <= M; i++) {
            if(i > max) result = (result + solve(idx+1, sc+1, i)) % MOD;
            else result = (result + solve(idx+1, sc, max)) % MOD;
        }
        return dp[idx][sc][max] = result % MOD;
    }
    public int numOfArrays(int n, int m, int k) {
        N = n; M = m; K = k;
        dp = new int[N+1][N+1][M+1];
        for(int[][] arr: dp) {
            for(int[] row: arr){
                Arrays.fill(row, -1);
            }
        }
        return solve(0, 0, 0); // solve(int idx, int searchCost, int maxSoFar)
    }
}