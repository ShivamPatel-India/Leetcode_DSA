class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int m = image.length;
        int n = image[0].length;
        int originalColor = image[sr][sc];
        if(originalColor == color) return image;
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{sr, sc});
        int[] dx = {1, -1, 0, 0};
        int[] dy = {0, 0, 1, -1};

        while(!q.isEmpty()) {
            int k = q.size();
            for(int i = 0; i < k; i++) {
                int[] pos = q.poll();
                int x = pos[0];
                int y = pos[1];
                image[x][y] = color;
                for(int j = 0; j < 4; j++) {
                    int nx = x + dx[j];
                    int ny = y + dy[j];
                    if(nx<0 || ny<0 || nx>=m || ny>=n || image[nx][ny] != originalColor) continue;
                    image[nx][ny] = color;
                    q.add(new int[]{nx, ny});
                }
            }
        }
        return image;
    }
}