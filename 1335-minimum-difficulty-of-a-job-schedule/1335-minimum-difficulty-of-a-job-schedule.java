class Solution {
    private int solve(int[] jd, int n, int idx, int d, int[][] dp) {
        // BASE CASE: only 1 day left so find the max difficulty out of remaining jobs
        if(d == 1) {
            int maxD = jd[idx];
            for(int i = idx + 1; i < n; i++) maxD = Math.max(maxD, jd[i]);
            return maxD;
        }
        if(dp[idx][d] != -1) return dp[idx][d];
        int maxD = jd[idx];
        int finalResult = Integer.MAX_VALUE;
        for(int i = idx; i <= n-d; i++) {
            maxD = Math.max(maxD, jd[i]);
            int result = maxD + solve(jd, n, i + 1, d - 1, dp);
            finalResult = Math.min(result, finalResult);
        }
        return dp[idx][d] = finalResult;
    } 
    public int minDifficulty(int[] jobDifficulty, int d) {
        int n = jobDifficulty.length;
        if(n < d) return -1;
        int[][] dp = new int[301][11];
        for(int i = 0; i < 301; i++) Arrays.fill(dp[i], -1);
        return solve(jobDifficulty, n, 0, d, dp);
    }
}