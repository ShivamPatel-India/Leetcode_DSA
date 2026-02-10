class Solution {
    public int[] fullBloomFlowers(int[][] flowers, int[] people) {
        int m = people.length;
        int[] res = new int[m];

        List<int[]> sortedPeople = new ArrayList<>();
        for(int i = 0; i < m; i++) {
            sortedPeople.add(new int[]{people[i], i});
        }
        sortedPeople.sort(Comparator.comparingInt(a -> a[0]));
        PriorityQueue<Integer> startHeap = new PriorityQueue<>();
        PriorityQueue<Integer> endHeap = new PriorityQueue<>();

        for(int[] f: flowers) {
            startHeap.offer(f[0]);
            endHeap.offer(f[1]);
        }

        int count = 0;
        for(int[] person: sortedPeople) {
            int p = person[0], index = person[1];
            while(!startHeap.isEmpty() && startHeap.peek() <= p) {
                startHeap.poll();
                count++;
            }
             while (!endHeap.isEmpty() && endHeap.peek() < p) {
                endHeap.poll();
                count--;
            }

            res[index] = count;
        }
        return res;
    }
}