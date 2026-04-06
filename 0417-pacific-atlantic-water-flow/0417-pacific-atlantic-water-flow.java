class Solution {
    private final int[][] directions = {{1,0},{-1,0},{0,1},{0,-1}};

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int m = heights.length;
        int n = heights[0].length;

        boolean[][] pacificVis = new boolean[m][n];
        boolean[][] atlanticVis = new boolean[m][n];

        // Top row → Pacific, Bottom row → Atlantic
        // Left col → Pacific, Right col → Atlantic
        for(int i = 0; i < m; i++) {
            dfs(heights, pacificVis, i, 0, Integer.MIN_VALUE);
            dfs(heights, atlanticVis, i, n-1, Integer.MIN_VALUE);
        }
        for(int j = 0; j < n; j++) {
            dfs(heights, pacificVis, 0, j, Integer.MIN_VALUE);
            dfs(heights, atlanticVis, m-1, j, Integer.MIN_VALUE);
        }

        // Cell reachable from both oceans → add to result
        List<List<Integer>> result = new ArrayList<>();
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(pacificVis[i][j] && atlanticVis[i][j]) {
                    result.add(Arrays.asList(i, j));
                }
            }
        }
        return result;
    }

    private void dfs(int[][] heights, boolean[][] vis, int i, int j, int prevHeight) {
        int m = heights.length;
        int n = heights[0].length;

        if(i < 0 || i >= m || j < 0 || j >= n) return; // out of bounds
        if(vis[i][j]) return;                            // already visited
        if(heights[i][j] < prevHeight) return;           // water can't flow uphill

        vis[i][j] = true;

        for(int[] dir : directions) {
            dfs(heights, vis, i + dir[0], j + dir[1], heights[i][j]);
        }
    }
}