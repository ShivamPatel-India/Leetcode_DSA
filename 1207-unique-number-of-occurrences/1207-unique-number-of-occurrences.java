class Solution {
    public boolean uniqueOccurrences(int[] arr) {
        // count frequencies
        Map<Integer, Integer> freq = new HashMap<>();
        for(int num: arr) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }

        // check if all frequency values are unique
        Set<Integer> seen = new HashSet<>();
        for(int count: freq.values()) {
            if(!seen.add(count)) return false; // duplicate frequency found
        }
        return true;
    }
}