class Solution {
    public int[] asteroidCollision(int[] arr) {
        Stack<Integer> st = new Stack<>();
        int n = arr.length;

        for(int i = 0; i<n; i++) {
            if(arr[i] > 0) st.add(arr[i]);
            else {
                while(!st.isEmpty() && st.peek() > 0 && st.peek() < Math.abs(arr[i])) 
                    st.pop();
                if(!st.isEmpty() && st.peek() == Math.abs(arr[i])) st.pop();
                else if(st.isEmpty() || st.peek() < 0) st.push(arr[i]);
            }
        }
        int k = st.size();
        int ans[] = new int[k];
        Collections.reverse(st);

        for(int i = 0; i<k; i++) ans[i] = st.pop();
        return ans;

    }
}