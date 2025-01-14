//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;

class iPair {
    int first, second;

    iPair(int first, int second) {
        this.first = first;
        this.second = second;
    }
}

class DriverClass {
    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String str[] = read.readLine().trim().split(" ");
            int V = Integer.parseInt(str[0]);
            int E = Integer.parseInt(str[1]);

            ArrayList<ArrayList<iPair>> adj = new ArrayList<ArrayList<iPair>>();
            for (int i = 0; i < V; i++) {
                adj.add(new ArrayList<iPair>());
            }

            int i = 0;
            while (i++ < E) {
                String S[] = read.readLine().trim().split(" ");
                int u = Integer.parseInt(S[0]);
                int v = Integer.parseInt(S[1]);
                int w = Integer.parseInt(S[2]);
                iPair t1 = new iPair(v, w);
                iPair t2 = new iPair(u, w);
                adj.get(u).add(t1);
                adj.get(v).add(t2);
            }

            int src = Integer.parseInt(read.readLine());

            Solution ob = new Solution();

            ArrayList<Integer> res = ob.dijkstra(adj, src);

            for (i = 0; i < V; i++) System.out.print(res.get(i) + " ");
            System.out.println();

            System.out.println("~");
        }
    }
}
// } Driver Code Ends


/*
class iPair {
    int first, second;

    iPair(int first, int second) {
        this.first = first; // node
        this.second = second; // distance from source
    }
}
*/

// User function Template for Java
class Solution {
    // Function to find the shortest distance of all the vertices
    // from the source vertex src.
    ArrayList<Integer> dijkstra(ArrayList<ArrayList<iPair>> adj, int src) {
        int V = adj.size();
        
        // create a priority queue to store node as {node, dist} 
        // where dist is the distance from source to the node
        PriorityQueue<iPair> pq = 
                new PriorityQueue<iPair>((x,y)->x.second-y.second);
        ArrayList<Integer> dist = new ArrayList<>();
        
        for(int i = 0; i < V; i++) dist.add((int)1e9);
        
        dist.set(src,0);
        pq.add(new iPair(src,0));
        
        // now pop the minimum distance node first from the min-heap/pq
        // and traverse all its adjcent nodes
        while(pq.size()!=0) {
            int node = pq.peek().first;
            int dis = pq.peek().second;
            pq.remove();
            
            // check for all the adjcent nodes of the popped out element 
            // whether the prev dist was larger than the current or not
            for(iPair p: adj.get(node)) {
                int adjNode = p.first;
                int edgeWeight = p.second;
                
                // if the current dist is smaller push it into the queue
                if(dis + edgeWeight < dist.get(adjNode)) {
                    dist.set(adjNode, dis + edgeWeight);
                    pq.add(new iPair(adjNode, dist.get(adjNode)));
                }
            }
        }
        return dist;
    }
}