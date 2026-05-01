class Solution {
    private int n;
    private int sp;
    private int maxlen;
    private void check(int i, int j, String s) {
        while(i >= 0 && j < n && s.charAt(i) == s.charAt(j)) {
            if(maxlen < j-i+1) {
                maxlen = j-i+1;
                sp = i;
            }
            i--;
            j++;
        }
    }
    public String longestPalindrome(String s) {
        n = s.length();
        maxlen = Integer.MIN_VALUE;
        sp = 0;
        for(int i = 0; i < n; i++) {
            check(i, i, s);
            check(i, i+1, s);
        }
        return s.substring(sp, sp+maxlen);
    }
}