class Solution {
    public class Tuple {
        int d;
        int x;
        int y;
        Tuple(int _d, int _x, int _y) {
            this.d = _d;
            this.x = _x;
            this.y = _y;
        }
    }
    public int shortestPathBinaryMatrix(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        if (grid[0][0] == 1 || grid[n - 1][m - 1] == 1) {
            return -1;
        }


        int[][] dist = new int[n][m];
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                dist[i][j] = (int)1e9;
            }
        }

        Queue<Tuple> q = new LinkedList<>();
        q.add(new Tuple(1,0,0));
        dist[0][0] = 1;

        while(!q.isEmpty()) {
            Tuple t = q.peek();
            q.remove();
            int x = t.x;
            int y = t.y;
            int d = t.d;

            if(x==n-1 && y==m-1) return d;

            for(int delrow = -1; delrow <= 1; delrow++) {
                for(int delcol = -1; delcol <= 1; delcol++) {
                    int nx = x + delrow;
                    int ny = y + delcol;

                    if(nx>=0 && nx<n && ny>=0 && ny<m && grid[nx][ny]==0 && d+1<dist[nx][ny]){
                        dist[nx][ny] = d+1;
                        q.add(new Tuple(dist[nx][ny],nx,ny));
                    }
                }
            }
        }
        return -1;
    }
}