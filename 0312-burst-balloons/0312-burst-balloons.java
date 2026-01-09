import java.util.*;

class Solution {
    public int maxCoins(int i, int j, ArrayList<Integer> nums, int[][] dp) {
        if(i > j) return 0;
        if(dp[i][j] != -1) return dp[i][j];

        int maxi = Integer.MIN_VALUE;
        for(int ind = i; ind <= j; ind++) {
            int coins = (nums.get(ind) * nums.get(i-1) * nums.get(j+1)) 
                            + maxCoins(i, ind-1, nums, dp) 
                            + maxCoins(ind+1, j, nums, dp);
            maxi = Math.max(maxi, coins);
        }
        return dp[i][j] = maxi;
    }
    public int maxCoins(int[] arr) {
        ArrayList<Integer> nums = Arrays.stream(arr).boxed().collect(Collectors.toCollection(ArrayList::new));
        nums.add(1);
        nums.add(0,1);

        int n = arr.length;
        int[][] dp = new int[n+2][n+2];
        for(int[] row : dp) {
            Arrays.fill(row, -1);
        }
        return maxCoins(1, n, nums, dp);
    }

}