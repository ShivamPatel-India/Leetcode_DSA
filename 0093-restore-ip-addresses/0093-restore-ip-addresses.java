class Solution {
    public List<String> restoreIpAddresses(String s) {
        List<String> res = new ArrayList<>();

        if(s.length() > 12) return res;

        backtrack(s, 0, 0, res, "");
        return res;
    }
    private void backtrack(String s, int i, int dots, List<String> res, String curIP) {
        if(dots > 4) return;
        if(dots == 4 && i == s.length()) {
            res.add(curIP.substring(0, curIP.length() - 1));
            return;
        }

        for(int j = i; j < Math.min(i+3, s.length()); j++) {
            String segment = s.substring(i, j+1);
            if(Integer.parseInt(segment) < 256 && (i == j || s.charAt(i) != '0')) {
                backtrack(s, j+1, dots+1, res, curIP + segment + "." );
            }
        }
    }
}