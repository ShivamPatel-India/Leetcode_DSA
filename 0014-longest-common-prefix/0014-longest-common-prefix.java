class Solution {
    public String longestCommonPrefix(String[] strs) {
        if(strs == null || strs.length == 0) return "";
        // considering the first whole string as a prefix
        String prefix = strs[0];
        
        // comparing the prefix/first string with rest of the strings
        for(int i = 1; i < strs.length; i++) {

            // if the prefix is not matching with the rest of the strings, reducing its size
            while(!strs[i].startsWith(prefix)) {
                prefix = prefix.substring(0, prefix.length()-1);
                if(prefix.isEmpty()) return "";
            }
        }

        return prefix;
    }
}