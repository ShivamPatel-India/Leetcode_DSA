class Solution {
    public int maxPerformance(int n, int[] speed, int[] efficiency, int k) {
        final int MOD = 1_000_000_007;
        int[][] engineers = new int[n][2];
        for(int i = 0; i < n; i++) {
            engineers[i] = new int[]{efficiency[i], speed[i]};
        }

        Arrays.sort(engineers, (a,b) -> b[0] - a[0]);
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        long res = 0, speedSum = 0;
        for(int[] engineer: engineers) {
            if(minHeap.size() == k) {
                speedSum -= minHeap.poll();
            }
            minHeap.offer(engineer[1]);
            speedSum += engineer[1];
            res = Math.max(res, speedSum * engineer[0]);
        }
        return (int) (res % MOD);
    }
}