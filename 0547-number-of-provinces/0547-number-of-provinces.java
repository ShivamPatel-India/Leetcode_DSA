class Solution {
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length; // Number of nodes (cities)
        boolean[] visited = new boolean[n]; // Track visited nodes
        int provinces = 0;

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                // Start a new DFS if the node hasn't been visited
                dfs(isConnected, visited, i);
                provinces++; // Each DFS call corresponds to a new province
            }
        }
        return provinces;
    }

    private void dfs(int[][] isConnected, boolean[] visited, int currentNode) {
        visited[currentNode] = true; // Mark the current node as visited
        for (int neighbor = 0; neighbor < isConnected.length; neighbor++) {
            // If there's a connection and the neighbor hasn't been visited, explore it
            if (isConnected[currentNode][neighbor] == 1 && !visited[neighbor]) {
                dfs(isConnected, visited, neighbor);
            }
        }
    }
}