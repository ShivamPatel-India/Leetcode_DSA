class Solution {
    private void DFS(int node, int parent, List<List<Integer>> adj, boolean[] vis, int[] disc, int[] low, int timer, List<List<Integer>> ans) {
        vis[node] = true;
        disc[node] = timer;
        low[node] = timer;

        for(int neigh: adj.get(node)) {
            if(neigh == parent) continue;
            if(vis[neigh]) {
                low[node] = Math.min(low[node], disc[neigh]);
            } else {
                timer++;
                DFS(neigh, node, adj, vis, disc, low, timer, ans);
                if(disc[node] < low[neigh]) ans.add(Arrays.asList(node, neigh));
                low[node] = Math.min(low[node], low[neigh]);
            }
        }
    }
    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        List<List<Integer>> adj = new ArrayList<>();
        for(int i = 0; i < n; i++) adj.add(new ArrayList<>());
        for(List<Integer> c: connections) {
            adj.get(c.get(0)).add(c.get(1));
            adj.get(c.get(1)).add(c.get(0));
        }

        boolean[] vis = new boolean[n];
        int[] disc = new int[n];
        int[] low = new int[n];
        List<List<Integer>> ans = new ArrayList<>();
        int timer = 0;
        DFS(0, -1, adj, vis, disc, low, timer, ans);
        return ans;
    }
}