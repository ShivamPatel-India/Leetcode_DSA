class SeatManager {
    PriorityQueue<Integer> minHeap = new PriorityQueue<>();
    public SeatManager(int n) {
        for(int i = 1; i <= n; i++) {
            minHeap.offer(i);
        }
    }
    
    public int reserve() {
        return minHeap.poll();
    }
    
    public void unreserve(int seatNumber) {
        minHeap.offer(seatNumber);
    }
}

/**
 * Your SeatManager object will be instantiated and called as such:
 * SeatManager obj = new SeatManager(n);
 * int param_1 = obj.reserve();
 * obj.unreserve(seatNumber);
 */