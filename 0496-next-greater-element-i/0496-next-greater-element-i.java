class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Stack<Integer> st = new Stack<>();
        int n = nums2.length;
        Map<Integer, Integer> nge = new HashMap<Integer, Integer>();

        for(int i = n-1; i >= 0; i--) {
            while(!st.isEmpty() && st.peek() <= nums2[i]) st.pop();

            if(st.isEmpty()) nge.put(nums2[i], -1);
            else nge.put(nums2[i], st.peek());
            st.push(nums2[i]);
        }
        int k = nums1.length; 
        int[] ans = new int[k];

        for(int i = 0; i<k; i++) {
            ans[i] = nge.get(nums1[i]);
        }
        return ans;
    }
}