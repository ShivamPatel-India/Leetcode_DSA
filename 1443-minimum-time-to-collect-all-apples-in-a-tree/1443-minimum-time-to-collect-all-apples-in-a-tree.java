class Solution {
    private int DFS(int curr, int parent, List<List<Integer>> adj, boolean[] hasApple) {
        int time = 0;

        for(int child: adj.get(curr)) {
            if(child == parent) continue;

            int timeFromChild = DFS(child, curr, adj, hasApple);

            // visit this child's subtree only if it has an apple or child itself has apple
            if(timeFromChild > 0 || hasApple[child]) {
                time += 2 + timeFromChild;
            }
        }

        return time;
    }

    public int minTime(int n, int[][] edges, List<Boolean> hasApple) {
        List<List<Integer>> adj = new ArrayList<>();
        for(int i = 0; i < n; i++) adj.add(new ArrayList<>());
        for(int[] e: edges) {
            adj.get(e[0]).add(e[1]);
            adj.get(e[1]).add(e[0]);
        }

        // convert List<Boolean> to boolean[]
        boolean[] apples = new boolean[n];
        for(int i = 0; i < n; i++) apples[i] = hasApple.get(i);

        return DFS(0, -1, adj, apples);
    }
}