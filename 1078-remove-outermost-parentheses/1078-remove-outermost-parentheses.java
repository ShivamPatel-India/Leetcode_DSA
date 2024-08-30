class Solution {
    public String removeOuterParentheses(String s) {
        //Approach: We maintain a counter count to keep track of the balance between the opening ( and closing ) parentheses. This helps us identify when we are inside a balanced group of parentheses.

        int count = 0;
        StringBuilder ans = new StringBuilder();

        for(char c: s.toCharArray()) {
            if(c == '(') {
                if(count != 0) {
                    ans.append(c);
                }
                count++;
            } else {
                if(count > 1) {
                    ans.append(c);
                }
                count--;
            }
        }

        return ans.toString();
    }
}