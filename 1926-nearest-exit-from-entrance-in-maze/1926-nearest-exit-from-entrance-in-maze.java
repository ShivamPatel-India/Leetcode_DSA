class Solution {
    public int nearestExit(char[][] maze, int[] entrance) {
        int m = maze.length;
        int n = maze[0].length;
        boolean[][] vis = new boolean[m][n];
        int[] dx = {0, 0, -1, 1};
        int[] dy = {-1, 1, 0, 0};
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{entrance[0], entrance[1], 0});
        vis[entrance[0]][entrance[1]] = true;
        while(!q.isEmpty()) {
            int[] cur = q.poll();
            int x = cur[0];
            int y = cur[1];
            int d = cur[2];

            for(int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if(nx < 0 || ny < 0 || nx >= m || ny >= n || maze[nx][ny] == '+') continue;
                if(!vis[nx][ny]) {
                    if(nx == 0 || ny == 0 || nx == m-1 || ny == n-1) return 1 + d;
                    else {
                        vis[nx][ny] = true;
                        q.add(new int[]{nx, ny, 1 + d});
                    }
                } 
            }
        }
        return -1;
    }
}