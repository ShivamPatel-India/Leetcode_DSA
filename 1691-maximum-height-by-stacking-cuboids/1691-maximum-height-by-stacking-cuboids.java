class Solution {
    private boolean check(int[] base, int[] newBox) {
        return newBox[0] <= base[0] && newBox[1] <= base[1] && newBox[2] <= base[2];
    }

    private int solveTab(int n, int[][] a) {
        int[] currRow = new int[n + 1];
        int[] nextRow = new int[n + 1];

        for(int curr = n-1; curr >= 0; curr--) {
            for(int prev = curr-1; prev >= -1; prev--) {
                // include
                int take = 0;
                if(prev == -1 || check(a[curr], a[prev])) {
                    take = a[curr][2] + nextRow[curr + 1];
                }
                // exclude
                int notTake = nextRow[prev + 1];

                currRow[prev + 1] = Math.max(take, notTake);
            }
            nextRow = currRow.clone();
        }
        return nextRow[0];
    }

    public int maxHeight(int[][] cuboids) {
        // Step 1: sort dimensions of each cuboid
        for(int[] a: cuboids) Arrays.sort(a);

        // Step 2: sort all cuboids
        Arrays.sort(cuboids, (a, b) -> {
            if(a[0] != b[0]) return a[0] - b[0];
            if(a[1] != b[1]) return a[1] - b[1];
            return a[2] - b[2];
        });

        // Step 3: LIS logic
        return solveTab(cuboids.length, cuboids);
    }
}