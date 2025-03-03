class Solution {
    public int orangesRotting(int[][] grid) {
        // get the dimensions
        int rows = grid.length;
        int cols = grid[0].length;

        // queue to keep track of the co-ordinates
        Queue<int[]> q  = new LinkedList<>();

        int total_oranges = 0;

        // count the total oranges and put the rotten oranges in the queue
        for(int i = 0 ; i < rows; i++) {
            for(int j = 0; j < cols; j++) {
                if(grid[i][j] != 0) total_oranges++;
                if(grid[i][j] == 2) q.offer(new int[]{i,j});
            }
        }

        if(total_oranges == 0) return 0;

        int minTime = 0;
        int exploredOranges = 0;

        int[] dx = {-1,1,0,0};
        int[] dy = {0,0,-1,1};

        while(!q.isEmpty()) {
            int size = q.size();
            exploredOranges += size;

            for(int i = 0 ; i < size; i++) {
                int[] point = q.poll();
                for(int j = 0; j < 4; j++) {
                    int x = point[0] + dx[j];
                    int y = point[1] + dy[j];

                    if(x < 0 || y < 0 || x >= rows || y >= cols || grid[x][y] == 0 || grid[x][y] ==2) 
                        continue;
                    
                    grid[x][y] = 2;
                    // making th eentry of newly rotten orange in the queue so that it can rott its neighbour
                    q.offer(new int[]{x,y});
                }
            }
            if(q.size() != 0) {
                minTime++;
            }
        }

        return total_oranges == exploredOranges ? minTime : -1;

    }
}