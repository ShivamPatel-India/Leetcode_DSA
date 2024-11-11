class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> nge = new HashMap<>();
        Stack<Integer> st = new Stack<>();
        int ans[] = new int[nums1.length];
        int n = nums2.length;

        for(int i = n-1; i >=0; i--) {
            while(!st.isEmpty() && st.peek() <= nums2[i]) st.pop();

            if(st.isEmpty()) nge.put(nums2[i], -1);
            else nge.put(nums2[i], st.peek());
            st.push(nums2[i]);
        }

        for(int i = 0; i < nums1.length; i++) {
            ans[i] = nge.get(nums1[i]);
        }
        return ans;
    }
}