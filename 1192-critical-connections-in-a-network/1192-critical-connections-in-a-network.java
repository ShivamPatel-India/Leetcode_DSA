class Solution {
    private void DFS(int node, int parent, List<List<Integer>> adj, List<List<Integer>> bridges, int count, int[] disc, int[] low, boolean[] vis) {
        disc[node] = count;
        low[node] = count;
        vis[node] = true;

        for(int neighbour: adj.get(node)) {
            if(neighbour == parent) continue;
            if(vis[neighbour]) low[node] = Math.min(low[node], low[neighbour]);
            else {
                count += 1;
                DFS(neighbour, node, adj, bridges, count, disc, low, vis);
                low[node] = Math.min(low[node], low[neighbour]);
                if(disc[node] < low[neighbour]) {
                    bridges.add(new ArrayList<>(Arrays.asList(node, neighbour)));
                }
            }
        }
    }
    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        List<List<Integer>> adj = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        for(List<Integer> connection: connections) {
            adj.get(connection.get(0)).add(connection.get(1));
            adj.get(connection.get(1)).add(connection.get(0));
        }

        List<List<Integer>> bridges = new ArrayList<>();
        int count = 0;
        int[] discover = new int[n];
        int[] low = new int[n];
        boolean[] vis = new boolean[n];
        DFS(0, -1, adj, bridges, count, discover, low, vis);
        return bridges;
    }
}