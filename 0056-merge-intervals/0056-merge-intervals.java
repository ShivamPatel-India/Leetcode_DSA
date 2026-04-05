class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        List<int[]> merged = new ArrayList<>();
        for(int[] interval: intervals) {
            if(merged.isEmpty()) {
                merged.add(interval);
            } else if(merged.get(merged.size()-1)[1] >= interval[0]) {
                merged.get(merged.size()-1)[1] = Math.max(interval[1], merged.get(merged.size()-1)[1]);
            } else merged.add(interval);
        }
        return merged.toArray(new int[merged.size()][]);
    }
}