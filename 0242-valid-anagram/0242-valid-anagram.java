class Solution {
    public boolean isAnagram(String s, String t) {
        // if given strings are of different length
        if (s.length() != t.length())
            return false;

        // creating a frequency array as we 26 letters in alphabet asd as given in
        // contraints that strings can have only lowercases
        int[] freq = new int[26];

        // counting the freq of every letter in string s
        for (char c : s.toCharArray()) freq[c-'A'-32]++;
        // decrease the freq of every letter in array for the chars in t
        for (char c : t.toCharArray()) freq[c-'A'-32]--;

        // now if for every character if the frequency is 0 thann we can say that number
        // of appearance of every character in the s and t are same
        for (int i = 0; i < 26; i++) {
            if (freq[i] != 0)
                return false;
        }
        return true;
    }
}