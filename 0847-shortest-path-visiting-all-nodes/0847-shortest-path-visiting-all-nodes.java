class Solution {
    public int shortestPathLength(int[][] graph) {
        int n = graph.length;

        // all nodes visited
        int fullmask = (1 << n) - 1;

        // base case - graph contains only one node
        if(fullmask == 0) return 0;

        Queue<int[]> q = new LinkedList<>();
        boolean[][] vis = new boolean[n][1 << n];

        for(int i = 0; i < n; i++) {
            q.offer(new int[]{i, 1 << i});
            vis[i][1 << i] = true;
        }

        int steps = 0;
        while(!q.isEmpty()) {
            int size = q.size();

            for(int i = 0 ; i < size; i++) {
                int[] cur = q.poll();
                int node = cur[0];
                int mask = cur[1];

                if(mask == fullmask) return steps;

                for(int adjNode: graph[node]) {
                    int newMask = mask | (1 << adjNode);
                    if(!vis[adjNode][newMask]) {
                        vis[adjNode][newMask] = true;
                        q.offer(new int[]{adjNode, newMask});
                    }
                }
            }
            steps++;
        }
        return -1;
    }
}