class Solution {
    private void DFS(int node, int parent, List<List<Integer>> adj, char[] labels, int[] freq, int[] ans) {
        int idx = labels[node]-'a';
        int before = freq[idx];
        freq[idx]++;

        for(int child: adj.get(node)) {
            if(child == parent) continue;
            DFS(child, node, adj, labels, freq, ans);
        }
        int after = freq[idx];
        ans[node] = after-before;
    }
    public int[] countSubTrees(int n, int[][] edges, String labels) {
        List<List<Integer>> adj = new ArrayList<>();
        for(int i = 0; i < n; i++) adj.add(new ArrayList<>());
        for(int[] e: edges) {
            adj.get(e[0]).add(e[1]);
            adj.get(e[1]).add(e[0]);
        }
        int[] ans = new int[n];
        int[] freq = new int[26];
        DFS(0, -1, adj, labels.toCharArray(), freq, ans);
        return ans;
    }
}