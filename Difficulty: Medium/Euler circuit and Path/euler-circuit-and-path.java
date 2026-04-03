class Solution {
    private void DFS(int node, ArrayList<ArrayList<Integer>> adj, boolean[] vis) {
        vis[node] = true;
        
        for(int adjNode: adj.get(node)) {
            if(!vis[adjNode]){
                DFS(adjNode, adj, vis);
            }
        }
    }
    public int isEulerCircuit(int V, ArrayList<ArrayList<Integer>> adj) {
        int oddDegreeCount = 0;
        int[] degree = new int[V];
        for(int i = 0; i < V; i++) {
            degree[i] = adj.get(i).size();
            if((degree[i] & 1) == 1) oddDegreeCount++;
        }
        
        if(oddDegreeCount != 0 && oddDegreeCount != 2) return 0;
        
        boolean[] vis = new boolean[V];
        for(int i = 0; i < V; i++) {
            if(degree[i] != 0) {
                DFS(i, adj, vis);
                break;
            }
        }
        
        for(int i = 0; i < V; i++) {
            if(degree[i] != 0 && !vis[i]) {
                return 0;
            }
        }
        
        return oddDegreeCount == 0 ? 2 : 1; 
        
    }
}