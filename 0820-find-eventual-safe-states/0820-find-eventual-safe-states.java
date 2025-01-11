class Solution {
    // any node which is a part of a cycle or leads to the cycle through an incoming edge towards the cycle, cannot be a safe node. Apart from these types of nodes, every node is a safe node.
    public List<Integer> eventualSafeNodes(int[][] graph) {
        // reversing the edges of the graph
        List<List<Integer>> adjRev = new ArrayList<>();
        int V = graph.length;
        for(int i = 0; i < V; i++) {
            adjRev.add(new ArrayList<>());
        }

        int[] indegree = new int[V];
        // Convert the input graph to reversed adjacency list
        for (int i = 0; i < V; i++) {
            for (int j : graph[i]) {
                adjRev.get(j).add(i);
                indegree[i]++;
            }
        }

        Queue<Integer> q = new LinkedList<>();
        List<Integer> safeNodes = new ArrayList<>();

        for(int i = 0; i < V; i++) {
            if(indegree[i]==0) q.add(i);
        }

        while(!q.isEmpty()) {
            int node = q.peek();
            q.remove();
            safeNodes.add(node);

            for(int it: adjRev.get(node)) {
                indegree[it]--;
                if(indegree[it] == 0) q.add(it);
            }
        }

        Collections.sort(safeNodes);
        return safeNodes;
    }
}