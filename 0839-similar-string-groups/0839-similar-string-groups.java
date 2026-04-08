class Solution {
    private boolean areSimilar(String s1, String s2) {
        if(s1.equals(s2)) return true;
        int count = 0;
        int n = s1.length();
        for(int i = 0; i < n; i++) {
            if(s1.charAt(i) != s2.charAt(i)) count++;
            if(count > 2) return false;
        }
        return true;
    }
    private void DFS(int node, List<List<Integer>> adj, boolean[] vis) {
        vis[node] = true;
        for(int adjNode: adj.get(node)) {
            if(!vis[adjNode]) DFS(adjNode, adj, vis);
        }
    }
    public int numSimilarGroups(String[] strs) {
        int n = strs.length;
        List<List<Integer>> adj = new ArrayList<>();
        for(int i = 0; i < n; i++) adj.add(new ArrayList<>());

        for(int i = 0; i < n; i++) {
            for(int j = i + 1; j < n; j++) {
                if(areSimilar(strs[i], strs[j])) {
                    adj.get(i).add(j);
                    adj.get(j).add(i);
                }
            }
        }

        boolean[] vis = new boolean[n];
        int groupCount = 0;
        for(int i = 0; i < n; i++) {
            if(!vis[i]) {
                groupCount++;
                DFS(i, adj, vis);
            }
        }
        return groupCount;
    }
}