class Solution {
    public int orangesRotting(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        Queue<int[]> q = new LinkedList<>();

        // traverse the grid and find all the rotten oranges and total orages as well.
        int totalOranges = 0;
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(grid[i][j] != 0) totalOranges++;
                if(grid[i][j] == 2) {
                    q.add(new int[]{i, j});
                }
            }
        }

        // now that we have rotten oranges we can apply bfs at the point of rotten oranges and for every level of bfs we can increase the minute
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, 1, -1};

        // we have to take this exploredOrages variable so that we can check if it equals totalOranges, than its possible to rot all oranges
        int exploredOranges = 0;
        int minTime = 0;
        while(!q.isEmpty()) {
            // we have rotten orange at this point
            int size = q.size();
            exploredOranges += size;
            for(int i = 0; i < size; i++) {
                int[] point = q.poll();
                for(int k = 0; k < 4; k++) {
                    int nx = point[0] + dx[k];
                    int ny = point[1] + dy[k];

                    // we can ignore the new cell {nx, ny} if and only if
                    // 1). cell is invalid
                    // 2). orange in the cell already rotten
                    // 3). cell is empty
                    if(nx < 0 || ny < 0 || nx >= m || ny >= n || grid[nx][ny] == 2 || grid[nx][ny] == 0) continue;

                    // if cell is valid then we can rott it
                    grid[nx][ny] = 2;
                    // after rotting it we have to put it in the queue so that we can rott its neighbors in the next pass
                    q.add(new int[]{nx, ny});
                }
            }
            if(!q.isEmpty()) minTime++;
        }
        return exploredOranges == totalOranges ? minTime : -1;
    }
}