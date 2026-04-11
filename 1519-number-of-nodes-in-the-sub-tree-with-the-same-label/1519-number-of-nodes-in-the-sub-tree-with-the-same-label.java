class Solution {
    private int[] DFS(int node, int parent, List<List<Integer>> adj, int[] ans, char[] labels) {
        int[] freq = new int[26];
        freq[labels[node]-'a']++;

        for(int child: adj.get(node)) {
            if(child == parent) continue;
            int[] childFreq = DFS(child, node, adj, ans, labels);
            for(int i = 0; i < 26; i++) freq[i] += childFreq[i];
        }
        ans[node] = freq[labels[node]-'a'];
        return freq;
    }
    public int[] countSubTrees(int n, int[][] edges, String labels) {
        List<List<Integer>> adj = new ArrayList<>();
        for(int i = 0; i < n; i++) adj.add(new ArrayList<>());
        for(int[] e: edges) {
            adj.get(e[0]).add(e[1]);
            adj.get(e[1]).add(e[0]);
        }
        int[] ans = new int[n];
        DFS(0, -1, adj, ans, labels.toCharArray());
        return ans;
    }
}