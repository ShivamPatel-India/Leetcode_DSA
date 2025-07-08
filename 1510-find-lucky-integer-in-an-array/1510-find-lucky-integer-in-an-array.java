import java.util.*;
class Solution {
    public int findLucky(int[] arr) {
        int[] freq = new int[501];
        Arrays.fill(freq, -1);

        for(int i = 0 ; i < arr.length; i++) {
            freq[arr[i]]++;
        }
        int maxi = Integer.MIN_VALUE;
        for(int i = 1 ; i <= 500; i++) {
            if(i == freq[i]+1) maxi = Math.max(maxi, i);
        }
        return maxi != Integer.MIN_VALUE ? maxi : -1;
    }
}