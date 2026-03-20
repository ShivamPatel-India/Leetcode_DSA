class Solution {
    class Pair {
        int node;
        long dist;
        Pair(int _node, long _dist) {
            this.node = _node;
            this.dist = _dist;
        }
    }
    public int countPaths(int n, int[][] roads) {
        List<List<Pair>> adj = new ArrayList<>();

        for(int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        for(int[] road: roads) {
            adj.get(road[0]).add(new Pair(road[1], road[2]));
            adj.get(road[1]).add(new Pair(road[0], road[2]));
        }

        long[] time = new long[n];
        int[] ways = new int[n];
        for(int i = 0; i < n; i++) {
            time[i] = Long.MAX_VALUE;
        }
        time[0] = 0;
        ways[0] = 1;

        PriorityQueue<Pair> pq = new PriorityQueue<>((x, y) -> Long.compare(x.dist, y.dist));
        pq.add(new Pair(0,0));
        int mod = (int)(1e9 + 7);

        while(!pq.isEmpty()) {
            Pair pair = pq.poll();
            int node = pair.node;
            long t = pair.dist;

            for(Pair p: adj.get(node)) {
                int adjNode = p.node;
                long adjTime = p.dist;

                if(adjTime + t < time[adjNode]) {
                    time[adjNode] = adjTime + t;
                    pq.add(new Pair(adjNode, time[adjNode]));
                    ways[adjNode] = ways[node];
                } else if( adjTime + t == time[adjNode]) {
                    ways[adjNode] = (ways[node] + ways[adjNode]) % mod;
                }
            }
        }
        return ways[n-1] % mod;
    }
}