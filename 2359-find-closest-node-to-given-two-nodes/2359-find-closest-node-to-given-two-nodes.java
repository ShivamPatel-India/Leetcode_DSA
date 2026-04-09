class Solution {
    private void BFS(int src, int[] dist, List<List<Integer>> adj) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{src, 0});
        dist[src] = 0;

        while(!q.isEmpty()) {
            int[] node = q.poll();

            for(int neigh: adj.get(node[0])) {
                if(dist[neigh] > 1 + node[1]) {
                    dist[neigh] = 1 + node[1];
                    q.add(new int[]{neigh, dist[neigh]});
                }
            }
        }
    }
    public int closestMeetingNode(int[] edges, int node1, int node2) {
        int n = edges.length;
        
        // prepare adjacency list
        List<List<Integer>> adj = new ArrayList<>();
        for(int i = 0; i < n; i++) adj.add(new ArrayList<>());
        for(int i = 0; i < n; i++) {
            if(edges[i] == -1) continue;
            adj.get(i).add(edges[i]);
        }

        // we will find the shortest distance taken to reach all the node from node1 and node2
        int[] dist1 = new int[n];
        Arrays.fill(dist1, (int)1e9);
        int[] dist2 = new int[n];
        Arrays.fill(dist2, (int)1e9);

        BFS(node1, dist1, adj);
        BFS(node2, dist2, adj);

        int minDist = Integer.MAX_VALUE;
        int ans = -1;
        for(int i = 0; i < n; i++) {
            if(dist1[i] == (int)1e9 || dist2[i] == (int)1e9) continue;
            int max = Math.max(dist1[i], dist2[i]);
            if(max < minDist) {
                minDist = max;
                ans = i;
            }
        }
        return ans;
    }
}