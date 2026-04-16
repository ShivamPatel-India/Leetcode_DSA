class Solution {
    class Pair {
        String word;
        int steps;
        Pair(String word, int steps) {
            this.word = word;
            this.steps = steps;
        }
    }
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        int n = beginWord.length();
        Queue<Pair> q = new LinkedList<>();
        Set<String> s = new HashSet<>();
        for(String word: wordList) s.add(word);
        if(!s.contains(endWord)) {
            return 0;
        }
        s.remove(beginWord);
        q.add(new Pair(beginWord, 1));

        while(!q.isEmpty()) {
            Pair p = q.poll();
            String word = p.word;
            int steps = p.steps;

            if(word.equals(endWord)) return steps;
            for(int i = 0; i < n; i++) {
                for(char ch = 'a'; ch <= 'z'; ch++) {
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