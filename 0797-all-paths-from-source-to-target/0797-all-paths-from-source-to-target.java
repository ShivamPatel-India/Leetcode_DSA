class Solution {
    private void dfs(int node, int[][] graph, List<Integer> path, int dest, List<List<Integer>> ans) {
        path.add(node);

        if(node == dest) ans.add(new ArrayList<>(path));
        else {
            for(int adjNode: graph[node]) dfs(adjNode, graph, path, dest, ans);
        }
        path.remove(path.size()-1);
    }
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        int V = graph.length;
        List<List<Integer>> ans = new ArrayList<>();

        List<Integer> path = new ArrayList<>();
        dfs(0, graph, path, V-1, ans);
        return ans;
    }
}