class Solution {
    public double mincostToHireWorkers(int[] quality, int[] wage, int k) {
        int n = quality.length;
        double[][] workers = new double[n][2];
        double totalQuality = 0;
        double res = Double.MAX_VALUE;

        for(int i = 0; i < n; i++) {
            workers[i] = new double[]{(double) wage[i] / quality[i], (double) quality[i]};
        }
        // sorting by the rate inorder to fix the smallest eatte possible
        Arrays.sort(workers, Comparator.comparingDouble(a -> a[0]));

        // maxHeap to keep track of k smallest amouunt of qualities
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

        for(double[] worker: workers) {
            double rate = worker[0];
            int q = (int) worker[1];

            totalQuality += q;
            maxHeap.offer(q);

            if(maxHeap.size() > k) totalQuality -= maxHeap.poll();
            if(maxHeap.size() == k) res = Math.min(res, rate * totalQuality);
        }
        return res;
    }
}