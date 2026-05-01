class Solution {
    private int count;
    private void check(int i, int j, String s, int n) {
        while(i >= 0 && j < n && s.charAt(i) == s.charAt(j)) {
            count++;
            i--;
            j++;
        }
    }
    public int countSubstrings(String s) {
        count = 0;
        int n = s.length();
        for(int i = 0; i < n; i++) {
            check(i, i, s, n);
            check(i, i+1, s, n);
        }
        return count;
    }
}