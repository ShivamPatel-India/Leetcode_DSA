class Solution {
    public long maxScore(int[] nums1, int[] nums2, int k) {
        int n = nums1.length;
        int[][] pairs = new int[n][2];
        for(int i = 0; i < n; i++) {
            pairs[i][0] = nums1[i];
            pairs[i][1] = nums2[i];
        }

        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        Arrays.sort(pairs, (a,b) -> Integer.compare(b[1], a[1]));

        long n1Sum = 0, res = 0;
        for(int[] pair : pairs) {
            n1Sum += pair[0];
            minHeap.offer(pair[0]);

            if(minHeap.size() > k) {
                n1Sum -= minHeap.poll();
            }

            if(minHeap.size() == k) {
                res = Math.max(res, n1Sum * pair[1]);
            }
        }
        return res;
    }
}