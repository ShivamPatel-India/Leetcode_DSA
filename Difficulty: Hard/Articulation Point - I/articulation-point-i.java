class Solution {
    private void DFS(int node, int parent, ArrayList<ArrayList<Integer>> adj, int[] disc, int[] low, boolean[] vis, int timer, boolean[] isArticulationPoint) {
        vis[node] = true;
        disc[node] = timer;
        low[node] = timer;
        int child = 0;
        for(int neighbour: adj.get(node)) {
            if(neighbour == parent) continue;
            if(vis[neighbour]) {
                low[node] = Math.min(low[node], disc[neighbour]);
            } else {
                child += 1;
                timer += 1;
                DFS(neighbour, node, adj, disc, low, vis, timer, isArticulationPoint);
                if(disc[node] <= low[neighbour] && parent != -1) {
                    isArticulationPoint[node] = true;
                }
                low[node] = Math.min(low[node], low[neighbour]);
            }
        }
        if(child > 1 && parent == -1) isArticulationPoint[node] = true;
        
    }
    public ArrayList<Integer> articulationPoints(int V,
                                                 ArrayList<ArrayList<Integer>> adj) {
        ArrayList<Integer> ans = new ArrayList<>();
        boolean[] vis = new boolean[V];
        boolean[] isArticulationPoint = new boolean[V];
        int[] disc = new int[V];
        int[] low = new int[V];
        int timer = 0;
        DFS(0, -1, adj, disc, low, vis, timer, isArticulationPoint);
        for(int i = 0; i < V; i++) {
            if(isArticulationPoint[i] == true) ans.add(i);
        }
        if(ans.size() == 0) ans.add(-1);
        return ans;
        
    }
}