class Solution {
    private int[][] memo;
    public int maxHeight(int[][] cuboids) {
        // sort dimensions of each cuboid w<=l<=h (height maximum), [w, l, h]
        for(int[] cuboid: cuboids) Arrays.sort(cuboid);
        
        // now sort the whole set of cuboids
        Arrays.sort(cuboids, (a, b) -> {
            if(a[0] != b[0]) return a[0]-b[0];
            if(a[1] != b[1]) return a[1]-b[1];
            return a[2]-b[2];
        });

        int n = cuboids.length;
        memo = new int[n+1][n+1]; // current cube index, previous cube index
        for(int[] row: memo) Arrays.fill(row, -1);

        return solve(0, -1, cuboids);
    }
    private int solve(int i, int prev, int[][] cuboids) {
        if(i >= cuboids.length) return 0;
        if(prev != -1 && memo[i][prev] != -1) return memo[i][prev];

        // take
        int take = 0;
        if(prev == -1 || (cuboids[i][0] >= cuboids[prev][0] &&
                        cuboids[i][1] >= cuboids[prev][1] &&
                        cuboids[i][2] >= cuboids[prev][2])) {
                            take = cuboids[i][2] + solve(i+1, i, cuboids);
                        }
        int skip = solve(i+1, prev, cuboids);
        if(prev != -1) memo[i][prev] = Math.max(take, skip);
        return Math.max(take, skip);
    }
}