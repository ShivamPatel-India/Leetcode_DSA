class Solution {
    public int minimumTime(int[][] grid) {
        if(grid[0][1] > 1 && grid[1][0] > 1) return -1;

        int m = grid.length; // row
        int n = grid[0].length; // column

        int[][] time = new int[m][n];
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                time[i][j] = (int)1e9;
            }
        }

        int[] delRow = {1, -1, 0, 0};
        int[] delCol = {0, 0, 1, -1};
        PriorityQueue<int[]> pq = new PriorityQueue<>((x,y) -> x[2] - y[2]);
        pq.add(new int[]{0,0,0}); // [x, y, t]
        time[0][0] = 0;

        while(!pq.isEmpty()) {
            int[] curr = pq.poll();
            int x = curr[0];
            int y = curr[1];
            int t = curr[2];

            if(x == m-1 && y == n-1) return t;

            for(int i = 0; i < 4; i++) {
                int nx = x + delRow[i];
                int ny = y + delCol[i];
                
                int newTime = t + 1;

                if(nx >= 0 && ny >= 0 && nx < m && ny < n) {
                    if(newTime < grid[nx][ny]) {
                        // in this scenario we need t implement a bounce mechanism
                        int diff = grid[nx][ny] - newTime;
                        newTime =  grid[nx][ny] + (diff % 2 == 0 ? 0 : 1);
                    }
                    if(newTime >= grid[nx][ny] && newTime < time[nx][ny]) {
                        time[nx][ny] = newTime;
                        pq.add(new int[]{nx, ny, newTime});
                    }
                }
            }
        }
        return time[m-1][n-1] == (int)1e9 ? -1 : time[m-1][n-1];

    }
}