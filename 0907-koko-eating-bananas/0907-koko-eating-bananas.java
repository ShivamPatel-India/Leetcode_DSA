class Solution {
    public int findMax(int[] piles) {
        int ans = Integer.MIN_VALUE;
        int n = piles.length;
        for(int i = 0; i < n; i++) {
            ans = Math.max(piles[i], ans);
        }
        return ans;
    }
    public int calculateH(int rate, int[] piles, int h) {
        int ans = 0;
        int n = piles.length;
        for(int i = 0; i < n; i++) {
            ans += Math.ceil( (double)(piles[i]) / (double)(rate) );
        }
        return ans;
    }
    public int minEatingSpeed(int[] piles, int h) {
        int low = 1;
        int high = findMax(piles);

        while(low <= high) {
            int mid = low + (high - low) / 2;

            int totalH = calculateH(mid, piles, h);

            if(totalH <= h) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }
}