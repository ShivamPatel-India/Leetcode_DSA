class Solution {
    public int solve(int currentStep, int n, int[] dp) {
        if(currentStep > n) return 0;
        if(currentStep == n) return 1;
        if(dp[currentStep] != -1) return dp[currentStep];
        return dp[currentStep] = solve(currentStep + 1, n, dp) + solve(currentStep + 2, n, dp);
    }
    public int climbStairs(int n) {
        int[] dp = new int[n+1];
        Arrays.fill(dp, -1);
        return solve(0, n, dp);
    }
}