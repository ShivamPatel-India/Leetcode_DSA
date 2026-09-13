class Solution {
    public int orangesRotting(int[][] grid) {
        // if the grid is empty, return 0;
        if(grid.length == 0) return 0;

        // get number of rows and columns
        int m = grid.length;
        int n = grid[0].length;

        // count the totalOranges and add the rotter oranges in the queue
        int totalOranges = 0;
        Queue<int[]> q = new LinkedList<>();
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(grid[i][j] != 0) totalOranges++;
                if(grid[i][j] == 2) q.add(new int[]{i, j});
            }
        }
        
        // four directions
        int[] dx = {1,-1,0,0};
        int[] dy = {0,0,1,-1};

        // variable to track the minTime required to rot all oranges
        int minTime = 0;

        // var to track oranges rotten so far
        int rotten = 0;

        while(!q.isEmpty()) {
            // we have to process all the rotten ornages in the queue. They all will rott their respective adjacent oranges
            int k = q.size();
            rotten += k;

            for(int i = 0; i < k; i++) {
                int[] node = q.poll();
                int x = node[0];
                int y = node[1];

                for(int l = 0; l < 4; l++) {
                    int nx = x + dx[l];
                    int ny = y + dy[l];

                    if(nx < 0 || ny < 0 || nx >= m || ny >= n || grid[nx][ny] != 1) continue;

                    grid[nx][ny] = 2;
                    q.add(new int[]{nx, ny});
                }
            }
            // only increase the time if we got more rotten oranges to process 
            if(!q.isEmpty()) minTime++;
        }

        // if all oranges are rotten return minTime otherwise -1
        return totalOranges == rotten ? minTime : -1;
    }
}