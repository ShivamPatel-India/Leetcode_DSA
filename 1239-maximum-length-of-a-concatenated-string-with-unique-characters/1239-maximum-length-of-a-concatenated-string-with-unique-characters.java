class Solution {
    private boolean hasDuplicate(String u, String v) {
        int[] freq = new int[26];
        for(char ch: u.toCharArray()) {
            if(freq[ch-'a'] > 0) return true;
            freq[ch-'a']++;
        }
        for(char ch: v.toCharArray()) {
            if(freq[ch-'a'] > 0) return true;
        }
        return false;
    }
    private int solve(int i, List<String> arr, String temp, int n) {
        if(i >= n) return temp.length();

        int include = 0;
        int exclude = 0;
        if(hasDuplicate(arr.get(i), temp)) {
            exclude = solve(i+1, arr, temp, n);
        } else {
            exclude = solve(i+1, arr, temp, n);
            include = solve(i+1, arr, temp + arr.get(i), n);
        }
        return Math.max(include, exclude);
    }
    public int maxLength(List<String> arr) {
        int n = arr.size();
        String temp = "";
        return solve(0, arr, temp, n);
    }
}