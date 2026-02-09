class MedianFinder {
    private PriorityQueue<Integer> smallHeap;
    private PriorityQueue<Integer> largeHeap;

    public MedianFinder() {
        // same as smallHeap = new PriorityQueue<>(Collections.reverseOrder);
        smallHeap = new PriorityQueue<>((a,b) -> b - a);

        largeHeap = new PriorityQueue<>((a,b) -> a - b); 
    }
    
    public void addNum(int num) {
        // by default add the num to smallHeap
        smallHeap.offer(num);

        // if smallHeap becomes bigger than largeHeap or the largest element from smallHeap is bigger that smallest element of laargeHeap
        if(
            smallHeap.size() - largeHeap.size() > 1 ||
            !largeHeap.isEmpty() && largeHeap.peek() < smallHeap.peek()
        ) {
            largeHeap.offer(smallHeap.poll());
        }

        // when largeHeap becomes larger than smallHeap
        if(largeHeap.size() - smallHeap.size() > 1) {
            smallHeap.offer(largeHeap.poll());
        }
    }
    
    public double findMedian() {
        if(smallHeap.size() == largeHeap.size()) {
            return (double) (smallHeap.peek() + largeHeap.peek()) / 2;
        } else if(smallHeap.size() > largeHeap.size()) {
            return (double) smallHeap.peek();
        } else {
            return (double) largeHeap.peek();
        }
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */