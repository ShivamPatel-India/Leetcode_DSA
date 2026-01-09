import java.util.*;

class Solution {
    public int recursion(int i, int j, ArrayList<Integer> cuts, int[][] dp) {
        if(i > j) return 0;
        if(dp[i][j] != -1) return dp[i][j];

        int minCost = Integer.MAX_VALUE;
        for(int ind = i; ind <= j; ind++) {
           int cost = cuts.get(j+1) - cuts.get(i-1) 
                        + recursion(i, ind-1, cuts, dp) 
                        + recursion(ind+1, j, cuts, dp);
           minCost = Math.min(minCost, cost);  
        }
        return dp[i][j] = minCost;
    }
    public int minCost(int n, int[] c) {
        ArrayList<Integer> cuts = Arrays.stream(c).boxed().collect(Collectors.toCollection(ArrayList::new));
        cuts.add(n);
        cuts.add(0);
        Collections.sort(cuts);

        int m = c.length;
        int dp[][] = new int[m+2][m+2];
        for(int[] row : dp) {
            Arrays.fill(row, -1);
        }
        return recursion(1, c.length, cuts, dp);
    }
}