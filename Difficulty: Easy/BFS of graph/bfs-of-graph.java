class Solution {
    // Function to return Breadth First Search Traversal of given graph.
    public ArrayList<Integer> bfs(ArrayList<ArrayList<Integer>> adj) {
        int V = adj.size();
        ArrayList<Integer> bfs = new ArrayList<>();
        boolean[] vis = new boolean[V];
        Queue<Integer> q = new LinkedList<>();
        
        q.add(0);
        vis[0] = true;
        
        while(!q.isEmpty()) {
            int node = q.poll();
            bfs.add(node);
            vis[node] = true;
            
            for(int n: adj.get(node)) {
                if(vis[n] == false) {
                    q.add(n);
                    vis[n] = true;
                }
            }
        }
        return bfs;
        
    }
}