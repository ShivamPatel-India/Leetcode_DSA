
class Solution {
    public int characterReplacement(String s, int k) {
        int l = 0, r = 0, maxlen = 0, maxFreq = 0;
        int[] hash = new int[26];
        char[] charArr = s.toCharArray();
        int n = charArr.length;

        for(char c : charArr) {
            maxFreq = Math.max(maxFreq, ++hash[c-'A']);
            if((r-l+1)-(maxFreq) > k) {
                hash[charArr[l] - 'A']--;
                maxFreq = 0;
                l++;
            }
            else maxlen = Math.max(maxlen, (r-l+1));
            r++;
        }
        return maxlen;
    }
}