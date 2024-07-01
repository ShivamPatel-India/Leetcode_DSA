class Solution {
    public boolean checkIfPossible(int[] bloomDay, int days, int m, int k, int n) {
        int bloomedFlowers = 0;
        int bouquetMade = 0;

        for(int i = 0; i < n; i++) {
            if(bloomDay[i] <= days) {
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
        int n = bloomDay.length;

        if((long)m*k > n) return -1;

        int low = Integer.MAX_VALUE;
        int high = Integer.MIN_VALUE;

        for(int i = 0; i < n; i++) {
            low = Math.min(bloomDay[i], low);
            high = Math.max(bloomDay[i], high);
        }

        while(low <= high) {
            int mid = low + (high - low) / 2;

            boolean isPossible = checkIfPossible(bloomDay, mid, m, k, n);

            if(isPossible == true) high = mid - 1;
            else low = mid + 1;
        }
        return low;
    }
}