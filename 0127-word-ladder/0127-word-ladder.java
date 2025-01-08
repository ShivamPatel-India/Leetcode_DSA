class Solution {
    public class Pair {
        String word;
        int steps;
        Pair(String _word, int _steps) {
            this.word = _word;
            this.steps = _steps;
        }
    }
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Queue<Pair> q = new LinkedList<>();

        q.add(new Pair(beginWord,1));

        Set<String> s = new HashSet<>();
        for(String w: wordList) {
            s.add(w);
        }
        s.remove(beginWord);

        while(!q.isEmpty()) {
            String word = q.peek().word;
            int steps = q.peek().steps;
            q.remove();

            if(word.equals(endWord)) return steps;

            for(int i = 0; i < word.length(); i++) {
                for(char ch= 'a' ; ch<='z'; ch++) {
                    char[] charArray = word.toCharArray();
                    charArray[i] = ch;
                    String newWord = new String(charArray);

                    if(s.contains(newWord)) {
                        s.remove(newWord);
                        q.add(new Pair(newWord, steps+1));
                    }
                }
            }
        }
        return 0;
    }
}