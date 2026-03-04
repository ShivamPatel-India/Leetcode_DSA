class Solution {
    public class Node {
        int row, col, dist;
        Node(int _row, int _col, int _dist) {
            this.row = _row;
            this.col = _col;
            this.dist = _dist;
        }
    }
    public int[][] updateMatrix(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;

        int[][] vis = new int[n][m];
        int[][] dist = new int[n][m];

        Queue<Node> q = new LinkedList<>();

        for(int i = 0 ; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(mat[i][j] == 0) {
                    q.add(new Node(i,j, 0));
                    vis[i][j] = 0; // marking already visited nodes as 0
                } else {
                    vis[i][j] = 1;
                }
            }
        }

        int[] delRow = {-1,1,0,0};
        int[] delCol = {0,0,-1,1};

        while(!q.isEmpty()) {
            int row = q.peek().row;
            int col = q.peek().col;
            int steps = q.peek().dist;
            q.remove();

            dist[row][col] = steps;

            for(int i = 0; i < 4; i++) {
                int nrow = row + delRow[i];
                int ncol = col + delCol[i];

                if(nrow>=0 && ncol>=0 && nrow<n && ncol<m && vis[nrow][ncol]==1) {
                    vis[nrow][ncol] = 0;
                    q.add(new Node(nrow, ncol, steps + 1));
                }
            }
        }
        return dist;
    }
}