class Solution {
    private int bruteForce(String haystack, String needle) {
        int n = haystack.length();
        int m = needle.length();

        for(int i = 0; i <= n - m; i++) {
            int charCount = 0;
            for(int j = 0; j < m; j++) {
                if(haystack.charAt(i+j) == needle.charAt(j)) charCount++;
                else break;
            }
            if(charCount == m) return i;
        }
        return -1;
    }
    public int strStr(String haystack, String needle) {
        return bruteForce(haystack, needle);
    }
}