class Solution {
    public boolean rotateString(String s, String goal) {
        // when we concatenate the string with itself, it will contains all the possible combination
        if(s.length() != goal.length()) return false;
        return (s+s).contains(goal);
    }
}