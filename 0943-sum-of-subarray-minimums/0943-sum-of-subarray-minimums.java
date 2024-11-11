import java.util.*;

class Solution {
    static int[] findNSE(int arr[], int n) {
        Stack<Integer> st = new Stack<>();
        int nse[] = new int[n];

        for(int i = n-1; i>=0; i--) {
            while(!st.isEmpty() && !(arr[st.peek()]<arr[i])) st.pop();

            nse[i] = st.isEmpty() ? n : st.peek();
            st.push(i);
        }
        return nse;
    }
    static int[] findPSEE(int[] arr, int n) {
        Stack<Integer> st = new Stack<>();
        int psee[] = new int[n];

        for(int i = 0; i<n; i++) {
            while(!st.isEmpty() && !(arr[st.peek()]<=arr[i])) st.pop();

            psee[i] = st.isEmpty() ? -1 : st.peek();
            st.push(i);
        }
        return psee;
    }
    public int sumSubarrayMins(int[] arr) {
        int total = 0;
        int n = arr.length;
        int mod = (int)(1e9 + 7);

        int nse[] = findNSE(arr, n);
        int psee[] = findPSEE(arr, n);

        for(int i = 0; i<n; i++) {
            int left = i - psee[i];
            int right = nse[i] - i;

            total = (int)((total + (left * right * (long)1 * arr[i]) % mod) % mod);
        }
        return total;
    }
}