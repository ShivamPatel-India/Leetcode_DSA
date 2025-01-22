class Solution {
    class Pair {
        int first; // node
        int second; // time or distance
        Pair(int f, int s) {
            this.first = f;
            this.second = s;
        }
    }
    public int networkDelayTime(int[][] times, int n, int k) {
        ArrayList<ArrayList<Pair>> adj= new ArrayList<>();
        int m = times.length;
        for(int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
        }
        for(int i = 0; i < m; i++) {
            adj.get(times[i][0]).add(new Pair(times[i][1], times[i][2]));
        }

        int[] dist = new int[n+1];
        for(int i = 1; i <= n; i++) {
            dist[i] = (int)1e9;
        }

        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{k,0}); // {node, distance or time}
        dist[k] = 0;

        while(!q.isEmpty()) {
            int node = q.peek()[0];
            int time = q.peek()[1];
            q.remove();

            for(Pair iter: adj.get(node)) {
                int adjNode = iter.first;
                int adjT = iter.second;

                if(time + adjT < dist[adjNode]) {
                    dist[adjNode] = time + adjT;
                    q.add(new int[]{adjNode,dist[adjNode]});
                }
            }
        }
        int res = 0;
        for(int i = 1; i <= n ; i++) {
            if(dist[i] > res) res = Math.max(res,dist[i]);
        }
        return res == (int)1e9 ? -1 : res;
    }
}