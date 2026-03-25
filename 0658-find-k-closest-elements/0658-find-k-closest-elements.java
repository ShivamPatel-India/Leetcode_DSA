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
    private List<Integer> twoPointers(int[] arr, int k, int x) {
        int l = 0;
        int r = arr.length - 1;

        while(r - l >= k) {
            if(Math.abs(x-arr[l]) <= Math.abs(x-arr[r])) {
                r--;
            } else l++;
        }

        List<Integer> ans = new ArrayList<>();
        for(int i = l; i <= r; i++) ans.add(arr[i]);
        return ans;

    }
    private List<Integer> binarySearchTwoPointers(int[] arr, int k, int x) {
        int l = 0;
        int r = arr.length - 1;

        while(l < r) {
            int m = (l + r) / 2;
            if(arr[m] < x) l = m + 1;
            else r = m;
        }

        l = l - 1;
        r = l + 1;
        while(r - l - 1 < k) {
             if (l < 0) {
                r++;
            } else if (r >= arr.length) {
                l--;
            } else if (Math.abs(arr[l] - x) <= Math.abs(arr[r] - x)) {
                l--;
            } else {
                r++;
            }
        }

        List<Integer> result = new ArrayList<>();
        for (int i = l + 1; i < r; i++) {
            result.add(arr[i]);
        }
        return result;
    }
    
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        // return LinearScanTwoPointers(arr, k, x);
        return binarySearchTwoPointers(arr, k, x);
    }
}