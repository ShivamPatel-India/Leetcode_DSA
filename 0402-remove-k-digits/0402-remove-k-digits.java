class Solution {
    public String removeKdigits(String num, int k) {
        Stack<Character> st = new Stack<>();

        for(char c : num.toCharArray()) {
            while(!st.isEmpty() && k > 0 && (st.peek() - '0') > (c - '0')) {
                st.pop();
                k--;
            }
            st.push(c);
        }

        while(k > 0) {
            st.pop();
            k--;
        }
        if(st.isEmpty()) return "0";
        String res = "";
        while(!st.isEmpty()) {
            res = res + st.peek();
            st.pop();
        }
        while(!res.isEmpty() && res.charAt(res.length()-1) == '0') {
            res = res.substring(0,res.length()-1);
        }
        res = new StringBuilder(res).reverse().toString();
        if(res.isEmpty()) return "0";
        return res;
    }
}