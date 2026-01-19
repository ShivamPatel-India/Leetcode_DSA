import java.util.*;

class Solution {
    public int maxCoins(ArrayList<Integer> nums) {
        int n = nums.size();
        nums.add(0,1);
        nums.add(1);

        int[][] dp = new int[n+2][n+2];
        for(int i = n; i >= 1; i--) {
            for(int j = 1; j <= n; j++) {
                if(i > j) continue;
                int maxi = Integer.MIN_VALUE;
                for(int ind = i; ind <= j; ind++) {
                    int cost = nums.get(i-1) * nums.get(ind) * nums.get(j+1) 
                                + dp[i][ind-1] + dp[ind+1][j];
                    maxi = Math.max(maxi, cost);
                }
                dp[i][j] = maxi;
            } 
        }
        return dp[1][n];
    }
    public int maxCoins(int[] arr) {
        ArrayList<Integer> nums = Arrays.stream(arr).boxed().collect(Collectors.toCollection(ArrayList::new));
        return maxCoins(nums);
    }

}