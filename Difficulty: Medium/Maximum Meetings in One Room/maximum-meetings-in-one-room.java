class Solution {
    public static ArrayList<Integer> maxMeetings(int N, int[] S, int[] F) {
        List<int[]> meets = new ArrayList<>();
        for(int i = 0; i < N; i++) {
            meets.add(new int[]{S[i], F[i], i+1});
        }
        
        Collections.sort(meets, (a, b) -> a[1] - b[1]);
        ArrayList<Integer> ans = new ArrayList<>();
        ans.add(meets.get(0)[2]);
        int prevEnd = meets.get(0)[1];
        for(int i = 1; i < N; i++) {
            if(meets.get(i)[0] > prevEnd) {
                ans.add(meets.get(i)[2]);
                prevEnd = meets.get(i)[1];
            }
        }
        Collections.sort(ans);
        return ans;
    }
}
