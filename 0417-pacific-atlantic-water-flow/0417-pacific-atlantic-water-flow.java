class Solution {
    private int[] dx = {0, 0, -1, 1};
    private int[] dy = {-1, 1, 0, 0};
    private void DFS(int x, int y, boolean[][] vis, int[][] heights, int min) {
        if(min > heights[x][y]) return;
        vis[x][y] = true;
        min = heights[x][y];

        for(int i = 0; i < 4; i++) {
            int x_ = x + dx[i];
            int y_ = y + dy[i];

            if(x_ >= 0 && y_ >= 0 && x_ < heights.length && y_ < heights[0].length && !vis[x_][y_]) {
                DFS(x_, y_, vis, heights, min);
            }
        }
    }
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int m = heights.length;
        int n = heights[0].length;

        boolean[][] pacificVis = new boolean[m][n];
        boolean[][] atlanticVis = new boolean[m][n];

        for(int i = 0; i < n; i++) {
            //Top row - pacific
            DFS(0, i, pacificVis, heights, Integer.MIN_VALUE);
            // Bottom row - atlantic
            DFS(m-1, i, atlanticVis, heights, Integer.MIN_VALUE);
        }
        for(int i = 0; i < m; i++) {
            // Left column - pacific
            DFS(i, 0, pacificVis, heights, Integer.MIN_VALUE);
            // Right column - atlantic
            DFS(i, n-1, atlanticVis, heights, Integer.MIN_VALUE);
        }

        List<List<Integer>> ans = new ArrayList<>();
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++) {
                if(pacificVis[i][j] && atlanticVis[i][j]) {
                    ans.add(Arrays.asList(i,j));
                }
            }
        }
        return ans;
    }
}