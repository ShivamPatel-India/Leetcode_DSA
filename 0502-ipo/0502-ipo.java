class Solution {
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        PriorityQueue<int[]> minCapital = new PriorityQueue<>((a,b) -> a[0]-b[0]);
        PriorityQueue<Integer> maxProfit = new PriorityQueue<>((a,b) -> b-a);

        // put all the projects in minHeap sorted by capital 
        for(int i = 0; i < capital.length; i++) minCapital.offer(new int[]{capital[i],profits[i]});
        
        // selecting k projects
        for(int i = 0; i < k; i++) {
            // selecting the project with capital <= w
            while(!minCapital.isEmpty() && minCapital.peek()[0] <= w) 
                maxProfit.offer(minCapital.poll()[1]);
            if(!maxProfit.isEmpty()) w += maxProfit.poll();
            else break;
        }
        return w;
    }
}