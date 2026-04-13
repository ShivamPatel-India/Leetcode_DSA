class Solution {
    public int orangesRotting(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int totalOranges = 0;
        Queue<int[]> q = new LinkedList<>();
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(grid[i][j] > 0) totalOranges++;
                if(grid[i][j] == 2) q.add(new int[]{i,j});
            }
        }

        int[] dx = {-1,1,0,0};
        int[] dy = {0,0,-1,1};
        int exploredOranges = 0;
        int minTime = 0;
        while(!q.isEmpty()) {
            int size = q.size();
            exploredOranges += size;

            for(int i = 0; i < size; i++) {
                int[] point = q.poll();
                for(int k = 0; k < 4; k++) {
                    int nx = point[0] + dx[k];
                    int ny = point[1] + dy[k];

                    if(nx < 0 || ny < 0 || nx >= m || ny >= n || grid[nx][ny] == 2 || grid[nx][ny] == 0) continue;
                    // rotting happens
                    grid[nx][ny] = 2;
                    q.add(new int[]{nx, ny});
                } 
            }
            // increase the time only if q is not empty that is rotting happened. If q is empty rotting didn't happen so no need to increase the time in that case.
            if(!q.isEmpty()) minTime++;
        }
        return exploredOranges == totalOranges ? minTime : -1;
    }
}