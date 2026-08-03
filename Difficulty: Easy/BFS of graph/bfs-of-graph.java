class Solution {
    public ArrayList<Integer> bfs(ArrayList<ArrayList<Integer>> adj) {
        int n = adj.size();
        ArrayList<Integer> ans = new ArrayList<>();
        Queue<Integer> q = new LinkedList<>();
        boolean[] vis = new boolean[n];
        q.add(0);
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