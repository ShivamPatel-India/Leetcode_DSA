import java.util.*;

class Solution {
    public long pickGifts(int[] gifts, int k) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());    

        for(int gift: gifts) maxHeap.offer(gift);
        while(k > 0) {
            int maxElement = maxHeap.poll();
            maxHeap.offer((int)Math.floor(Math.sqrt(maxElement)));
            k--;
        }

        long sum = 0;
        while(maxHeap.size() > 0) {
            sum += maxHeap.poll();
        }    
        return sum;
    }
}