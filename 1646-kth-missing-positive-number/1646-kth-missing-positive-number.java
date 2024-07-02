class Solution {
    public int findKthPositive(int[] arr, int k) {
        int n = arr.length;
        int low = 0;
        int high = n-1;

        while(low<=high) {
            int mid = low + (high-low)/2;

            int missingNos = arr[mid] - (mid+1);

            if(missingNos < k) low = mid + 1;
            else high = mid - 1;
        }
        return high+1+k;
    }
}