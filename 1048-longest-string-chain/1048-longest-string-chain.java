class Solution {
    private boolean isPredecessor(String a, String b) {
        int alen = a.length();
        int blen = b.length();
        if(alen != 1 + blen) return false;
        int aptr = 0;
        int bptr = 0;
        while(aptr < alen) {
            if(bptr < blen && a.charAt(aptr) == b.charAt(bptr)) {
                aptr++;
                bptr++;
            } else aptr++;
        }
        return aptr == alen && bptr == blen;
    }
    public int longestStrChain(String[] words) {
        int n = words.length;
        Arrays.sort(words, (a,b) -> a.length() - b.length());
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        int ans = 1;
        for(int i = 1; i < n; i++) {
            for(int j = 0; j < i; j++) {
                if(isPredecessor(words[i], words[j])) {
                    dp[i] = Math.max(dp[i], 1 + dp[j]);
                    ans = Math.max(dp[i], ans);
                }
            }
        }
        return ans;
    }
}