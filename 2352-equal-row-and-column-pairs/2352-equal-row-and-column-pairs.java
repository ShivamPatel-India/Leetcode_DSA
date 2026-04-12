class Solution {
    public int equalPairs(int[][] grid) {
        int n = grid.length;
        int count = 0;

        // store each row as string key → frequency
        Map<String, Integer> map = new HashMap<>();
        for(int r = 0; r < n; r++) {
            String key = Arrays.toString(grid[r]);
            map.put(key, map.getOrDefault(key, 0) + 1);
        }

        // for each column, build same string and check map
        for(int c = 0; c < n; c++) {
            int[] col = new int[n];
            for(int r = 0; r < n; r++) {
                col[r] = grid[r][c];
            }
            String key = Arrays.toString(col);
            count += map.getOrDefault(key, 0);
        }

        return count;
    }
}