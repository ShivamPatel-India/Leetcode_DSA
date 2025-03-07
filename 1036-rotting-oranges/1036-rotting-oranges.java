class Solution {
    public int orangesRotting(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;

        Queue<int[]> q = new LinkedList<>();
        int total_oranges = 0;

        for(int i = 0; i < rows; i++) {
            for(int j = 0; j < cols; j++) {
                if(grid[i][j] != 0) total_oranges++;
                if(grid[i][j] == 2) q.offer(new int[]{i,j});
            }
        }

        int[] dx = {-1,1,0,0};
        int[] dy = {0,0,-1,1};
        int minTime = 0;
        int explored_oranges = 0;

        while(!q.isEmpty()) {
            int size = q.size();
            explored_oranges += size;

            for(int i = 0 ; i < size; i++) {
                int[] point = q.poll();
                for(int j = 0 ; j < 4; j++) {
                    int x = point[0] + dx[j];
                    int y = point[1] + dy[j];

                    if(x<0 || y<0 || x>=rows || y>=cols || grid[x][y]==0 || grid[x][y]==2) 
                        continue;
                    
                    grid[x][y] = 2;
                    q.offer(new int[]{x,y});
                }
            }
            if(q.size() != 0) minTime++;
        }
        return total_oranges == explored_oranges ? minTime : -1;
    }
}