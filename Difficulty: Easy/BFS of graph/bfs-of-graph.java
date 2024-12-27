//{ Driver Code Starts
import java.util.*;

// Driver code
class GFG {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testcases = sc.nextInt(); // Taking number of test cases as input

        while (testcases-- > 0) {
            int V = sc.nextInt(); // Number of vertices
            int E = sc.nextInt(); // Number of edges

            // Initialize adjacency list
            ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
            for (int i = 0; i < V; i++) {
                adj.add(new ArrayList<>()); // Create a new list for each vertex
            }

            // Add edges to the adjacency list
            for (int i = 0; i < E; i++) {
                int u = sc.nextInt();
                int v = sc.nextInt();
                adj.get(u).add(v); // Adding edge u -> v
                adj.get(v).add(u); // Adding edge v -> u (undirected graph)
            }

            // Create Solution object and call bfsOfGraph
            Solution obj = new Solution();
            ArrayList<Integer> result = obj.bfsOfGraph(V, adj);

            // Print the result
            for (int node : result) {
                System.out.print(node + " ");
            }
            System.out.println();
        }

        sc.close(); // Close the scanner
    }
}

// } Driver Code Ends


// User function Template for Java
class Solution {
    // Function to return Breadth First Traversal of given graph.
    public ArrayList<Integer> bfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
        // array to keep the record of visited nodes
        boolean[] visited = new boolean[V];
        
        // to store the BFS result;
        ArrayList<Integer> bfs = new ArrayList<>();
        
        // queue to traverse the graph in level-wise manner
        Queue<Integer> q = new LinkedList<>();
        
        // adding the startin node in the queue and markig it as visited
        q.add(0);
        visited[0] = true;
        
        while(!q.isEmpty()) {
            Integer node = q.poll();
            bfs.add(node);
            
            // take all the non-visited neighbors of the current node mark them as visited and put them in queue
            for(Integer it: adj.get(node)) {
                if(visited[it] != true) {
                    visited[it] = true;
                    q.add(it);
                }
            }
        }
        return bfs;
    }
}