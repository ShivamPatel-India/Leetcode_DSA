class Solution {
    public double mincostToHireWorkers(int[] quality, int[] wage, int k) {
        int n = quality.length;
        double res = Double.MAX_VALUE;
        double totalQuality = 0;

        double[][] workers = new double[n][2];
        for(int i = 0; i < n; i++) {
            // [rate, quality]
            workers[i] = new double[]{(double) wage[i] / quality[i], (double) quality[i]};
        }
        Arrays.sort(workers, Comparator.comparingDouble(a -> a[0]));
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

        for(double[] worker: workers) {
            double ratio = worker[0];
            int q = (int) worker[1];

            maxHeap.offer(q);
            totalQuality += q;

            if(maxHeap.size() > k) totalQuality -= maxHeap.poll();
            if(maxHeap.size() == k) res = Math.min(res, totalQuality * ratio);
        }
        return res;
    }
}