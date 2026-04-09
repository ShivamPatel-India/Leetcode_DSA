class Solution {
    private int[] getDist(int[] edges, int node) {
        int n = edges.length;
        int[] dist = new int[n];
        Arrays.fill(dist, -1);

        int current = node;
        int d = 0;
        while(current != -1 && dist[current] == -1) {
            dist[current] = d++;
            current = edges[current];
        }
        return dist;
    }
    public int closestMeetingNode(int[] edges, int node1, int node2) {
        int n = edges.length;
        int[] dist1 = getDist(edges, node1);
        int[] dist2 = getDist(edges, node2);

        int minDist = Integer.MAX_VALUE;
        int ans = -1;
        for(int i = 0; i < n; i++) {
            if(dist1[i] == -1 || dist2[i] == -1) continue;
            int max = Math.max(dist1[i], dist2[i]);
            if(max < minDist) {
                minDist = max;
                ans = i;
            }
        }
        return ans;
    }
}