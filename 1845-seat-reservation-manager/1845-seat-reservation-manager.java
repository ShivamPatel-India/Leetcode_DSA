class SeatManager {
    int currentSeat;
    PriorityQueue<Integer> minHeap;
    public SeatManager(int n) {
        this.currentSeat = 0;
        minHeap = new PriorityQueue<>();
    }
    
    public int reserve() {
        if(minHeap.isEmpty()) return currentSeat += 1;
        return minHeap.poll();
    }
    
    public void unreserve(int seatNumber) {
        if(currentSeat >= seatNumber) 
        minHeap.offer(seatNumber);
    }
}

/**
 * Your SeatManager object will be instantiated and called as such:
 * SeatManager obj = new SeatManager(n);
 * int param_1 = obj.reserve();
 * obj.unreserve(seatNumber);
 */