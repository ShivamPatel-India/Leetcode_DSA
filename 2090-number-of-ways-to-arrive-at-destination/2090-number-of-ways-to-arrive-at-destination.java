class Solution {
    class Pair {
        int first; // node
        long second; // dist
        Pair(int f, long s) {
            first = f;
            second = s;
        }
    }
    public int countPaths(int n, int[][] roads) {
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();

        for(int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        int m = roads.length;
        for(int i = 0; i < m; i++) {
            // undirected
            adj.get(roads[i][0]).add(new Pair(roads[i][1], roads[i][2]));
            adj.get(roads[i][1]).add(new Pair(roads[i][0], roads[i][2]));
        }

        long[] dist = new long[n];
        int[] ways = new int[n];
        for(int i = 0; i < n; i++) {
            dist[i] = Long.MAX_VALUE;
        }
        dist[0] = 0;
        ways[0] = 1;

        PriorityQueue<Pair> pq = new PriorityQueue<Pair>((x,y) -> Long.compare(x.second, y.second));
        pq.add(new Pair(0,0));
        int mod = (int)(1e9 + 7);

        while(!pq.isEmpty()) {
            int node = pq.peek().first;
            long d = pq.peek().second;
            pq.remove();
            

            for(Pair iter: adj.get(node)) {
                int adjNode = iter.first;
                long adjW = iter.second;

                // This ‘if’ condition signifies that this is the first
                // time we’re coming with this short distance, so we push
                // in PQ and keep the no. of ways the same.
                if(d + adjW < dist[adjNode]) {
                    dist[adjNode] = d + adjW;
                    pq.add(new Pair(adjNode, dist[adjNode]));
                    ways[adjNode] = ways[node];
                } 
                // If we again encounter a node with the same short distance
                // as before, we simply increment the no. of ways.
                else if (d + adjW == dist[adjNode]) {
                    ways[adjNode] = (ways[adjNode] + ways[node]) % mod;
                }
            }
        }
        return ways[n-1] % mod;
    }
}