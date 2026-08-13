class Solution {
    // public int solve(int currentStep, int n, int[] dp) {
    //     if(currentStep > n) return 0;
    //     if(currentStep == n) return 1;
    //     if(dp[currentStep] != -1) return dp[currentStep];
    //     return dp[currentStep] = solve(currentStep + 1, n, dp) + solve(currentStep + 2, n, dp);
    // }
    public int climbStairs(int n) {
        // Memoization - goint fro 0th stair to last stair (top-down on recursive tree)
        // int[] dp = new int[n+1];
        // Arrays.fill(dp, -1);
        // return solve(0, n, dp);

        // Tabulation - going from last stair to 0th stair (bottom-up on recursive tree)
        if(n <= 1) return 1;
        int last = 1; // one-way to be on the last stair
        int secondLast = 1; // one-way to go on second last stair from last stair

        for(int i = n-2; i >= 0; i--) {
            int temp = last + secondLast;
            last = secondLast;
            secondLast = temp;
        }
        return secondLast;
    }
}