class Solution {
    class Tuple {
        int stops;
        int node;
        int cost;
        Tuple (int _stops, int _node, int _cost) {
            this.stops = _stops;
            this.node = _node;
            this.cost = _cost;
        }
    }
    class Pair{
        int first;
        int second;
        Pair(int first,int second){
            this.first = first;
            this.second = second;
        }
    }
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>(); 
        for(int i = 0;i<n;i++) {
            adj.add(new ArrayList<>()); 
        }
        int m = flights.length; 
        for(int i = 0;i<m;i++) {
            adj.get(flights[i][0]).add(new Pair(flights[i][1], flights[i][2])); 
        }

        int dist[] = new int[n];
        for(int i = 0; i < n; i++) {
            dist[i] = (int)1e9;
        }
        
        Queue<Tuple> q = new LinkedList<>();
        q.add(new Tuple(0,src,0));
        dist[src] = 0;

        while(!q.isEmpty()) {
            Tuple t = q.peek();
            q.remove();
            int stops = t.stops;
            int node = t.node;
            int cost = t.cost;

            if(stops > K) continue;
            for(Pair iter: adj.get(node)) {
                int adjNode = iter.first;
                int adjW = iter.second;

                if(cost + adjW < dist[adjNode] && stops <= K) {
                    dist[adjNode] = cost + adjW;
                    q.add(new Tuple(stops+1,adjNode,dist[adjNode]));
                }
            }
        }
        if(dist[dst]==(int)1e9) return -1;
        return dist[dst];
    }
}