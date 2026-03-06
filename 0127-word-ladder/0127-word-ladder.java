class Solution {
    class Pair {
        String word;
        int steps;
        Pair(String _word, int _steps) {
            this.word = _word;
            this.steps = _steps;
        }
    }
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Queue<Pair> q = new LinkedList<>();
        Set<String> s = new HashSet<>();

        for(String word: wordList) {
            s.add(word);
        }
        s.remove(beginWord);
        q.add(new Pair(beginWord, 1));

        while(!q.isEmpty()) {
            String word = q.peek().word;
            int steps = q.peek().steps;
            q.remove();

            if(word.equals(endWord)) return steps;

            // otherwise try and generate all possible words out of current word and check if any of them present in set then add it to the queue with steps + 1
            for(int i = 0; i < word.length(); i++) {
                for(char ch = 'a'; ch <= 'z'; ch++) {
                    char[] charArray = word.toCharArray();
                    charArray[i] = ch;
                    String newWord = new String(charArray);
                    if(s.contains(newWord)) {
                        s.remove(newWord);
                        q.add(new Pair(newWord, steps + 1));
                    }
                }
            }
        }
        return 0;
   }
}