class Solution {
    public int islandPerimeter(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        Queue<int[]> q = new LinkedList<>();

        outerLoop:
        for(int i = 0; i < rows; i++) {
            for(int j = 0; j < cols; j++) {
                if(grid[i][j] == 1) {
                    q.offer(new int[]{i,j});
                    grid[i][j] = 2;
                    break outerLoop;
                }
            }
        }

        int[] dx = {-1,1,0,0};
        int[] dy = {0,0,-1,1};
        int perimeter = 0;
        while(!q.isEmpty()) {
            int[] point = q.poll();
            
            for(int i = 0; i < 4; i++) {
                int x = point[0] + dx[i];
                int y = point[1] + dy[i];

                if(x<0 || y<0 || x>=rows || y>=cols) {
                    perimeter++;
                    continue;
                } else if (grid[x][y] == 0) {
                    perimeter++;
                } else if (grid[x][y] == 1) {
                    grid[x][y] = 2;
                    q.offer(new int[]{x,y});
                }
            }
        }
        return perimeter;
    }
}