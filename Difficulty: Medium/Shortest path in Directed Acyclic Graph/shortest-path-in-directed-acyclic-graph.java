//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int[][] edge = new int[m][3];
            for (int i = 0; i < m; i++) {
                edge[i][0] = sc.nextInt();
                edge[i][1] = sc.nextInt();
                edge[i][2] = sc.nextInt();
            }
            Solution obj = new Solution();
            int res[] = obj.shortestPath(n, m, edge);
            for (int i = 0; i < n; i++) {
                System.out.print(res[i] + " ");
            }
            System.out.println();

            System.out.println("~");
        }
    }
}
// } Driver Code Ends


// User function Template for Java
class Solution {
    public class Pair {
        int v;
        int wt;
        Pair(int _v, int _wt) {
            this.v = _v;
            this.wt = _wt;
        }
    }
    public void dfs(int node, int[] vis, ArrayList<ArrayList<Pair>> adj,
    Stack<Integer> st) {
        vis[node] = 1;
        for(Pair p: adj.get(node)) {
            int v = p.v;
            if(vis[v]==0) dfs(v, vis, adj, st);
        }
        st.add(node);
    }
    public int[] shortestPath(int V, int E, int[][] edges) {
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        for(int i = 0; i < V; i++) {
            ArrayList<Pair> temp = new ArrayList<>();
            adj.add(temp);
        }
        
        // create a graph in form of adjacency list
        for(int i = 0; i < E; i++) {
            int u = edges[i][0];
            int v = edges[i][1];
            int wt = edges[i][2];
            adj.get(u).add(new Pair(v,wt));
        }
        int[] vis = new int[V];
        
        // perform topo sort using dfs and store the result in the stack
        Stack<Integer> st = new Stack<>();
        for(int i = 0; i < V; i++) {
            if(vis[i]==0) {
                dfs(i, vis, adj, st);
            }
        }
        
        //Further, we declare a vector ‘dist’ in which we update the value of the nodes’
        //distance from the source vertex after relaxation of a particular node
        int[] dist = new int[V];
        for(int i = 0; i < V; i++) {
            dist[i] = (int)1e9;
        }
        
        // since the src node is 0
        dist[0] = 0;
        
        while(!st.isEmpty()) {
            int node = st.pop();
            
            for(Pair p: adj.get(node)) {
                int v = p.v;
                int wt = p.wt;
                
                if(dist[node] + wt < dist[v]) {
                    dist[v] = dist[node] + wt;
                }
            }
        }
        
        for(int i = 0; i < V; i++) {
            if(dist[i] == (int)1e9) dist[i] = -1;
        }
        
        return dist;
    }
}