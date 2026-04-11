class Solution {
    public List<List<Integer>> findWinners(int[][] matches) {
        Map<Integer, Integer> lossCount = new HashMap<>();

        for(int[] match: matches) {
            int winner = match[0];
            int loser  = match[1];
            // ensure winner exists in map with 0 losses if not already present
            lossCount.putIfAbsent(winner, 0);
            lossCount.put(loser, lossCount.getOrDefault(loser, 0) + 1);
        }

        List<Integer> noLoss   = new ArrayList<>();
        List<Integer> oneLoss  = new ArrayList<>();

        for(Map.Entry<Integer, Integer> entry: lossCount.entrySet()) {
            if(entry.getValue() == 0) noLoss.add(entry.getKey());
            if(entry.getValue() == 1) oneLoss.add(entry.getKey());
        }

        Collections.sort(noLoss);
        Collections.sort(oneLoss);

        List<List<Integer>> ans = new ArrayList<>();
        ans.add(noLoss);
        ans.add(oneLoss);
        return ans;
    }
}