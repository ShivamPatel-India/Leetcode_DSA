class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        // binary search with two pointers;
        // first lets find out the closest (largest smaller than x) element
        int n = arr.length;
        int l = 0;
        int r = n - 1;

        int ans = 0;
        while(l <= r) {
            int m = (l + r) / 2;
            if(arr[m] <= x) {
                ans = m;
                l = m + 1;
            } else r = m - 1;
        }

        int start = 0;
        if(ans + 1 < n && Math.abs(arr[ans+1]-x) < Math.abs(arr[ans]-x)) {
            start = ans + 1; // right neighbor is closer
        } else start = ans;

        // now ans is pointing to the closest element to the x (largest smaller in this case)
        l = start - 1;
        r = start + 1;
        
        List<Integer> res = new ArrayList<>();
        res.add(arr[start]);

        while(r - l - 1 < k) {
            if(l >= 0 && r < n) {
                if(Math.abs(arr[r]-x) >= Math.abs(arr[l]-x)) {
                    res.add(arr[l]);
                    l--;
                } else {
                    res.add(arr[r]);
                    r++;
                }
            } else if (l < 0) {
                res.add(arr[r]);
                r++;
            } else {
                res.add(arr[l]);
                l--;
            }
        }
        
        Collections.sort(res);
        return res;
    }
}