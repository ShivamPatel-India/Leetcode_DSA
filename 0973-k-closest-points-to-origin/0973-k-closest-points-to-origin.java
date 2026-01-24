class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> minHeap = new PriorityQueue<>(
            Comparator.comparing(a -> a[0])
        );

        for(int[] point: points) {
            int dist = point[0] * point[0] + point[1] * point[1];
            minHeap.offer(new int[]{dist, point[0], point[1]});
        }

        int[][] res = new int[k][2];
        for(int i = 0; i < k; i++) {
            int[] point = minHeap.poll();
            res[i] = new int[]{point[1], point[2]};
        }
        return res;
    }
}