class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        // num itself-> key, freq of the number -> value
        Map<Integer, Integer> count = new HashMap<>();
        List<Integer>[] freq = new List[nums.length + 1];
        
        // for any number frequency can not be greater than the size of the array.
        // counting the freq.
        for(int num: nums) {
            count.put(num, count.getOrDefault(num, 0) + 1);
        }

        for(int i = 0; i <= nums.length; i++) {
            freq[i] = new ArrayList<>();
        }

        // after the freq is counted, we will put the number to its corresponding freq
        for(Map.Entry<Integer, Integer> entry: count.entrySet()) {
            freq[entry.getValue()].add(entry.getKey());
        }

        int[] res = new int[k];
        int index = 0;
        for(int i = freq.length-1; i > 0; i--) {
            for(int num: freq[i]) {
                res[index++] = num;
                if(index == k) return res;
            }
        }
        return res;
    }
}