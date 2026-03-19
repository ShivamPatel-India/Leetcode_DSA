class Solution {
    class Tuple {
        int x, y, wt;
        Tuple(int _x, int _y, int _wt) {
            this.x = _x;
            this.y = _y;
            this.wt = _wt;
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

        PriorityQueue<Tuple> pq = new PriorityQueue<>((x, y) -> x.wt - y.wt);
        pq.add(new Tuple(0,0,0));
        dist[0][0] = 0;

        int[] delRow = {1,-1,0,0};
        int[] delCol = {0,0,-1,1};

        while(!pq.isEmpty()) {
            Tuple t = pq.poll();
            int x = t.x;
            int y = t.y;
            int wt = t.wt;

            if(x == n-1 && y == m-1) return wt;

            for(int i: delRow) {
                for(int j: delCol) {
                    int nx = x + i;
                    int ny = y + j;

                    if(nx >= 0 && ny >= 0 && nx < n && ny < m) {
                        int effort = Math.max(Math.abs(heights[x][y]-heights[nx][ny]), wt);
                        if(effort < dist[nx][ny]) {
                            dist[nx][ny] = effort;
                            pq.add(new Tuple(nx, ny, effort));
                        }
                    }
                }
            }
        }
        return 0;
    }
}