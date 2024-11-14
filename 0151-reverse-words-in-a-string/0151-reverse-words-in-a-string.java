class Solution {
    public String reverseWords(String s) {
        // Trim leading and trailing spaces
        s = s.trim();
        
        int left = 0;
        int right = s.length() - 1;

        String temp = "";
        String ans = "";

        // Iterate the string and keep on adding to form a word
        // If a space is encountered, add the current word to the result
        while (left <= right) {
            char ch = s.charAt(left);
            if (ch != ' ') {
                temp += ch;
            } else if (ch == ' ') {
                if (!temp.isEmpty()) {
                    if (!ans.isEmpty()) {
                        ans = temp + " " + ans;
                    } else {
                        ans = temp;
                    }
                    temp = "";
                }
            }
            left++;
        }

        // If temp is not empty, add it to the result (adding the last word, becausse there is no space after the last word) 
        if (!temp.isEmpty()) {
            if (!ans.isEmpty()) {
                ans = temp + " " + ans;
            } else {
                ans = temp;
            }
        }

        return ans;
    }
}