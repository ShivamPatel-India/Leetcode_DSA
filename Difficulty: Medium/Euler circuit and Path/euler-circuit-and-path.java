class Solution {
    private void DFS(int node, ArrayList<ArrayList<Integer>> adj, boolean[] vis) {
        vis[node] = true;
        for(int adjNode: adj.get(node)) {
            if(!vis[adjNode]) {
                DFS(adjNode, adj, vis);
            }
        }
    }

    public int isEulerCircuit(int V, ArrayList<ArrayList<Integer>> adj) {
        /*
         * Euler Circuit  → every node has EVEN degree  + graph is connected → return 2
         * Euler Path     → exactly TWO nodes have ODD degree + graph is connected → return 1
         * Neither        → return 0
         */

        // Step 1: count how many nodes have odd degree
        int oddDegreeCount = 0;
        int[] degree = new int[V];
        for(int i = 0; i < V; i++) {
            degree[i] = adj.get(i).size();
            if((degree[i] & 1) == 1) {  // bitwise odd check
                oddDegreeCount++;
            }
        }

        // Step 2: odd degree count must be exactly 0 (circuit) or 2 (path), else invalid
        if(oddDegreeCount != 0 && oddDegreeCount != 2) return 0;

        // Step 3: check connectivity — start DFS from any non-isolated node
        boolean[] vis = new boolean[V];
        for(int i = 0; i < V; i++) {
            if(degree[i] != 0) {
                DFS(i, adj, vis);
                break;
            }
        }

        // Step 4: all non-isolated nodes must have been visited (single component)
        for(int i = 0; i < V; i++) {
            if(degree[i] != 0 && !vis[i]) return 0;
        }

        // Step 5: connected + all even degrees → circuit; connected + two odd degrees → path
        return oddDegreeCount == 0 ? 2 : 1;
    }
}