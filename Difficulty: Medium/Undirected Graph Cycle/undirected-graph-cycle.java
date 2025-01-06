//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while (T-- > 0) {
            String[] s = br.readLine().trim().split(" ");
            int V = Integer.parseInt(s[0]);
            int E = Integer.parseInt(s[1]);
            ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
            for (int i = 0; i < V; i++) adj.add(i, new ArrayList<Integer>());
            for (int i = 0; i < E; i++) {
                String[] S = br.readLine().trim().split(" ");
                int u = Integer.parseInt(S[0]);
                int v = Integer.parseInt(S[1]);
                adj.get(u).add(v);
                adj.get(v).add(u);
            }
            Solution obj = new Solution();
            boolean ans = obj.isCycle(adj);
            if (ans)
                System.out.println("1");
            else
                System.out.println("0");

            System.out.println("~");
        }
    }
}
// } Driver Code Ends


class Solution {
    // Function to detect cycle in an undirected graph.
    public static boolean checkForCycle(ArrayList<ArrayList<Integer>> adj,
    boolean[] vis, int node, int V) {
        Queue<int[]> q = new LinkedList<>();
        
        q.add(new int[]{node, -1});
        vis[node] = true;
        
        while(!q.isEmpty()) {
            int n = q.peek()[0];
            int parent = q.peek()[1];
            q.remove();
            
            for(Integer i: adj.get(n)) {
                if(!vis[i]) {
                    vis[i] = true;
                    q.add(new int[]{i,n});
                } else if(i != parent) return true;
            }
        }
        return false;
    }
    public boolean isCycle(ArrayList<ArrayList<Integer>> adj) {
        int V = adj.size();
        boolean[] vis = new boolean[V];
        
        for(int i = 0; i < V; i++) {
            if(!vis[i]) {
                if(checkForCycle(adj, vis, i, V)) return true;
            }
        }
        return false;
    }
}