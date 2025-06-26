import java.util.*;

class Solution {
    public char repeatedCharacter(String s) {
        int[] seen = new int[26];
        Arrays.fill(seen, -1);

        char[] chars = s.toCharArray();
        for(int i = 0; i < chars.length; i++) {
            if(seen[(int)(chars[i])-97] != -1) return chars[i];
            else seen[(int)(chars[i])-97] = 1;
        }
        return 's'; // dummy return 

    }
}