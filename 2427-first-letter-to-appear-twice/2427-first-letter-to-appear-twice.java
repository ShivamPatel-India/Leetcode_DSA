import java.util.*;

class Solution {
    public char repeatedCharacter(String s) {
        int[] seen = new int[26];
        Arrays.fill(seen, -1);

        int n = s.length();
        for(int i = 0 ; i < n; i++) {
            char c = s.charAt(i);
            if(seen[(int)c-97] != -1) return c;
            else seen[(int)c-97] = 1;
        }
        return 'a';
    }
}