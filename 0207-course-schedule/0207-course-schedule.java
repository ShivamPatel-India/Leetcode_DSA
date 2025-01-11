class Solution {
    // topo sort approach
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // converting the prerequisites input in form of graph
        int V = numCourses;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        int m = prerequisites.length;
        for(int i = 0; i < m; i++) {
            adj.get(prerequisites[i][0]).add(prerequisites[i][1]);
        }

        // topo sort logic
        int indegree[] = new int[V];
        for(int i = 0; i < V; i++) {
            for(int it: adj.get(i)) indegree[it]++;
        }

        Queue<Integer> q = new LinkedList<>();
        for(int i = 0; i < V; i++) {
            if(indegree[i]==0) q.add(i);
        }

        ArrayList<Integer> ans = new ArrayList<>();

        while(!q.isEmpty()) {
            int node = q.peek();
            q.remove();
            ans.add(node);

            for(int it: adj.get(node)) {
                indegree[it]--;
                if(indegree[it]==0) q.add(it);
            }
        }
        return ans.size()==V;
    }
}