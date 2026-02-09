class Solution {
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a,b) -> a[0]-b[0]);
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a,b) -> b - a);

        for(int i = 0; i < capital.length; i++) {
            minHeap.offer(new int[]{capital[i], profits[i]});
        }

        for(int i = 0; i < k; i++) {
            while(!minHeap.isEmpty() && minHeap.peek()[0] <= w) {
                maxHeap.offer(minHeap.poll()[1]);
            }
            if(maxHeap.isEmpty()) break;
            w += maxHeap.poll();
        }
        return w;
    }
}