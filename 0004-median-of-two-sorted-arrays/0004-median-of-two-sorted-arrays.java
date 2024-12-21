class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n1 = nums1.length;
        int n2 = nums2.length;
        int cnt = 0;
        int n = n1+n2;
        int i1 = n/2;
        int i2 = i1-1;

        int e1 = -1, e2 = -1;
        int i=0, j=0;

        while(i<n1 && j<n2) {
            if(nums1[i]<nums2[j]) {
                if(cnt == i1) e1 = nums1[i];
                if(cnt == i2) e2 = nums1[i]; 
                i++;
                cnt++;
            } else {
                if(cnt == i1) e1 = nums2[j];
                if(cnt == i2) e2 = nums2[j]; 
                j++;
                cnt++;
            }
        }
        while(i<n1) {
            if(cnt == i1) e1 = nums1[i];
            if(cnt == i2) e2 = nums1[i]; 
            i++;
            cnt++;
        }
        while(j<n2) {
            if(cnt == i1) e1 = nums2[j];
            if(cnt == i2) e2 = nums2[j]; 
            j++;
            cnt++; 
        }

        if(n%2 == 1) return (double)e1;
        else return (double)((double)(e1+e2)/2.0);
    }
}