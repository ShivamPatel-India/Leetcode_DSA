class Solution {
    public int constrainedSubsetSum(int[] nums, int k) {
        int res = nums[0];
        // max_sum, index
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a, b) -> b[0]-a[0]);
        maxHeap.offer(new int[]{nums[0], 0});
        for(int i = 1; i < nums.length; i++) {
            while(i - maxHeap.peek()[1] > k) maxHeap.poll();
            int curMax = Math.max(nums[i], nums[i] + maxHeap.peek()[0]);
            res = Math.max(res, curMax);
            maxHeap.offer(new int[]{curMax, i});
        }
        return res;
    }
}