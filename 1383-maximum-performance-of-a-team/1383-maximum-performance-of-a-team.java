class Solution {
    public int maxPerformance(int n, int[] speed, int[] efficiency, int k) {
        final int MOD = 1_000_000_007;
        // engineers[][] = [efficiency, speed]
        int[][] ers = new int[n][2];
        for(int i = 0; i < n; i++) {
            ers[i][0] = efficiency[i];
            ers[i][1] = speed[i];
        }

        Arrays.sort(ers, (a,b) -> b[0] - a[0]);
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        
        long speedSum = 0, res = 0;
        for(int i = 0; i < n; i++) {
            if(minHeap.size() == k) {
                speedSum -= (long) minHeap.poll();
            }
            minHeap.offer(ers[i][1]);
            speedSum += ers[i][1];
            res = Math.max(res, ers[i][0] * speedSum);
        }
        return (int) (res % MOD);
    }
}