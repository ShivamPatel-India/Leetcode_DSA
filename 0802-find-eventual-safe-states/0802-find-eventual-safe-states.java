class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        List<List<Integer>> adjRev = new ArrayList<>();
        int V = graph.length;
        for(int i = 0; i < V; i++) adjRev.add(new ArrayList<>());

        int[] indegree = new int[V];
        for(int i = 0; i < V; i++) {
            for(int j: graph[i]) {
                adjRev.get(j).add(i);
                indegree[i]++;
            }
        }
        
        Queue<Integer> q = new LinkedList<>();
        List<Integer> safeNodes = new ArrayList<>();

        for(int i = 0; i < V; i++) if(indegree[i] == 0) q.add(i);

        while(!q.isEmpty()) {
            int node = q.poll();
            safeNodes.add(node);

            for(int adjNode: adjRev.get(node)) {
                indegree[adjNode]--;
                if(indegree[adjNode] == 0) q.add(adjNode);
            }
        }
        Collections.sort(safeNodes);
        return safeNodes; 
    }
}