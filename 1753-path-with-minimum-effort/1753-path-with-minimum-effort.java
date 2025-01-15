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
    public int minimumEffortPath(int[][] heights) {
        int n = heights.length;
        int m = heights[0].length;

        int[][] dist = new int[n][m];
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                dist[i][j] = (int)1e9;
            }
        }
        PriorityQueue<Tuple> q = new PriorityQueue<Tuple>((x,y)->x.d-y.d);
        q.add(new Tuple(0,0,0));
        dist[0][0] = 0;

        int delrow[] = {0,1,0,-1};
        int delcol[] = {1,0,-1,0};

        while(!q.isEmpty()) {
            Tuple t = q.peek();
            q.remove();
            int d = t.d;
            int x = t.x;
            int y = t.y;

            if(x==n-1 && y==m-1) return d;

            for(int i = 0; i < 4; i++) {
                int nx = x + delrow[i];
                int ny = y + delcol[i];

                if(nx>=0 && nx<n && ny>=0 && ny<m) {
                    // Effort can be calculated as the max value of differences 
                    // between the heights of the node and its adjacent nodes.
                    int newEffort = 
                    Math.max(
                        Math.abs(heights[x][y] - heights[nx][ny]), d); 
                    // If the calculated effort is less than the prev value
                    // we update as we need the min effort.
                    if(newEffort < dist[nx][ny]) {
                        dist[nx][ny] = newEffort; 
                        q.add(new Tuple(newEffort, nx, ny)); 
                    }
                }
            }
        }
        return 0;
    }
}