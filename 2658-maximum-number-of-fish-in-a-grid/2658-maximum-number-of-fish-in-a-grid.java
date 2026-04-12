class Solution {
    private int helper(int x, int y, int[][] grid) {
        if(x < 0 || y < 0 || x >= grid.length || y >= grid[0].length || grid[x][y] == 0) return 0;
        int fishCaught = grid[x][y];
        grid[x][y] = 0;

        fishCaught += helper(x, y-1, grid) + helper(x, y+1, grid) + helper(x-1, y, grid) + helper(x+1, y, grid);
        return fishCaught;
    }
    public int findMaxFish(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int maxFish = 0;

        for(int i = 0 ; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(grid[i][j] != 0) {
                    maxFish = Math.max(maxFish, helper(i, j, grid));
                }
            }
        }
        return maxFish;
    }
}