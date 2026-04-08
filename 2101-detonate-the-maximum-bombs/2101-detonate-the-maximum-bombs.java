class Solution {
    private double findDist(int x1, int y1, int x2, int y2) {
        double d = (double)Math.sqrt(Math.pow(x2-x1, 2) + Math.pow(y2-y1, 2));
        return d;
    }
    public int maximumDetonation(int[][] bombs) {
        List<List<Integer>> adj = new ArrayList<>();
        int n = bombs.length;
        for(int i = 0; i < n; i++) adj.add(new ArrayList<>());

        for(int i = 0; i < n; i++) {
            int[] current = bombs[i];
            for(int j = i + 1; j < n; j++) {
                if(i == j) continue;
                int[] neigh = bombs[j];
                double d = findDist(current[0], current[1], neigh[0], neigh[1]);
                if(current[2] >= d) adj.get(i).add(j);
                if(neigh[2] >= d) adj.get(j).add(i);
            }
        }

        int max = Integer.MIN_VALUE; 
        for(int i = 0; i < n; i++) {
            boolean[] vis = new boolean[n];
            max = Math.max(max, BFS(i, adj, vis));
        }
        return max;
    }
    private int BFS(int i, List<List<Integer>> adj, boolean[] vis) {
        Queue<Integer> q = new LinkedList<>();
        q.add(i);
        vis[i] = true;
        
        int max = 0;
        while(!q.isEmpty()) {
            int current = q.poll();
            max++;
            for(int neigh: adj.get(current)) {
                if(!vis[neigh]) {
                    q.add(neigh);
                    vis[neigh] = true;
                }
            }
        }
        return max;
    }
    private int DFS(int i, List<List<Integer>> adj, boolean[] vis) {
        vis[i] = true;
        int count = 1;

        for(int neigh: adj.get(i)) {
            if(!vis[neigh]) {
                count += DFS(neigh, adj, vis);
            }
        }
        return count;
    }
}