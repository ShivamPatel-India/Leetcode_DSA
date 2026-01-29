class Solution {
    public int findLeastNumOfUniqueInts(int[] arr, int k) {
        int n = arr.length;
        Map<Integer, Integer> freqMap = new HashMap<>();
        for(int num: arr) {
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
        }

        int[] freqList = new int[n+1];
        for(int f: freqMap.values()) {
            freqList[f]++;
        }

        int res = freqMap.size();
        for(int f = 1; f < freqList.length; f++) {
            int remove = freqList[f];
            if(k >= f * remove) {
                k -= f * remove;
                res -=remove;
            } else {
                remove = k / f;
                res -= remove;
                break;
            }
        }
        return res;
    }
}