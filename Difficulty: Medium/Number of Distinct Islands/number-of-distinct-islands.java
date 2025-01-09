//{ Driver Code Starts
// Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

// Position this line where user code will be pasted.

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int[][] grid = new int[n][m];

            for (int i = 0; i < n; i++) {

                for (int j = 0; j < m; j++) {
                    grid[i][j] = sc.nextInt();
                }
            }

            Solution ob = new Solution();
            int ans = ob.countDistinctIslands(grid);
            System.out.println(ans);
        
System.out.println("~");
}
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    String bfs(int row, int col, int[][] vis, int[][] grid, int[] delrow, int[] delcol) {
        Queue<int[]> q = new LinkedList<>();
        int n = grid.length;
        int m = grid[0].length;
        vis[row][col] = 1;
        q.add(new int[]{row, col});
        
        StringBuilder str = new StringBuilder();
        while(!q.isEmpty()) {
            int x = q.peek()[0];
            int y = q.peek()[1];
            q.remove();
            
            for(int i = 0; i<4; i++) {
                int nx = x + delrow[i];
                int ny = y + delcol[i];
                
                if(nx>=0 && nx<n && ny>=0 && ny<m && vis[nx][ny]==0 && 
                grid[nx][ny]==1) {
                    vis[nx][ny] = 1;
                    str.append("" + (nx-row) + "" + (ny-col));
                    q.add(new int[]{nx,ny});
                }
                
            }
        }
        return str.toString();
    }                
    int countDistinctIslands(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        int[][] vis = new int[rows][cols];
        int[] delrow = {-1,+1,0,0};
        int[] delcol = {0,0,-1,+1};
        HashSet<String> s = new HashSet<>();
        
        for(int i = 0; i < rows; i++) {
            for(int j = 0; j < cols; j++) {
                if(vis[i][j] == 0 && grid[i][j] == 1) {
                    s.add(bfs(i,j,vis, grid, delrow, delcol));
                }        
            }
        }
        return s.size();
    }
}
