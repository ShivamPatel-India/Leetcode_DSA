class Solution {
    private boolean isSafe(int x, int y, int n) {
        return x >= 0 && y >= 0 && x < n && y < n;
    }

    private void DFS(int x, int y, int[][] grid, boolean[][] vis, int[] dx, int[] dy) {
        vis[x][y] = true;

        for(int i = 0; i < 4; i++) {
            int x_ = x + dx[i];
            int y_ = y + dy[i];

            if(isSafe(x_, y_, grid.length) && !vis[x_][y_] && grid[x_][y_] == 1) {
                DFS(x_, y_, grid, vis, dx, dy);
            }
        }
    }

    private int BFS(int[][] grid, boolean[][] vis, int[] dx, int[] dy) {
        int n = grid.length;
        Queue<int[]> q = new LinkedList<>();
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(vis[i][j]) q.add(new int[]{i,j});
            }
        }

        int level = 0;
        while(!q.isEmpty()) {
            int size = q.size();
            
            while(size-- > 0) {
                int[] cur = q.poll();
                int x = cur[0];
                int y = cur[1];

                for(int i = 0; i < 4; i++) {
                    int x_ = x + dx[i];
                    int y_ = y + dy[i];

                    if(isSafe(x_, y_, n) && !vis[x_][y_]) {
                        if(grid[x_][y_] == 1) {
                            return level;
                        }
                        vis[x_][y_] = true;
                        q.add(new int[]{x_, y_});
                    }
                }
            }
            level++;
        }
        return level;
    }

    public int shortestBridge(int[][] grid) {
        int n = grid.length;
        boolean[][] vis = new boolean[n][n];
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(grid[i][j] == 1) {
                    // found the first island
                    DFS(i, j, grid, vis, dx, dy);
                    return BFS(grid, vis, dx, dy);
                }
            }
        }
        return -1;
    }
}