class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();

        // using array based hashing because we have fixed number of keys (ascii characters in this case)
        int[] hash = new int[256];
        Arrays.fill(hash, -1);

        int l = 0, r = 0, len = 0, maxlen = 0;

        while(r<n) {
            // if entry for the character is already there in the hashmap
            if(hash[(int)s.charAt(r)] != -1) {
                if(hash[(int)s.charAt(r)] >= l) {
                    l = hash[(int)s.charAt(r)] + 1;
                }
            }
            len = r - l + 1;
            maxlen = Math.max(len, maxlen);
            hash[(int)s.charAt(r)] = r;
            r++;
        }
        return maxlen;
    }
}