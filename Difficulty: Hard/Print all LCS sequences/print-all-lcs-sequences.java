class Solution {
    private String s1;
    private String s2;

    public List<String> allLCS(String s1, String s2) {
        this.s1 = s1;
        this.s2 = s2;
        int m = s1.length();
        int n = s2.length();

        // Step 1: build LCS table
        int[][] dp = new int[m+1][n+1];
        for(int i = 1; i <= m; i++) {
            for(int j = 1; j <= n; j++) {
                if(s1.charAt(i-1) == s2.charAt(j-1))
                    dp[i][j] = 1 + dp[i-1][j-1];
                else
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
            }
        }

        // Step 2: backtrack to find all LCS
        Set<String> set = new HashSet<>();
        Map<String, Boolean> visited = new HashMap<>();
        backtrack(m, n, set, "", dp, visited);

        // Step 3: sort and return
        List<String> result = new ArrayList<>(set);
        Collections.sort(result);
        return result;
    }

    private void backtrack(int m, int n, Set<String> set, String str, int[][] dp, Map<String, Boolean> visited) {
        // base case — reverse because we built string backwards
        if(m == 0 || n == 0) {
            set.add(new StringBuilder(str).reverse().toString());
            return;
        }

        // memoization key — unique per (m, n, str built so far)
        String key = m + "|" + n + "|" + str;
        if(visited.containsKey(key)) return;
        visited.put(key, true);

        if(s1.charAt(m-1) == s2.charAt(n-1)) {
            // characters match → go diagonal, append char
            backtrack(m-1, n-1, set, str + s1.charAt(m-1), dp, visited);
        } else {
            // no match → go in direction of larger LCS value
            if(dp[m][n-1] > dp[m-1][n]) {
                backtrack(m, n-1, set, str, dp, visited);      // go left
            } else if(dp[m-1][n] > dp[m][n-1]) {
                backtrack(m-1, n, set, str, dp, visited);      // go up
            } else {
                // tie → branch both ways to find ALL LCS
                backtrack(m, n-1, set, str, dp, visited);      // go left
                backtrack(m-1, n, set, str, dp, visited);      // go up
            }
        }
    }
}