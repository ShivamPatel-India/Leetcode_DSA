class Solution {

    private int calculateDaysRequired(int[] weights, int capacity) {
        int days = 0;
        int load = 0;

        for(int i=0; i<weights.length; i++) {
            load += weights[i];
            if(load > capacity) {
                days++;
                load = weights[i];
            } 
        }
        return days;
    }
    public int shipWithinDays(int[] weights, int days) {
        int n = weights.length;
        
        int low = Integer.MIN_VALUE;
        int high = 0;
        for (int i=0; i<n; i++) {
            high += weights[i];
            low = Math.max(low, weights[i]);
        }

        while(low<=high) {
            int mid = low + (high-low)/2;

            int daysRequired = calculateDaysRequired(weights, mid);

            if(daysRequired < days) high = mid-1;
            else low = mid+1;
        }
        return low;
    }
}