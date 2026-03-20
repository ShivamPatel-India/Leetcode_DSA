class Solution {
    public ArrayList<Integer> bfs(ArrayList<ArrayList<Integer>> adj) {
        // code here
        ArrayList<Integer> ans = new ArrayList<>();
        Queue<Integer> q = new LinkedList<>();
        int n = adj.size();
        q.add(0);
        boolean[] vis = new boolean[n];
        vis[0] = true;
        
        while(!q.isEmpty()) {
            int node = q.poll();
            ans.add(node);
            
            for(int adjNode: adj.get(node)) {
                if(!vis[adjNode]) {
                    vis[adjNode] = true;
                    q.add(adjNode);
                }
            }
        }
        return ans;
    }
}