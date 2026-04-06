class Solution {
    private int[] dx = {0, 0, -1, 1};
    private int[] dy = {-1, 1, 0, 0};
    private void DFS(int i, int j, int[][] vis, int[][] heights, int prevHeight, int ocean) {
        if(heights[i][j] < prevHeight) return;
        prevHeight = heights[i][j];
        vis[i][j] |= ocean;
        
        for(int k = 0; k < 4; k++) {
            int i_ = i + dx[k];
            int j_ = j + dy[k];

            if(i_ >= 0 && j_ >= 0 && i_ < heights.length && j_ < heights[0].length && (vis[i_][j_] & ocean) == 0) {
                DFS(i_, j_, vis, heights, prevHeight, ocean);
            }
        }
    }
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int m = heights.length;
        int n = heights[0].length;

        int[][] vis = new int[m][n];

        // top and bottom row
        for(int i = 0; i < n; i++) {
            DFS(0, i, vis, heights, Integer.MIN_VALUE, 1); // 1 - pacific
            DFS(m-1, i, vis, heights, Integer.MIN_VALUE, 2); // 2 - atlantic
        }
        // left and right column
        for(int i = 0; i < m; i++) {
            DFS(i, 0, vis, heights, Integer.MIN_VALUE, 1);
            DFS(i, n-1, vis, heights, Integer.MIN_VALUE, 2);
        }
        List<List<Integer>> ans = new ArrayList<>();
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(vis[i][j] == 3) ans.add(Arrays.asList(i,j));
            }
        }
        return ans;
    }
}