class Solution {
    class Pair {
        int node;
        int time;
        Pair(int node, int time) {
            this.node = node;
            this.time = time;
        }
    }
    public int networkDelayTime(int[][] times, int n, int k) {
        List<List<Pair>> adj = new ArrayList<>();
        for(int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
        }

        for(int[] time: times) adj.get(time[0]).add(new Pair(time[1], time[2]));
        int[] t = new int[n+1];
        Arrays.fill(t, (int)1e9);

        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(k, 0));
        t[k] = 0;

        while(!q.isEmpty()) {
            Pair pair = q.poll();
            int node = pair.node;
            int time = pair.time;

            for(Pair p: adj.get(node)) {
                int adjNode = p.node;
                int adjTime = p.time;

                if(adjTime + time < t[adjNode]) {
                    t[adjNode] = adjTime + time;
                    q.add(new Pair(adjNode, t[adjNode]));
                } 
            }
        }
        int res = 0;
        for(int i = 1; i <= n; i++) res = Math.max(t[i], res);

        return res == (int)1e9 ? -1 : res;
    }
}