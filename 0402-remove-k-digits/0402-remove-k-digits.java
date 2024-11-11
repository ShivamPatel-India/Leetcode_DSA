class Solution {
    public String removeKdigits(String num, int k) {
        Stack<Character> st = new Stack<>();

        // traversing the string
        for(char c : num.toCharArray()) {
            // removing the stack top if its greater the current character/digit of the string
            while(!st.isEmpty() && k > 0 && (st.peek() - '0') > (c - '0')) {
                st.pop();
                // decreasing the k 
                k--;
            }
            // pushing the current digit in the stack
            st.push(c);
        }

        // EDGE CASES

        // if all the chcaracters are pushed in the stack e.g. "123456" --> k wont be decreased and every digit will be pushed in the stack. For this scenario removing the last k digits.
        while(k > 0) {
            st.pop();
            k--;
        }

        // if nothing is left in the stack. e.g. nums = "123" && k=3. In that case returning String number 0
        if(st.isEmpty()) return "0";

        // creating the result/ans string
        String res = "";
        while(!st.isEmpty()) {
            res = res + st.peek();
            st.pop();
        }

        // removing the 0s from the end of the String (ACTUALLY, THESE 0s ARE FROM THE BEGINNIG OF THE STRING AS WE HAVE CREATED 'res' STRING FROM THE STACK)
        while(!res.isEmpty() && res.charAt(res.length()-1) == '0') {
            res = res.substring(0,res.length()-1);
        }

        // reversing the res strign as it was created from the stack 
        res = new StringBuilder(res).reverse().toString();

        // returning string number 0 if there is nothing in res string e.g.res="000000" . In this case, previous step of removing 0s from the last will make the res string empty.
        if(res.isEmpty()) return "0";

        // returning the res if edge cases were not encountered.
        return res;
    }
}