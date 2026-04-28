class Solution {
    private int n1;
    private int n2;
    private int dp[][];
    private int solve(int i, int j, String s1, String s2) {
        if(i >= n1 || j >= n2) return 0;
        if(dp[i][j] != -1) return dp[i][j];
        // if two chars are equal that will increase the length of LCS by 1
        if(s1.charAt(i) == s2.charAt(j)) return dp[i][j] = 1 + solve(i+1, j+1, s1, s2);

        // tf two chars are not same then there will be two possibilities 
        // skip the unmatching characters from s1 and s2 one by one 
        int skipFromS1 = solve(i+1, j, s1, s2);
        int skipFromS2 = solve(i, j+1, s1, s2);
        return dp[i][j] = Math.max(skipFromS1, skipFromS2);
    }
    public int longestCommonSubsequence(String text1, String text2) {
        n1 = text1.length();
        n2 = text2.length();
        dp = new int[n1+1][n2+1];
        for(int[] row: dp) Arrays.fill(row, -1);
        return solve(0, 0, text1, text2);
    }
}