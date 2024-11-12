// more optimal approach as we are calculating the PSE and NSE on the fly

class Solution {
    public int largestRectangleArea(int[] histo) {
        Stack<Integer> st = new Stack<>();
        int maxArea = 0;
        int n = histo.length;

        for(int i = 0; i<=n; i++) {
            while(!st.isEmpty() && (i==n || histo[st.peek()] >= histo[i])) {
                int height = histo[st.peek()];
                st.pop();
                int width;
                if(st.isEmpty()) {
                    width = i;
                } else {
                    width = i - st.peek() - 1;
                }
                maxArea = Math.max(maxArea, height * width);
            }
            st.push(i);
        }
        return maxArea;
    }
}