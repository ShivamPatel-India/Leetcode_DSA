// User function Template for Java

class Solution {
    int minimumMultiplications(int[] arr, int start, int end) {
        if(start == end) return 0;
        int n = arr.length;
        int[] dist = new int[100000];
        Arrays.fill(dist, (int)1e9);
        
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{start, 0});
        dist[start] = 0;
        
        int mod = 100000;
        while(!q.isEmpty()) {
            int node = q.peek()[0];
            int d = q.peek()[1];
            q.poll();
            
            for(int i = 0; i < n; i++) {
                int adjNode = (arr[i] * node) % mod;
                if(dist[adjNode] > d + 1) {
                    dist[adjNode] = d + 1;
                    if(adjNode == end) return dist[adjNode];
                    q.add(new int[]{adjNode, dist[adjNode]});
                }
            }
        }
        return -1;
    }
}
