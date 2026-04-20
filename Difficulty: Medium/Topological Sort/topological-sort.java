class Solution {
    public ArrayList<Integer> topoSort(int V, int[][] edges) {
        List<List<Integer>> adj = new ArrayList<>();
        for(int i = 0; i < V; i++) adj.add(new ArrayList<>());
        
        for(int[] e: edges) adj.get(e[0]).add(e[1]);
        
        int[] indegree = new int[V];
        for(int i = 0; i < V; i++) 
            for(int adjNode: adj.get(i))
                indegree[adjNode]++;
        
        Queue<Integer> q = new LinkedList<>();
        for(int i = 0; i < V; i++) {
            if(indegree[i] == 0) q.add(i);
        }
        
        ArrayList<Integer> topo = new ArrayList<>();
        while(!q.isEmpty()) {
            int node = q.poll();
            topo.add(node);
            
            for(int adjNode: adj.get(node)) {
                indegree[adjNode]--;
                if(indegree[adjNode] == 0) q.add(adjNode);
            }
        }
        return topo;
    }
}