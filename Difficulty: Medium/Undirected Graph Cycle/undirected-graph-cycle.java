class Solution {
    private boolean detectCycle(int node, ArrayList<ArrayList<Integer>> adj, boolean[] vis) {
        vis[node] = true;
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{node, -1});
        
        while(!q.isEmpty()) {
            int currentNode = q.peek()[0];
            int parentNode = q.peek()[1];
            q.poll();
            
            for(int adjNode: adj.get(currentNode)) {
                if(!vis[adjNode]) {
                    vis[adjNode] = true;
                    q.offer(new int[]{adjNode, currentNode});
                } else if (parentNode != adjNode) {
                    return true;
                }
            }
        }
        return false;
    }
    public boolean isCycle(int V, int[][] edges) {
        // Code here
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i = 0; i < V; i++) adj.add(new ArrayList<>());
        for(int[] edge: edges) {
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }
        
        boolean[] vis = new boolean[V];
        
        for(int i = 0; i < V; i++) {
            if(!vis[i]) {
                if(detectCycle(i, adj, vis)) return true;
            }
        }
        return false;
    }
}