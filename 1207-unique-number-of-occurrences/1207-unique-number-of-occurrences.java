class Solution {
    public boolean uniqueOccurrences(int[] arr) {
        int[] hash = new int[2001];
        boolean[] set = new boolean[2001];

        for(int i : arr) hash[i + 1000]++;
        for(int i : hash) 
        {
            if(i == 0) continue;
            if(set[i + 1000]) return false;
            set[i + 1000] = true;
        }

        return true;
    }
}