class Solution {
    private int n1, n2;

    private int solve(String s1, String s2) {
        int[] cur  = new int[n2+1];
        int[] prev = new int[n2+1];

        for(int i = 1; i <= n1; i++) {
            for(int j = 1; j <= n2; j++) {
                if(s1.charAt(i-1) == s2.charAt(j-1)) {
                    cur[j] = 1 + prev[j-1];
                } else {
                    cur[j] = Math.max(prev[j], cur[j-1]); // ← cur[j-1] not prev[j-1]!
                }
            }
            prev = cur.clone(); // ✅ copy
            cur  = new int[n2+1]; // ✅ reset
        }
        return prev[n2]; // ← prev not cur (cur is reset to empty)
    }

    public int longestCommonSubsequence(String text1, String text2) {
        n1 = text1.length();
        n2 = text2.length();
        return solve(text1, text2);
    }
}