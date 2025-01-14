//{ Driver Code Starts
import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br;
    static PrintWriter ot;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        ot = new PrintWriter(System.out);

        int t = Integer.parseInt(br.readLine().trim());

        while (t-- > 0) {
            String s[] = br.readLine().trim().split(" ");
            int n = Integer.parseInt(s[0]), m = Integer.parseInt(s[1]);
            int edges[][] = new int[m][3];
            for (int i = 0; i < m; i++) {
                s = br.readLine().trim().split(" ");
                edges[i][0] = Integer.parseInt(s[0]);
                edges[i][1] = Integer.parseInt(s[1]);
                edges[i][2] = Integer.parseInt(s[2]);
            }

            List<Integer> list = new Solution().shortestPath(n, m, edges);

            ot.println(list.get(0));
            if (list.get(0) != -1 && !check(list, edges)) ot.println(-1);
        }
        ot.close();
    }

    static boolean check(List<Integer> list, int edges[][]) {
        Set<Integer> hs = new HashSet<>();
        Map<Integer, Map<Integer, Integer>> hm = new HashMap<>();
        for (int i = 1; i < list.size(); i++) hs.add(list.get(i));
        for (int x[] : edges) {
            if (hs.contains(x[0]) || hs.contains(x[1])) {
                if (!hm.containsKey(x[0])) hm.put(x[0], new HashMap<>());
                if (!hm.containsKey(x[1])) hm.put(x[1], new HashMap<>());
                hm.get(x[0]).put(x[1], x[2]);
                hm.get(x[1]).put(x[0], x[2]);
            }
        }
        int sum = 0;
        for (int i = 1; i < list.size() - 1; i++) {
            if (!hm.containsKey(list.get(i)) ||
                !hm.get(list.get(i)).containsKey(list.get(i + 1)))
                return false;
            sum += hm.get(list.get(i)).get(list.get(i + 1));
        }
        return sum == list.get(0);
    }
}

// } Driver Code Ends

class Pair{
    int first;
    int second;
    public Pair(int first,int second){
        this.first = first;
        this.second = second;
    }
}
class Solution {
    public List<Integer> shortestPath(int n, int m, int edges[][]) {
        // Step 1: Create adjacency list
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int i = 0; i < m; i++) {
            int u = edges[i][0];
            int v = edges[i][1];
            int wt = edges[i][2];
            adj.get(u).add(new Pair(v, wt));
            adj.get(v).add(new Pair(u, wt)); // Undirected graph
        }

        // Step 2: Initialize distance and parent arrays
        int[] dist = new int[n + 1];
        int[] parent = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            dist[i] = (int) 1e9; // Set distances to infinity
            parent[i] = i;       // Initially, each node is its own parent
        }

        // Step 3: Priority queue for Dijkstra's algorithm
        PriorityQueue<Pair> pq = new PriorityQueue<>((x, y) -> x.first - y.first);

        // Set the source node
        dist[1] = 0; // Distance to the source node is 0
        pq.add(new Pair(0, 1)); // Add source node with distance 0

        // Step 4: Dijkstra's algorithm
        while (!pq.isEmpty()) {
            Pair current = pq.poll();
            int node = current.second;
            int d = current.first;

            // Explore adjacent nodes
            for (Pair neighbor : adj.get(node)) {
                int adjNode = neighbor.first;
                int edgeWeight = neighbor.second;

                // Relaxation step: Check if the distance can be minimized
                if (d + edgeWeight < dist[adjNode]) {
                    dist[adjNode] = d + edgeWeight;
                    parent[adjNode] = node; // Update parent
                    pq.add(new Pair(dist[adjNode], adjNode)); // Add updated distance to queue
                }
            }
        }

        // Step 5: Path reconstruction
        List<Integer> path = new ArrayList<>();
        if (dist[n] == (int) 1e9) {
            // If the destination is unreachable, return -1
            path.add(-1);
            return path;
        }

        int node = n;
        while (parent[node] != node) {
            path.add(node); // Add current node to the path
            node = parent[node]; // Move to the parent node
        }
        path.add(1); // Add the source node to the path
        Collections.reverse(path); // Reverse the path to get the correct order

        // Add the shortest path weight as the first element
        path.add(0, dist[n]);
        return path;
    }
}