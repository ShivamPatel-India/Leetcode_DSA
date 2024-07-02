class Solution {
    public int calculateDays(int[] weights, int capacity, int n) {
        int load = 0;
        int days = 0;
        for(int i = 0 ; i<n; i++) {
            load += weights[i];
            if(load > capacity) {
                days++;
                load = weights[i];
            }
        }
        return days;
    }
    public int shipWithinDays(int[] weights, int days) {
        int totalWeight = 0;
        int maxWeight = Integer.MIN_VALUE;

        int n = weights.length;

        for(int i = 0; i<n; i++) {
            totalWeight += weights[i];
            maxWeight = Math.max(maxWeight, weights[i]);
        }

        int low = maxWeight;
        int high = totalWeight;
        int minCap = Integer.MAX_VALUE;

        while(low <= high) {
            int mid = low + (high - low) / 2;

            int d = calculateDays(weights, mid, n);

            if(d < days) {
                high = mid - 1;
                minCap = Math.min(minCap, mid);
            } else low = mid + 1;

        }
        return minCap;

    }
}