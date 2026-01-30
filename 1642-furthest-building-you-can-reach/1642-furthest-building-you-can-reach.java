class Solution {
    public int furthestBuilding(int[] heights, int bricks, int ladders) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        
        for(int i = 0; i < heights.length - 1; i++) {
            int diff = heights[i+1] - heights[i];
            if(diff <= 0) {
                continue;
            }
            maxHeap.offer(diff);
            bricks -= diff;
            if(bricks < 0) {
                if(ladders == 0) return i;
                ladders--;
                bricks += maxHeap.poll();
            }
        }
        return heights.length - 1;
    }
}