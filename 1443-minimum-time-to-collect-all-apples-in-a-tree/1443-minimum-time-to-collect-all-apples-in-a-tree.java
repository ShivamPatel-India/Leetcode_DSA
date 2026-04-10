class Solution {
    private int DFS(int node, int parent, List<List<Integer>> adj, List<Boolean> hasApple) {
        int time = 0;

        for(int child: adj.get(node)) {
            // to avoid going back up
            if(child == parent) continue;

            int timeFromChild = DFS(child, node, adj, hasApple);

            if(hasApple.get(child) || timeFromChild > 0) {
                time += 2 + timeFromChild;
            }
        }
        return time;
    }
    public int minTime(int n, int[][] edges, List<Boolean> hasApple) {
        List<List<Integer>> adj = new ArrayList<>();
        for(int i = 0; i < n; i++) adj.add(new ArrayList<>());

        for(int[] e: edges) {
            adj.get(e[0]).add(e[1]);
            adj.get(e[1]).add(e[0]);
        }

        return DFS(0, -1, adj, hasApple);
    }
}