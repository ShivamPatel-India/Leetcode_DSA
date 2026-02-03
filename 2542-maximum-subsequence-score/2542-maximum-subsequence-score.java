class Solution {
    public long maxScore(int[] nums1, int[] nums2, int k) {
        int n = nums1.length;
        int[][] pairs = new int[n][2];

        for(int i = 0; i < n; i++) {
            pairs[i][0] = nums1[i];
            pairs[i][1] = nums2[i];
        }

        Arrays.sort(pairs, (a,b) -> Integer.compare(b[1], a[1]));
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        
        long kSum = 0;

        for(int i = 0; i <= k-1; i++) {
            minHeap.offer(pairs[i][0]);
            kSum += pairs[i][0];
        }

        long result = kSum * pairs[k-1][1];
        for(int i = k; i < n; i++) {
            kSum += pairs[i][0] - minHeap.poll();
            minHeap.offer(pairs[i][0]);
            result = Math.max(result, kSum * pairs[i][1]);
        }
        return result;
    }
}