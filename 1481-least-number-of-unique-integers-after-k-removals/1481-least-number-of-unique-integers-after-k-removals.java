class Solution {
    public int findLeastNumOfUniqueInts(int[] arr, int k) {
        Map<Integer, Integer> freqMap = new HashMap<>();
        for(int num: arr) {
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
        }

        PriorityQueue<Integer> minHeap = new PriorityQueue<>(freqMap.values());

        int res = minHeap.size();
        while(k > 0 && !minHeap.isEmpty()) {
            int freq = minHeap.poll();
            if(freq <= k) {
                k -= freq;
                res--;
            }
        }
        return res;
    }
}