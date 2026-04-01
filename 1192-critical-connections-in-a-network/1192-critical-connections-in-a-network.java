class Solution {
    private void DFS(int node, int parent, List<List<Integer>> adj, 
                     List<List<Integer>> bridges, int count, 
                     int[] disc, int[] low, boolean[] vis) {
        
        // both start at same timer — low will be pulled down if back edge found
        disc[node] = count;
        low[node] = count;
        vis[node] = true;

        for(int neighbour: adj.get(node)) {
            // skip the edge we came from — not a back edge, just the tree edge
            if(neighbour == parent) continue;
            
            if(vis[neighbour]) {
                // back edge found — neighbour is an already visited ancestor
                // use disc[neighbour] not low[neighbour] — using low[neighbour]
                // in undirected graphs can incorrectly pull low[node] down
                // through the same edge we came from
                low[node] = Math.min(low[node], disc[neighbour]);
            } else {
                // tree edge — go deeper
                count += 1;
                DFS(neighbour, node, adj, bridges, count, disc, low, vis);
                
                // after returning from child, pull up child's low value —
                // if child can reach an ancestor, so can node
                low[node] = Math.min(low[node], low[neighbour]);
                
                // bridge condition — strict < unlike AP which uses <=
                // if neighbour's subtree CANNOT reach node or above at all
                // then this edge is the only connection → it's a bridge
                if(disc[node] < low[neighbour]) {
                    bridges.add(new ArrayList<>(Arrays.asList(node, neighbour)));
                }
            }
        }
    }
    
    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        // build adjacency list
        List<List<Integer>> adj = new ArrayList<>();
        for(int i = 0; i < n; i++) adj.add(new ArrayList<>());
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