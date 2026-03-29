class Solution {
    private boolean canReach(int x, int y, int t, int[][] grid, int[] dx, int[] dy, boolean[][] vis) {
        if(x < 0 || y < 0 || x >= grid.length || y >= grid.length || vis[x][y] == true || grid[x][y] > t) {
            // we can not take this path
            return false;
        }

        vis[x][y] = true;
        if(x == grid.length - 1 && y == grid.length - 1) return true;

        for(int i = 0 ; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if(canReach(nx, ny, t, grid, dx, dy, vis)) return true;
        }
        return false;
    }
    public int swimInWater(int[][] grid) {
        int n = grid.length;
        int l = 0, r = (n * n) - 1;
        int[] dx = {0,0,-1,1};
        int[] dy = {1,-1,0,0};

        int res = -1;
        while(l <= r) {
            int m = l + (r - l) / 2;
            boolean[][] vis = new boolean[n][n];
            if(canReach(0, 0, m, grid, dx, dy, vis)) {
                res = m;
                r = m - 1;
            } else l = m + 1;
        }
        return res;
    }
}