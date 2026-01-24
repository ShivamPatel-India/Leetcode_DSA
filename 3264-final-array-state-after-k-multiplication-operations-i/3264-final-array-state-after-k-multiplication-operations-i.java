class Solution {
    public int[] getFinalState(int[] nums, int k, int multiplier) {
        int n = nums.length;
        int[] res = Arrays.copyOf(nums, n);
        PriorityQueue<Integer> minHeap = new PriorityQueue<>((a,b) -> {
            if(res[a] != res[b]) return Integer.compare(res[a], res[b]);
            return Integer.compare(a, b);
        });

        for(int i = 0 ; i < n; i++) minHeap.offer(i);

        for(int i = 0; i < k; i++) {
            int ind = minHeap.poll();
            res[ind] *= multiplier;
            minHeap.offer(ind);
        }
        return res;
    }
}