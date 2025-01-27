class Solution {
    class Pair {
        int node;
        long time;
        Pair(int _node, long _time) {
            this.node = _node;
            this.time = _time;
        }
    }
    public int countPaths(int n, int[][] roads) {
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        int m = roads.length;
        for(int i = 0; i < m; i++) {
            adj.get(roads[i][0]).add(new Pair(roads[i][1],roads[i][2]));
            adj.get(roads[i][1]).add(new Pair(roads[i][0],roads[i][2]));
        }
        
        long[] times = new long[n];
        int[] ways = new int[n];
        for(int i = 0; i < n; i++) {
            times[i] = Long.MAX_VALUE;
        }
        times[0] = 0;
        ways[0] = 1;

        PriorityQueue<Pair> pq = new PriorityQueue<>((x,y) -> Long.compare(x.time, y.time));
        pq.add(new Pair(0,0));
        int mod = (int)(1e9 + 7);

        while(!pq.isEmpty()) {
            int node = pq.peek().node;
            long time = pq.peek().time;
            pq.remove();

            for(Pair p: adj.get(node)) {
                int adjNode = p.node;
                long adjT = p.time;

                if(adjT + time < times[adjNode]) {
                    times[adjNode] = adjT + time;
                    pq.add(new Pair(adjNode, times[adjNode]));
                    ways[adjNode] = ways[node];
                } else if (time + adjT == times[adjNode]) {
                    ways[adjNode] = (ways[adjNode] + ways[node]) % mod;
                }
            }
        }
        return ways[n-1] % mod;
    }
}