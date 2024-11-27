class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();

        // using array based hashset cause having fixed numebr of keys (ascii chars in this case)
        int hash[] = new int[256];
        Arrays.fill(hash, -1); 

        int l = 0, r = 0, len = 0, maxlen = 0;

        while(r<n) {
            // if current char is in the map
            if(hash[(int)s.charAt(r)] != -1) {
                // update the value of l if the char is encountered after it
                if(l <= hash[(int)s.charAt(r)]) {
                    l = hash[(int)s.charAt(r)] + 1;
                }
            }
            // calculate the new length
            len = r-l+1;
            // update the maxlen
            maxlen = Math.max(maxlen, len);
            // make the entry of r in the hash array
            hash[(int)s.charAt(r)] = r;
            r++;
        }
        // return the maxlen counted after the full traversal
        return maxlen;
    }
}