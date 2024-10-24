class Solution {
    public boolean isValid(String s) {
        // using stack to determine if parentheses are valid
        Stack<Character> st = new Stack<>();

        for(char ch : s.toCharArray()) {
            // Checking for the opening parentheses. If any push into stack.
            if(ch == '(' || ch == '[' || ch == '{')
                st.push(ch);
            else {
                // if stack is empty means opening paranthesess are missing
                if(st.isEmpty()) return false;
                // if there is closing parentheses comparing it with the last opened parentheses
                char lp = st.pop(); // lp stands for lastParentheses
                if((lp == '(' && ch == ')') || (lp == '[' && ch == ']') || (lp == '{' && ch == '}')) continue;
                else return false;
            }
        }
        // if stack is not empty means closing parentheses are missing;
        return st.isEmpty();
    }
}