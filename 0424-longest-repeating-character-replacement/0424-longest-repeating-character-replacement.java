// Brute force : generate all the substring
class Solution {
    public int characterReplacement(String s, int k) {
        int hash[] = new int[26];

        int changes = 0, maxlen = 0;
        for(int i = 0; i< s.length(); i++) {
            Arrays.fill(hash, 0);
            int maxFreq = 0;
            for(int j = i; j<s.length(); j++) {
                hash[s.charAt(j)-'A']++;
                maxFreq = Math.max(maxFreq, hash[s.charAt(j)-'A']);
                changes = (j - i + 1) - maxFreq;
                if(changes <= k) maxlen = Math.max(maxlen, (j-i+1));
                else break;
            }
        }
        return maxlen;
    }
}