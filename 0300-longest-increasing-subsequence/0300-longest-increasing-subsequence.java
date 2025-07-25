import java.util.*;
class Solution {
    public int lengthOfLIS(int[] nums) {
        /** This method contains function calls to other methods, each representing different way to solve LIS */

        // return f(nums, 0, -1);
        
        // int n = nums.length;
        // // dp array for memoization with co-ordinate shift bcz arrays dont support -1 index
        // int[][] dp = new int[n][n+1];
        // for(int[] row: dp) Arrays.fill(row, -1);
        // return memoized(nums, n, 0, -1, dp);

        // return tabulation(nums);

        // return spaceOptimized(nums);

        // return mostOptimized(nums);

        return binarySearchMethod(nums);

        // printLIS(nums);
        // return -1;
    }
    public int binarySearchMethod(int[] nums) {
        int n = nums.length;
        List<Integer> temp = new ArrayList<Integer>();
        temp.add(nums[0]);

        int len = 1;

        for(int i = 1; i < n; i++) {
            if(nums[i] > temp.get(temp.size() -1)) {
                temp.add(nums[i]);
                len++;
            }
            else {
                // Replacement Step
                int ind = Collections.binarySearch(temp, nums[i]);
                if(ind < 0) {
                    ind = -ind - 1;
                }
                temp.set(ind, nums[i]);
            }
        }
        return len;
    }
    public int f(int[] nums, int i, int pi) {
        // pure recursive solution gives TLE

        // i = index, pi = previous index
        if(i == nums.length) return 0;

        int take = 0 + f(nums, i + 1, pi);
        int notTake = 0;
        if(pi == -1 || nums[i] > nums[pi]) {
            notTake = 1 + f(nums, i+1, i);
        }
        return Math.max(take, notTake);
    }
    public int memoized(int[] nums, int n, int i, int pi, int[][] dp) {
        // recusion with memoization
        // TC = O(n*n), SC = O(n*n) + O(n) // dp array + recursion stack space
        if(i == n) return 0;
        if(dp[i][pi+1] != -1) return dp[i][pi+1];

        int take = 0 + memoized(nums, n, i+1, pi, dp);
        int notTake = 0;
        if(pi == -1 || nums[i] > nums[pi]) {
            notTake = 1 + memoized(nums, n, i+1, i, dp);
        }
        return dp[i][pi+1] = Math.max(take, notTake);
    }

    public int tabulation(int[] nums) {
        int n = nums.length;
        int[][] dp = new int[n+1][n+1];

        for(int i = n-1; i >= 0; i--) {
            for(int prev = i-1; prev >= -1; prev--) {
                int notTake = 0 + dp[i+1][prev+1];
                int take = 0;
                if(prev == -1 || nums[i] > nums[prev]) {
                    take = 1 + dp[i+1][i+1];
                }
                dp[i][prev+1] = Math.max(take, notTake);
            }
        }
        return dp[0][0];
    }

    public int spaceOptimized(int[] nums) {
        int n = nums.length;

        int next[] = new int[n+1];
        int cur[] = new int[n+1];

        for(int i = n-1; i >= 0; i--) {
            for(int prev = i-1; prev >= -1; prev--) {
                int notTake = 0 + next[prev+1];
                int take = 0;
                if(prev == -1 || nums[i] > nums[prev]) {
                    take = 1 + next[i+1];
                }
                cur[prev+1] = Math.max(take, notTake);
            }
            next = cur.clone();
        }
        return cur[0];
    }

    public int mostOptimized(int[] nums) {
        // this is the most optimized version to find LIS
        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        int maxi = 1;
        for(int i = 0; i < n; i++) {
            for(int prev = 0; prev < i; prev++) {
                if(nums[prev] < nums[i]) {
                    dp[i] = Math.max(1 + dp[prev], dp[i]);
                }
            }
        }
        for(int lis: dp) {
            maxi = Math.max(lis, maxi);
        }
        return maxi;
    }
    public void printLIS(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        int[] hash = new int[n];

        for(int i = 0; i < n; i++) {
            hash[i] = i;
            for(int prev = 0; prev < i; prev++) {
                if(nums[i] > nums[prev] && 1 + dp[prev] > dp[i]) {
                    dp[i] = 1 + dp[prev];
                    hash[i] = prev;
                }
            }
        }
        int lastIndex = -1;
        int ans = -1;
        for(int i = 0; i < n; i++) {
            if(dp[i] > ans) {
                ans = dp[i];
                lastIndex = i;
            }
        }
        ArrayList<Integer> temp = new ArrayList<>();
        temp.add(nums[lastIndex]);

        while(hash[lastIndex] != lastIndex) {
            lastIndex = hash[lastIndex];
            temp.add(nums[lastIndex]);
        }
        Collections.sort(temp);
        System.out.println(temp);
    }
}