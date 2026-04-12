class Solution {
    public ArrayList<Integer> bfs(ArrayList<ArrayList<Integer>> adj) {
        int n = adj.size();
        ArrayList<Integer> ans = new ArrayList<>();
        Queue<Integer> q = new LinkedList<>();
        boolean[] vis = new boolean[n];
        vis[0] = true;
        q.add(0);
        
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