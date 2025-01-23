class Solution {
    class Pair {
        int first; // node
        int second; // time
        Pair(int f, int s) {
            first = f;
            second = s;
        }
    }
    public int networkDelayTime(int[][] times, int n, int k) {
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        for(int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
        }
        int m = times.length;
        for(int i = 0; i < m; i++) {
            adj.get(times[i][0]).add(new Pair(times[i][1],times[i][2]));
        }

        int[] time = new int[n+1];
        for(int i = 1; i <= n; i++) {
            time[i] = (int)1e9;
        }

        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{k,0});
        time[k] = 0;

        while(!q.isEmpty()) {
            int node = q.peek()[0];
            int curTime = q.peek()[1];
            q.remove();

            for(Pair iter: adj.get(node)) {
                int adjNode = iter.first;
                int nextTime = iter.second;

                if(curTime + nextTime < time[adjNode]) {
                    time[adjNode] = curTime + nextTime;
                    q.add(new int[]{adjNode, time[adjNode]});
                }
            }
        }
        int res = 0;
        for(int i = 1; i <= n; i++) {
            res = Math.max(time[i],res);
        }
        return res == (int)1e9 ? -1 : res;
    }
}