class Solution {
    public int orangesRotting(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        Queue<int[]> q = new LinkedList<>();
        int totalOranges = 0;
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(grid[i][j] == 0) continue;
                if(grid[i][j] == 2) q.add(new int[]{i,j});
                totalOranges++;
            }
        }

        int explored = 0;
        int minTime = 0;
        while(!q.isEmpty()) {
            int size = q.size();
            explored += size;

            for(int i = 0; i < size; i++) {
                int x = q.peek()[0];
                int y = q.peek()[1];
                q.poll();
                for(int j = 0; j < 4; j++) {
                    int nx = x + dx[j];
                    int ny = y + dy[j];

                    if(nx >= 0 && ny >= 0 && nx < m && ny < n && grid[nx][ny] != 0 && grid[nx][ny] != 2) {
                        grid[nx][ny] = 2;
                        q.add(new int[]{nx, ny});
                    }
                }
            }
            if(q.size() != 0) minTime++;
        }
        return explored == totalOranges ? minTime : -1;
    }
}