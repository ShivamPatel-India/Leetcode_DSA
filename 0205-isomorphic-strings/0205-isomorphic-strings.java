class Solution {
    public boolean isIsomorphic(String s, String t) {
        // not checking by the length of the string as it is given in the constraints that both woll be equal in length

        Map<Character, Character> mp = new HashMap<>();
        for(int i = 0; i < s.length(); i++) {
            char sch = s.charAt(i);
            char tch = t.charAt(i);
            if(!mp.containsKey(sch)) {
                if(mp.containsValue(tch)) return false;
                mp.put(sch, tch);
            } else {
                if(tch != mp.get(sch)) return false;
            }
        }
        return true;
    }
}