class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int l = 0;
        int r = arr.length - k; // r is last valid starting index


        while(l < r) {
            int m = (l + r) / 2;
            if(x-arr[m] > arr[m+k]-x) l = m + 1; // window too far left, slide right
            else r = m; // window too far right, slide left
        }

        List<Integer> res = new ArrayList<>();
        for(int i = l; i < l + k; i++) res.add(arr[i]);
        return res;
    }
}