import java.util.*;

class Solution {
    public int[] getOrder(int[][] tasks) {
        int n = tasks.length;
        Integer[] indicies = new Integer[n];
        for(int i = 0; i < n; i++) {
            indicies[i] = i;
        }

        Arrays.sort(indicies, (a,b) -> 
            tasks[a][0] != tasks[b][0] ? tasks[a][0] - tasks[b][0] : a-b
        );

        PriorityQueue<Integer> minHeap = new PriorityQueue<>((a,b) -> 
            tasks[a][1] != tasks[b][1] ? tasks[a][1] - tasks[b][1] : a - b
        );

        int[] result = new int[n];
        long time = 0;
        int i = 0, resIndex = 0;
        while(!minHeap.isEmpty() || i < n) {
            while(i < n && tasks[indicies[i]][0] <= time) {
                minHeap.offer(indicies[i]);
                i++;
            }

            if(minHeap.isEmpty()) {
                time = tasks[indicies[i]][0];
            } else {
                int nextIndex = minHeap.poll();
                time += tasks[nextIndex][1];
                result[resIndex++] = nextIndex;
            }
        }
        return result;
    }
}