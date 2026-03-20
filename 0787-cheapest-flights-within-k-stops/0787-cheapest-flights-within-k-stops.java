class Solution {
    class Tuple {
        int stops;
        int cost;
        int node;
        Tuple(int _stops, int _cost, int _node) {
            this.stops = _stops;
            this.cost = _cost;
            this.node = _node;
        }
    }
    class Pair {
        int v, wt;
        Pair(int _v, int _wt) {
            this.v = _v;
            this.wt = _wt;
        }
    }
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        for(int i = 0; i < n; i++) adj.add(new ArrayList<>());

        for(int[] flight: flights) {
            adj.get(flight[0]).add(new Pair(flight[1], flight[2]));
        }

        int[] dist = new int[n];
        Arrays.fill(dist, (int)1e9);

        Queue<Tuple> q = new LinkedList<>();
        q.add(new Tuple(0, 0, src));
        dist[src] = 0;

        while(!q.isEmpty()) {
            Tuple t = q.peek();
            q.remove();
            int stops = t.stops;
            int node = t.node;
            int cost = t.cost;

            if(stops > k) continue;
            for(Pair p: adj.get(node)) {
                int adjNode = p.v;
                int wt = p.wt;

                if(cost + wt < dist[adjNode] && stops <= k) {
                    dist[adjNode] = cost + wt;
                    q.add(new Tuple(stops + 1, dist[adjNode], adjNode));
                }
            }
        }
        if(dist[dst] == (int)1e9) return -1;
        return dist[dst];

    }
}