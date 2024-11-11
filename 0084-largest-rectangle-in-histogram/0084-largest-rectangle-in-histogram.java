// Brute force solution

class Solution {
    static int[] findNSE(int[] arr, int n) {
        Stack<Integer> st = new Stack<>();
        int ans[] = new int[n];

        for(int i = n-1; i>=0; i--) {
            while(!st.isEmpty() && !(arr[st.peek()]<arr[i])) st.pop();

            if(st.isEmpty()) ans[i] = n;
            else ans[i] = st.peek();
            st.push(i);
        }
        return ans;
    }

    static int[] findPSE(int[] arr, int n) {
        Stack<Integer> st = new Stack<>();
        int ans[] = new int[n];

        for(int i = 0; i<n; i++) {
            while(!st.isEmpty() && !(arr[st.peek()]<arr[i])) st.pop();

            if(st.isEmpty()) ans[i] = -1;
            else ans[i] = st.peek();
            st.push(i);
        }
        return ans;
    }

    public int largestRectangleArea(int[] heights) {
        int max = 0;
        int n = heights.length;
        int[] pse = findPSE(heights, n);
        int[] nse = findNSE(heights, n);

        for(int i = 0; i<n; i++) {
            max = Math.max(max, heights[i] * (nse[i]-pse[i]-1));
        }
        return max;
    }
}