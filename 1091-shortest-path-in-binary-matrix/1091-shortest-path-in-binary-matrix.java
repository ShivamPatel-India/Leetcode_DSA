class Solution {
    class Tuple {
        int x, y, d;
        Tuple(int _x, int _y, int _d) {
            this.x = _x;
            this.y = _y;
            this.d = _d;
        }
    }
    public int shortestPathBinaryMatrix(int[][] grid) {
        int n = grid.length;

        if(grid[0][0] == 1 || grid[n-1][n-1] == -1) return -1;

        int[][] dist = new int[n][n];
        for(int i = 0; i < n; i++) {
            Arrays.fill(dist[i], (int)1e9);
        }
        
        dist[0][0] = 1;
        Queue<Tuple> q = new LinkedList<>();
        q.add(new Tuple(0,0,1));

        while(!q.isEmpty()) {
            Tuple t = q.poll();
            int x = t.x;
            int y = t.y;
            int d = t.d;

            if(x == n-1 && y == n-1) return d;

            for(int delRow = -1; delRow <= 1; delRow++) {
                for(int delCol = -1; delCol <= 1; delCol++) {
                    int nx = x + delRow;
                    int ny = y + delCol;

                    if(nx >= 0 && ny >= 0 && nx < n && ny < n && grid[nx][ny] != 1 &&
                    dist[nx][ny] > d + 1) {
                        dist[nx][ny] = d + 1;
                        q.add(new Tuple(nx, ny, d + 1));
                    }
                }
            }
        } 
        return -1;      
    }
}