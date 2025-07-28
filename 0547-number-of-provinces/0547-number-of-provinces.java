import java.util.*;
class Solution {
    private void bfs(int node, int[][] adj, boolean[] vis) {
        if(vis[node]) return;
        Queue<Integer> q = new LinkedList<>();

        vis[node] = true;
        q.add(node);

        while(!q.isEmpty()) {
            Integer n = q.poll();

            for(int it = 0; it < adj[n].length; it++) {
                if(adj[n][it] == 1 && !vis[it]) {
                    vis[it] = true;
                    q.add(it);
                }
            }
        }
    }
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        boolean[] vis = new boolean[n];
        int provinces = 0;

        for(int i = 0; i < n; i++) {
            if(!vis[i]) provinces++;
            bfs(i, isConnected, vis);
        } 
        return provinces;
    }
}