class Solution {
    private void dfs(int node, List<Integer> path, int[][] graph, List<List<Integer>> ans, int dest) {
        path.add(node);

        if(node == dest) ans.add(new ArrayList<>(path));
        else {
            for(int adjNode: graph[node]) {
                dfs(adjNode, path, graph, ans, dest);
            }
        }
        path.remove(path.size()-1);
    }
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> ans = new ArrayList<>();
        int V = graph.length;

        boolean[] vis = new boolean[V];
        List<Integer> path = new ArrayList<>();
        dfs(0, path, graph, ans, V-1);
        return ans;
    }
}