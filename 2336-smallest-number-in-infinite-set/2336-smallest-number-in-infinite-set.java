class SmallestInfiniteSet {
    int smallest;
    PriorityQueue<Integer> pq;
    Set<Integer> set;

    public SmallestInfiniteSet() {
        smallest = 1;
        pq = new PriorityQueue<>();
        set = new HashSet<>();
    }
    
    public int popSmallest() {
        if(!pq.isEmpty()) {
            set.remove(pq.peek());
            return pq.poll();
        } 
        int ans = smallest;
        smallest++;
        return ans;
    }
    
    public void addBack(int num) {
        if(num < smallest) {
            if(!set.contains(num)) {
                pq.add(num);
                set.add(num);
            }
        } 
    }
}

/**
 * Your SmallestInfiniteSet object will be instantiated and called as such:
 * SmallestInfiniteSet obj = new SmallestInfiniteSet();
 * int param_1 = obj.popSmallest();
 * obj.addBack(num);
 */