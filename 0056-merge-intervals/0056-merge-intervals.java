class Solution {
    public int[][] merge(int[][] intervals) {
        // sort by starting time
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

        List<int[]> merged = new ArrayList<>();
        for(int[] interval: intervals) {
            if(merged.isEmpty() || merged.get(merged.size()-1)[1] < interval[0]) {
                merged.add(interval);
            } else {
                merged.get(merged.size()-1)[1] = Math.max(interval[1], merged.get(merged.size()-1)[1]);
            }
        }
        return merged.toArray(new int[merged.size()][]);
    }
}