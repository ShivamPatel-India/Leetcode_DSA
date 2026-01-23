import java.util.*;
class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        for(int s: stones) {
            maxHeap.offer(s);
        }

        while(maxHeap.size() > 1) {
            int first = maxHeap.poll();
            int second = maxHeap.poll();
            if(first > second) maxHeap.offer(first-second);
        }
        maxHeap.offer(0);
        return maxHeap.peek();
    }
}