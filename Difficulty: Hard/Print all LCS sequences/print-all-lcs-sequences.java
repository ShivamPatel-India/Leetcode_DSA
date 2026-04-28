// User function Template for Java

class Solution {
    private String s1;
    private String s2;
    public List<String> allLCS(String s1, String s2) {
        this.s1 = s1;
        this.s2 = s2;
        int m = s1.length();
        int n = s2.length();
        int[][] dp = new int[m+1][n+1];
        
        for(int i = 1; i <= m; i++) {
            for(int j = 1; j <= n; j++) {
                if(s1.charAt(i-1) == s2.charAt(j-1)) {
                    dp[i][j] = 1 + dp[i-1][j-1];
                } else {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }
        
        Set<String> set = new HashSet<>();
        Map<String, Boolean> visited = new HashMap<>();
        backtrack(m, n, set, visited, dp, "");
        
        List<String> ans = new ArrayList<>(set);
        Collections.sort(ans);
        return ans;
    }
    private void backtrack(int m, int n, Set<String> set, Map<String, Boolean> visited, int[][] dp, String str) {
        if(m == 0 || n == 0) {
            set.add(new StringBuilder(str).reverse().toString());
            return;
        }
        
        String key = m + "_" + n + "_" + str;
        if(visited.containsKey(key)) return;
        visited.put(key, true);
        
        if(s1.charAt(m-1) == s2.charAt(n-1)) {
            backtrack(m-1, n-1, set, visited, dp, str + s1.charAt(m-1));
        } else {
            if(dp[m-1][n] > dp[m][n-1]) {
                backtrack(m-1, n, set, visited, dp, str);
            } else if(dp[m][n-1] > dp[m-1][n]) {
                backtrack(m, n-1, set, visited, dp, str);
            } else {
                backtrack(m-1, n, set, visited, dp, str);
                backtrack(m, n-1, set, visited, dp, str);
            }
        }
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
    }
}