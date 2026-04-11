class Solution {
    public List<List<Integer>> findWinners(int[][] matches) {
        int[] lossCount = new int[100001];

        for(int i = 0; i < matches.length; i++) {
            int winner = matches[i][0];
            int loser = matches[i][1];

            if(lossCount[winner] == 0) lossCount[winner] = -1;
            if(lossCount[loser] == -1) lossCount[loser] = 1;
            else lossCount[loser]++;
        }

        List<Integer> noLoss = new ArrayList<>();
        List<Integer> oneLoss = new ArrayList<>();

        for(int i = 0; i < lossCount.length; i++) {
            if(lossCount[i] == -1) noLoss.add(i);
            if(lossCount[i] == 1) oneLoss.add(i);
        }
        List<List<Integer>> ans = new ArrayList<>();
        ans.add(noLoss);
        ans.add(oneLoss);
        return ans;
    }
}