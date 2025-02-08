//{ Driver Code Starts


import java.io.*;
import java.lang.*;
import java.util.*;

public class Main {
    static BufferedReader br;
    static PrintWriter ot;

    public static void main(String args[]) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        ot = new PrintWriter(System.out);
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            int V = Integer.parseInt(br.readLine().trim());
            int E = Integer.parseInt(br.readLine().trim());
            List<List<int[]>> list = new ArrayList<>();
            for (int i = 0; i < V; i++) list.add(new ArrayList<>());
            for (int i = 0; i < E; i++) {
                String[] s = br.readLine().trim().split(" ");
                int a = Integer.parseInt(s[0]);
                int b = Integer.parseInt(s[1]);
                int c = Integer.parseInt(s[2]);
                list.get(a).add(new int[] {b, c});
                list.get(b).add(new int[] {a, c});
            }
            ot.println(new Solution().spanningTree(V, E, list));

            ot.println("~");
        }
        ot.close();
    }
}
// } Driver Code Ends


// User function Template for Java
class Pair {
    int node;
    int dist;
    Pair(int n, int d) {
        this.node = n;
        this.dist = d;
    }
}
class Solution {
    static int spanningTree(int V, int E, List<List<int[]>> adj) {
        int[] vis = new int[V];
        Arrays.fill(vis, 0);
        
        PriorityQueue<Pair> pq = new PriorityQueue<>((x,y) -> x.dist - y.dist);
        pq.add(new Pair(0,0));
        
        int sum = 0;
        
        while(!pq.isEmpty()) {
            int node = pq.peek().node;
            int dist = pq.peek().dist;
            pq.remove();
            
            if(vis[node] == 1) continue;
            vis[node] = 1;
            sum += dist;
            for(int[] it: adj.get(node)) {
                int adjNode = it[0];
                int adjDist = it[1];
                if(vis[adjNode] == 0) {
                    pq.add(new Pair(adjNode, adjDist));
                }
            }
        }
        return sum;
    }
}