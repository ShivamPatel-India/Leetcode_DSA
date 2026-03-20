class Solution {
    public int minimumTime(int[][] grid) {
        if(grid[0][1] > 1 && grid[1][0] > 1) return -1;
        
        int m = grid.length;
        int n = grid[0].length;

        int[][] time = new int[m][n];
        for(int i = 0; i < m; i++) {
            Arrays.fill(time[i], (int)1e9);
        }

        int[] delRow = {1, -1, 0, 0};
        int[] delCol = {0, 0, 1, -1};

        PriorityQueue<int[]> pq = new PriorityQueue<>((x, y) -> x[2] - y[2]);
        pq.add(new int[]{0,0,0}); // [x, y, time]
        time[0][0] = 0;

        while(!pq.isEmpty()) {
            int[] cur = pq.poll();
            int x = cur[0], y = cur[1], t = cur[2];

            for(int i = 0; i < 4; i++) {
                int nx = x + delRow[i];
                int ny = y + delCol[i];

                if(nx < 0 || ny < 0 || nx >= m || ny >= n) continue;
                
                int newTime = t + 1;
                // if neighboring node is not visitable then we have to wait 
                if(newTime < grid[nx][ny]) {
                    int diff = grid[nx][ny] - newTime;
                    newTime = grid[nx][ny] + (diff % 2 == 0 ? 0 : 1);
                }

                if(newTime < time[nx][ny]) {
                    time[nx][ny] = newTime;
                    pq.add(new int[]{nx, ny, newTime});
                }
            }
        }
        return time[m-1][n-1] == (int)1e9 ? -1 : time[m-1][n-1];
    }
}