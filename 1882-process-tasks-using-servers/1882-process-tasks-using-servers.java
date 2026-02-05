class Solution {
    public int[] assignTasks(int[] servers, int[] tasks) {
        int n = servers.length, m = tasks.length;
        int[] res = new int[m];

        //available servers: <weight, index>
        PriorityQueue<int[]> available = new PriorityQueue<>((a, b) -> a[0] != b[0] ? 
            Integer.compare(a[0], b[0]) :
            Integer.compare(a[1], b[1]));
        
        //busy servers: <timeServerBecomesFree, weight, index>
        PriorityQueue<int[]> busy = new PriorityQueue<>(
            Comparator.comparingInt(a -> a[0])
        );

        // Initially all the servers are available
        for(int i = 0; i < n; i++) {
            available.offer(new int[]{servers[i], i});
        }

        int time = 0;
        for(int i = 0; i < m; i++) {
            time = Math.max(time, i);
            if(available.isEmpty()) {
                time = busy.peek()[0];
            }

            while(!busy.isEmpty() && busy.peek()[0] <= time) {
                int[] server = busy.poll();
                available.offer(new int[]{server[1], server[2]});
            }

            //find the best server to perform the task
            int[] bestAvailableServer = available.poll();
            res[i] = bestAvailableServer[1];

            busy.offer(new int[]{time + tasks[i], bestAvailableServer[0], bestAvailableServer[1]});

        }
        return res;
    }
}