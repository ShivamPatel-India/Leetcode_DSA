class Solution {
    private List<Integer> CustomComparator(int[] arr, int k, int x) {
        List<Integer> list = Arrays.stream(arr).boxed().collect(Collectors.toList());
        list.sort((a, b) -> {
            int diff = Math.abs(a-x) - Math.abs(b-x);
            return diff == 0 ? Integer.compare(a,b) : diff;
        });

        List<Integer> result = list.subList(0, k);
        Collections.sort(result);
        return result;
    }
    private List<Integer> LinearScanTwoPointers(int[] arr, int k, int x) {
        int n = arr.length;
        int idx = 0;

        // scan through the array and find the closest element to x 
        for(int i = 1; i < n; i++) {
            if(Math.abs(x-arr[idx]) > Math.abs(x-arr[i])) {
                idx = i;
            }
        }

        List<Integer> res = new ArrayList<>();
        res.add(arr[idx]);
        int l = idx - 1, r = idx + 1;

        while(res.size() < k) {
            if(l >= 0 && r < n) {
                if(Math.abs(x-arr[l]) <= Math.abs(x-arr[r])) {
                    res.add(arr[l--]);
                } else {
                    res.add(arr[r++]);
                }
            } else if(l >= 0) {
                res.add(arr[l--]);
            } else if(r < n) {
                res.add(arr[r++]);
            }
        }

        Collections.sort(res);
        return res;
    }
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        return LinearScanTwoPointers(arr, k, x);
    }
}