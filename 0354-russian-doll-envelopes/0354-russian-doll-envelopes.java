class Solution {
    public int maxEnvelopes(int[][] envelopes) {
        int n = envelopes.length;
        // sort the arr: width -> ASC, if width is same, height -> DESC
        Arrays.sort(envelopes, (a,b) -> a[0]==b[0] ? b[1]-a[1] : a[0]-b[0]);
        
        // now we can apply the LIS using patience sorting on height dimension
        List<Integer> sorted = new ArrayList<>();
        sorted.add(envelopes[0][1]);
        for(int i = 1; i < n; i++) {
            int h = envelopes[i][1];
            if(h > sorted.get(sorted.size()-1)) {
                sorted.add(h);
            } else {
                int index = lowerBound(sorted, h);
                sorted.set(index, h);
            }
        }
        return sorted.size();
    }
    private int lowerBound(List<Integer> sorted, int target) {
        int left = 0;
        int right = sorted.size();
        int result = sorted.size();

        while(left < right) {
            int mid = left + (right - left) / 2;
            if(sorted.get(mid) >= target) {
                result = mid;
                right = mid;
            }
            else left = mid + 1;
        }
        return result;
    }
}