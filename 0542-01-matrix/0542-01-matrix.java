class Solution {
    // at first we might think to hit the BFS from every cell which has 1 to find the nearest 0, but that would be quite inefficient O(m*n) * O(m*n)
    // instead of that we can take all the 0 and hit the BFS from there
    public int[][] updateMatrix(int[][] mat) {
       int m = mat.length;
       int n = mat[0].length;
       Queue<int[]> q = new LinkedList<>(); // [i, j, steps]
       int[][] dist = new int[m][n];

       for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(mat[i][j] == 0) {
                    q.add(new int[]{i,j,0}); 
                    dist[i][j] = 0;
                } else dist[i][j] = -1;
            }
       }
       int[] dx = {-1,1,0,0};
       int[] dy = {0,0,-1,1};

       while(!q.isEmpty()) {
        int[] point = q.poll();
        int x = point[0], y = point[1], steps = point[2];
        
        for(int i = 0 ; i < 4 ; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(nx<0 || ny<0 || nx>=m || ny>=n || dist[nx][ny]!=-1) continue;
            dist[nx][ny] = 1 + steps;
            q.add(new int[]{nx, ny, steps+1});
        }
       }
       return dist;
    }
}