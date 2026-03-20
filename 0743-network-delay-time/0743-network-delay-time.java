class Solution {
    class Pair {
        int node;
        int time; 
        Pair(int _node, int _time) {
            this.node = _node;
            this.time = _time;
        }
    }
    public int networkDelayTime(int[][] times, int n, int k) {
        List<List<Pair>> adj = new ArrayList<>();
        for(int  i = 0 ; i <= n; i ++) adj.add(new ArrayList<>());

        for(int[] time: times) {
            adj.get(time[0]).add(new Pair(time[1],time[2]));
        }

        int[] time = new int[n+1];
        Arrays.fill(time, (int)1e9);

        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(k, 0));
        time[k] = 0;

        while(!q.isEmpty()) {
            int node = q.peek().node;
            int curTime = q.peek().time;
            q.remove();

            for(Pair p: adj.get(node)) {
                int adjNode = p.node;
                int t = p.time;

                if(curTime + t < time[adjNode]) {
                    time[adjNode] = t + curTime;
                    q.add(new Pair(adjNode, time[adjNode]));
                }
            }
        }
        int res = 0;
        for(int i = 1; i <= n; i++) {
            res = Math.max(res, time[i]);
        }

        return res == (int)1e9 ? -1 : res;
    }
}