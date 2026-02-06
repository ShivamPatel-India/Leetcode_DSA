class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        // sort the trips arrays based on teh starting point in ascending order
        // trips[numOfPass, starting point, ending point]
        Arrays.sort(trips, (a, b) -> a[1] - b[1]);

        // minHeap containg previous records: <ending point, numOfPass>
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a,b) -> a[0] - b[0]);

        int curPass = 0;
        
        for(int[] t: trips) {
            while(!minHeap.isEmpty() && minHeap.peek()[0] <= t[1]) {
                curPass -= minHeap.poll()[1];
            }
            curPass += t[0];
            if(curPass > capacity) return false;
            minHeap.offer(new int[]{t[2], t[0]});
        }
        return true;
    }
}