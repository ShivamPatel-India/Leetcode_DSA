import java.util.*;
class Solution {
    public int firstUniqChar(String s) {
        int[] freq = new int[26];
        Arrays.fill(freq, 0);
        int n = s.length();
        for(int i = 0; i < n; i++) {
            freq[(int)s.charAt(i)-97]++;
        }
        for(int i = 0; i < n; i++) {
            if(freq[(int)s.charAt(i)-97] == 1) return i;
        }
        return -1;
    }
}