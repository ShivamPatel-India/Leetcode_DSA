class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        if(obstacleGrid[0][0] == 1) return 0;

        int[] prev = new int[n];

        for(int i = 0; i < m; i++) {
            int[] cur = new int[n];
            for(int j = 0; j < n; j++) {
                if(i==0 && j==0) cur[j] = 1;
                else if(obstacleGrid[i][j] == 1) cur[j] = 0;
                else {
                    int up = 0;
                    int left = 0;
                    if(i > 0) up = prev[j];
                    if(j > 0) left = cur[j-1];
                    cur[j] = up + left;
                }
            }
            prev = cur;
        }
        return prev[n-1];
    }
}