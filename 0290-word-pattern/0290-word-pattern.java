class Solution {
    public boolean wordPattern(String pattern, String s) {
        String[] sArray = s.split(" ");
        int m = pattern.length();
        int n = sArray.length;
        if(m != n) return false;

        Map<Character, String> charToWord = new HashMap<>();
        Map<String, Character> wordToChar = new HashMap<>();

        for(int i = 0; i < m; i++) {
            char c = pattern.charAt(i);
            String word = sArray[i];

            if(charToWord.containsKey(c) && !charToWord.get(c).equals(word)) return false;
            if(wordToChar.containsKey(word) && wordToChar.get(word) != c) return false;

            charToWord.put(c, word);
            wordToChar.put(word, c);
        }
        return true;
    }
}