class Solution {
    public ArrayList<Integer> bfs(ArrayList<ArrayList<Integer>> adj) {
        // code here
        ArrayList<Integer> ans = new ArrayList<>();
        int V = adj.size();
        boolean[] vis = new boolean[V];
        Queue<Integer> q = new LinkedList<>();
        
        q.offer(0);
        vis[0] = true;
        
        while(!q.isEmpty()) {
            int node = q.poll();
            vis[node] = true;
            ans.add(node);
            
            for(int it: adj.get(node)) {
                if(!vis[it]) {
                    vis[it] =true;
                    q.offer(it);
                }
            }
        }
        return ans;
    }
}