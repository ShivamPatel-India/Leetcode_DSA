class Solution {
    // Function to return Breadth First Search Traversal of given graph.
    public ArrayList<Integer> bfs(ArrayList<ArrayList<Integer>> adj) {
        ArrayList<Integer> bfs = new ArrayList<>();
        int n = adj.size();
        boolean[] vis = new boolean[n];
        Queue<Integer> q = new LinkedList<>();
        
        q.add(0);
        vis[0] = true;
        
        while(!q.isEmpty()) {
            Integer node = q.poll();
            bfs.add(node);
            
            for(Integer it: adj.get(node)) {
                if(vis[it] == false) {
                     q.add(it);
                     vis[it] = true;
                }
            }
        }
        return bfs;
        
    }
}