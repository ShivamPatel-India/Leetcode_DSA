class Solution {
    private void DFS(int node, int parent, ArrayList<ArrayList<Integer>> adj, boolean[] vis, boolean[] isAP, 
    int[] disc, int[] low, int timer) {
        vis[node] = true;
        disc[node] = timer;
        low[node] = timer;
        int child = 0;
        
        for(int neigh: adj.get(node)) {
            if(neigh == parent) continue;
            if(vis[neigh]) {
                low[node] = Math.min(low[node], disc[neigh]);
            } else {
                child++;
                timer++;
                DFS(neigh, node, adj, vis, isAP, disc, low, timer);
                if(disc[node] <= low[neigh] && parent != -1) isAP[node] = true;
                low[node] = Math.min(low[node], low[neigh]);
            }
        }
        if(child > 1 && parent == -1) isAP[node] = true;

    }
    public ArrayList<Integer> articulationPoints(int V,
                                                 ArrayList<ArrayList<Integer>> adj) {
        ArrayList<Integer> ans = new ArrayList<>();
        boolean[] vis = new boolean[V];
        boolean[] isAP = new boolean[V];
        int[] disc = new int[V];
        int[] low = new int[V];
        int timer = 0;
        DFS(0, -1, adj, vis, isAP, disc, low, timer);
        for(int i = 0; i < V; i++) if(isAP[i]) ans.add(i);
        if(ans.size() == 0) ans.add(-1);
        return ans;
    }
}