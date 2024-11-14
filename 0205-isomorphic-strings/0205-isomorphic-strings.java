class Solution {
    public boolean isIsomorphic(String s, String t) {
        // not checking by the length of the string as it is given in the constraints that both woll be equal in length

        Map<Character, Character> mp = new HashMap<>();
        for(int i = 0; i < s.length(); i++) {
            char sch = s.charAt(i);
            char tch = t.charAt(i);
            // checking if the key is in the map or not
            if(!mp.containsKey(sch)) {
                // if the key is not in the map then the value associated with it that is tch also should not be in the map, and if its there then strings are not isomorphi hence returning false
                if(mp.containsValue(tch)) return false;
                // otherwise making the entry in map
                mp.put(sch, tch);
            } else {
                // if key is there in the map, then comparing its value with currenct tch
                if(tch != mp.get(sch)) return false;
            }
        }

        // if none of the false condition executed in the above block, just return true
        return true;
    }
}