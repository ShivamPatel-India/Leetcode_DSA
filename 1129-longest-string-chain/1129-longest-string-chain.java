class Solution {
    // custom coparator function to sorting strings by length;
    private Comparator<String> comp = (s1, s2) -> s1.length() - s2.length();

    // function to compare two strings and check if they form a valid chain
    private boolean compare(String s1, String s2) {
        // s1 - current string (should be 1 size longer/larger than s2 i.e., previous string)
        if(s1.length() != s2.length() + 1) {
            return false;
        }

        int first = 0; // points to s1
        int second = 0; // points to s2

        while(first < s1.length()) {
            if(second < s2.length() && s1.charAt(first) == s2.charAt(second)) {
                first++;
                second++;
            }
            else first++;
        }

        return first == s1.length() && second == s2.length();
    }
    
    // funcion to find the length of the longest str chain
    public int longestStrChain(String[] words) {
        // sort the array by string length
        Arrays.sort(words, comp);

        int n = words.length;
        int dp[] = new int[n];
        Arrays.fill(dp, 1);

        int maxi = 1;
        for(int i = 0; i < n; i++) {
            for(int prev = 0; prev < i; prev++) {
                if(compare(words[i], words[prev]) && 1 + dp[prev] > dp[i]) {
                    dp[i] = 1 + dp[prev];
                }
            }
            maxi = Math.max(maxi, dp[i]);
        }
        return maxi;
    }
}
