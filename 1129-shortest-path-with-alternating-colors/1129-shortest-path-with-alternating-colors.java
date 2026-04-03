class Solution {
    public int[] shortestAlternatingPaths(int n, int[][] redEdges, int[][] blueEdges) {
        List<List<int[]>> adj = new ArrayList<>();
        for(int i = 0; i < n; i++) adj.add(new ArrayList<>());
        for(int[] r: redEdges) adj.get(r[0]).add(new int[]{r[1], 0});
        for(int[] b: blueEdges) adj.get(b[0]).add(new int[]{b[1], 1});

        int[] dist = new int[n];
        Arrays.fill(dist, -1);
        boolean[][] vis = new boolean[n][2];
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{0, 0, -1}); // currentNode, steps, prevColor
        dist[0] = 0;
        vis[0][0] = true;
        vis[0][1] = true;

        while(!q.isEmpty()) {
            int[] current = q.poll();
            int node = current[0];
            int steps = current[1];
            int prevColor = current[2];

            for(int[] neighbour: adj.get(node)) {
                int adjNode = neighbour[0];
                int adjColor = neighbour[1];

                if(!vis[adjNode][adjColor] && adjColor != prevColor) {
                    vis[adjNode][adjColor] = true;
                    if(dist[adjNode] == -1) dist[adjNode] = 1 + steps;
                    q.add(new int[]{adjNode, 1 + steps, adjColor});
                }
            }
        }
        return dist;
    }
}