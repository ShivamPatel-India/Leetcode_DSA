import java.util.Arrays;

class Solution {
    public boolean canWePlaceBalls(int[] pos, int m, int d, int n) {
        int placedBalls = 1;
        int lastPlacedBall = pos[0];

        for(int i = 1; i<n; i++) {
            if((pos[i] - lastPlacedBall) >= d) {
                placedBalls++;
                lastPlacedBall = pos[i];
            }
            if(placedBalls >= m) return true;
        }
        return false;
    }
    public int maxDistance(int[] position, int m) {
        Arrays.sort(position);
        int n = position.length;
        int low = 1;
        int high = position[n-1] - position[0];

        int ans = Integer.MIN_VALUE;
        while(low <= high) {
            int mid = low + (high - low) / 2;

            if(canWePlaceBalls(position, m, mid, n) == true) {
                ans = Math.max(ans, mid);
                low = mid + 1;
            } else high = mid - 1;
        }
        return ans;
    }
}