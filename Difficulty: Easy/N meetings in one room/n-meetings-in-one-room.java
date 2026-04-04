class Solution {
    // Function to find the maximum number of meetings that can
    // be performed in a meeting room.
    public int maxMeetings(int start[], int end[]) {
        List<int[]> meet = new ArrayList<>();
        int n = start.length;
        for(int i = 0; i < n; i++) {
            // 1-based indexing 
            meet.add(new int[]{start[i], end[i], i+1});
        }
        
        Collections.sort(meet, (a, b) -> a[1] - b[1]);
        
        List<Integer> result = new ArrayList<>();
        int lastEnd = -1;
        
        for(int[] m: meet) {
            if(m[0] > lastEnd) {
                lastEnd = m[1];
                result.add(m[2]);
            }
        }
        return result.size();
    }
}
