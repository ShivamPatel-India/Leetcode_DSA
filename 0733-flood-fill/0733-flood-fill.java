class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int m = image.length;
        int n = image[0].length;
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{sr, sc});
        int originalColor = image[sr][sc];
        int[] dx = {-1,1,0,0};
        int[] dy = {0,0,-1,1};
        while(!q.isEmpty()) {
            int[] point = q.poll();
            image[point[0]][point[1]] = color;
            for(int i = 0; i < 4; i++) {
                int nsr = point[0] + dx[i];
                int nsc = point[1] + dy[i];

                if(nsr < 0 || nsc < 0 || nsr >= m || nsc >= n || image[nsr][nsc] != originalColor || image[nsr][nsc] == color) continue;
                image[nsr][nsc] = color;
                q.add(new int[]{nsr, nsc});
            }
        }
        return image;
    }
}