class Solution {
    public ArrayList<Integer> bfs(ArrayList<ArrayList<Integer>> adj) {
        // code here
        int n = adj.size();
        ArrayList<Integer> ans = new ArrayList<>();
        boolean[] vis = new boolean[n];
        Queue<Integer> q = new LinkedList<>();
        
        q.offer(0);
        vis[0] = true;
        
        while(!q.isEmpty()) {
            int node = q.poll();
            ans.add(node);
            
            for(int it: adj.get(node)) {
                if(!vis[it]) {
                    q.offer(it);
                    vis[it] = true;
                }
            }
        }
        return ans;
    }
}