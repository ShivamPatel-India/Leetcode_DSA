class Solution {
    public int characterReplacement(String s, int k) {
        int l = 0, r = 0, n = s.length(), maxlen = 0, maxFreq = 0;
        int hash[] = new int[26];

        for(int i = 0; i<n; i++) {
            maxFreq = Math.max(maxFreq, ++hash[s.charAt(i)-'A']);
            if((r-l+1) - maxFreq > k) {
                hash[s.charAt(l)-'A']--;
                maxFreq = 0;
                l++;
            } else maxlen = Math.max(maxlen, (r-l+1));
            r++;
        }
        return maxlen;
        
    }
}