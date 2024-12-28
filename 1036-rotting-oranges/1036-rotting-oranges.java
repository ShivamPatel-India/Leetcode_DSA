class Solution {
    public int orangesRotting(int[][] grid) {
        // get the dimensions
        int rows = grid.length;
        int cols = grid[0].length;

        // Queue to keep track of the coordinates
        Queue<int[]> queue = new LinkedList<>();

        int total_oranges = 0; // fresh + rotten oranges

        // count the total oranges and put the rotten oranges in the queue
        for(int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if(grid[i][j] != 0) total_oranges++;
                if(grid[i][j] == 2) queue.offer(new int[]{i,j});
            }
        }

        if(total_oranges == 0) return 0;

        // to keep track of the time taken to rot all oranges
        int minTime = 0;
        // to keep track of how many oranges we have explored or has been rotten
        int exploredOranges = 0;

        // directions: down, up, right, left
        int dx[] = {0,0,1,-1}; // right, left
        int dy[] = {1,-1,0,0}; // down, up

        // now take the rotten oranges from the queue and run the BFS algorithm to rot its adjacent oranges and add them to the queue so that those can be used int further levels of BFS to rot their respective adjacent oranges
        while(!queue.isEmpty()) {
            int size = queue.size();
            exploredOranges += size;
            for(int i = 0; i < size; i++) {
                int point[] = queue.poll();
                for(int j = 0; j < 4; j++) {
                    int x = point[0] + dx[j];
                    int y = point[1] + dy[j];

                    if(x<0 || y<0 || x>=rows || y>=cols || grid[x][y]==0 || grid[x][y]==2)
                        continue;
                    
                    grid[x][y] = 2;

                    queue.offer(new int[]{x,y});
                }
            }
            if(queue.size() != 0) {
                minTime++;
            }
        }
        return total_oranges == exploredOranges ? minTime : -1;
    }
}