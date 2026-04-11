class Solution {
    public boolean wordPattern(String pattern, String strings) {
        String[] sArray = strings.split(" ");
        int n = pattern.length();
        int m = sArray.length;
        if(m != n) return false;

        // we have to do char to word mapping and also the word to char mapping cz same word must not be mapped with two chars
        Map<Character, String> charToWord = new HashMap<>();
        Map<String, Character> wordToChar = new HashMap<>();

        for(int i = 0; i < m; i++) {
            char c = pattern.charAt(i);
            String s = sArray[i];
            
            if(charToWord.containsKey(c) && !charToWord.get(c).equals(s)) return false;
            if(wordToChar.containsKey(s) && wordToChar.get(s) != c) return false;
            charToWord.put(c, s);
            wordToChar.put(s, c);
        }
        return true;
    }
}