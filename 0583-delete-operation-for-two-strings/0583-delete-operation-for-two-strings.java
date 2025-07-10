class Solution {
    public int minDistance(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();

        int[] prev = new int[m+1];
        
        for(int i = 1; i <= n; i++) {
            int[] cur = new int[m+1];
            for(int j = 1; j <= m; j++) {
                if(s1.charAt(i-1) == s2.charAt(j-1)) {
                    cur[j] = 1 + prev[j-1];
                } else cur[j] = Math.max(prev[j], cur[j-1]);
            }
            prev = cur;
        }
        return n+m-(2*prev[m]);
    }
}