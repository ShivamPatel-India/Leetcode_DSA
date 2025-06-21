class Solution {
    private boolean isPalindrome(String s, int l, int r) {
        while(l < r) {
            if(s.charAt(l) != s.charAt(r)) return false;
            l++;
            r--;
        }
        return true;
    }
    private void dfs(int i, List<List<String>> ans, List<String> partition, String s) {
        if(i >= s.length()) {
            ans.add(new ArrayList<>(partition));
            return;
        }
        for(int j = i; j < s.length(); j++) {
            if(isPalindrome(s, i, j))  {
                partition.add(s.substring(i, j + 1));
                dfs(j+1, ans, partition, s);
                partition.removeLast();
            }
        }
    }
    public List<List<String>> partition(String s) {
        List<List<String>> ans = new ArrayList<>();
        List<String> partition = new ArrayList<>();
        dfs(0, ans, partition, s);
        return ans;
    }
}