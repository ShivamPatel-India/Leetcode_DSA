class Solution {
    private void DFS(int node, int parent, List<List<Integer>> adj,
                     int[] ans, char[] labels, int[] count) {
        int idx = labels[node] - 'a';

        int before = count[idx]; // snapshot before exploring subtree
        count[idx]++;            // count myself

        for(int child: adj.get(node)) {
            if(child == parent) continue;
            DFS(child, node, adj, ans, labels, count);
        }

        int after = count[idx];      // snapshot after exploring subtree
        ans[node] = after - before;  // only my subtree's contribution
    }

    public int[] countSubTrees(int n, int[][] edges, String labels) {
        List<List<Integer>> adj = new ArrayList<>();
        for(int i = 0; i < n; i++) adj.add(new ArrayList<>());
        for(int[] e: edges) {
            adj.get(e[0]).add(e[1]);
            adj.get(e[1]).add(e[0]);
        }

        int[] ans = new int[n];
        int[] count = new int[26];
        DFS(0, -1, adj, ans, labels.toCharArray(), count);
        return ans;
    }
}