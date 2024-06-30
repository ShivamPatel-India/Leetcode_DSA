class Solution {
    public boolean checkPossibility(int[] bloomDay, int m, int k, int day) {
        int n = bloomDay.length;
        int bloomedFlowers = 0;
        int bouquetMade = 0;

        for(int i = 0; i < n; i++) {
            if(bloomDay[i] <= day) {
                bloomedFlowers++;
            } else {
                bouquetMade += bloomedFlowers / k;
                bloomedFlowers = 0;
            }
        }
        bouquetMade += bloomedFlowers / k;
        return bouquetMade >= m;
    }
    public int minDays(int[] bloomDay, int m, int k) {
        int flowers = bloomDay.length;

        if((long)m*k > flowers) return -1;

        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < flowers; i++) {
            min = Math.min(min, bloomDay[i]);
            max = Math.max(max, bloomDay[i]);
        }

        int low = min;
        int high = max;

        while(low <= high) {
            int mid = low + (high - low) / 2;

            boolean isPossible = checkPossibility(bloomDay, m, k, mid);

            if(isPossible == true) high = mid - 1;
            else low = mid + 1;
        }
        return low;
    }
}