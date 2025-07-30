class Solution {
    // Function to return Breadth First Search Traversal of given graph.
    public ArrayList<Integer> bfs(ArrayList<ArrayList<Integer>> adj) {
        ArrayList<Integer> ans = new ArrayList<>();
        int V = adj.size();
        boolean[] vis = new boolean[V];
        Queue<Integer> q = new LinkedList<>();
        
        q.add(0);
        vis[0] = true;
        
        while(!q.isEmpty()) {
            int node = q.poll();
            ans.add(node);
            
            for(int it: adj.get(node)) {
                if(!vis[it]) {
                    vis[it] = true;
                    q.add(it);
                }
            }
        }
        return ans;
    }
}