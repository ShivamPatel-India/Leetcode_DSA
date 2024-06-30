class Solution {
     public int findMax(int[] piles) {
        int max = Integer.MIN_VALUE;
        int n = piles.length;
        for(int i = 0; i<n; i++) {
            max = Math.max(max, piles[i]);
        }
        return max;
    }

    public int calculateTotalHours(int[] piles, int rate) {
        int totalHours = 0;
        int n = piles.length;

        for(int i = 0; i<n; i++) {
            totalHours += Math.ceil((double)(piles[i])/(double)(rate));
        }
        return totalHours;
    }

    public int minEatingSpeed(int[] piles, int h) {
        int low = 1;
        int high = findMax(piles);

        while(low <= high) {
            int mid = low + (high - low) / 2;

            int totalHours = calculateTotalHours(piles, mid);

            if(totalHours<=h) high = mid-1;
            else low = mid+1;
        }
        return low;
    }
}