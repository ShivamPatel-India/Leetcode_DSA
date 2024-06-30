class Solution {

    public boolean checkPossibility(int[] v, int day, int m, int k, int n){
        int bloomedFlowers = 0;
        int bouquetMade = 0;

        for(int i=0; i<n; i++) {
            if(v[i]<=day) {
                bloomedFlowers++;
            } else {
                bouquetMade += bloomedFlowers/k;
                bloomedFlowers = 0;
            }
        }
        bouquetMade += bloomedFlowers/k;
        return bouquetMade >= m;
    }
    public int minDays(int[] bloomDay, int m, int k) {
        int n = bloomDay.length;

        if((long)m*k > n) return -1;
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for(int i=0; i<n; i++) {
            min = Math.min(min, bloomDay[i]);
            max = Math.max(max, bloomDay[i]);
        }

        int low = min;
        int high = max;

        while(low <= high) {
            int mid = low + (high - low)/2;

            boolean isPossible = checkPossibility(bloomDay, mid, m, k, n);

            if(isPossible) high = mid-1;
            else low = mid+1;
        }
        return low;
    }
}