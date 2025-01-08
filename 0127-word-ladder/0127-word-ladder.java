class Solution {
    public class Pair {
        String word;
        int step; // level of BFS
        Pair(String _word, int _step) {
            this.word = _word;
            this.step = _step;
        }
    }
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        // creating a queue ds for BFS
        Queue<Pair> q = new LinkedList<>();

        // BFS traversal with pushing the values in queue
        q.add(new Pair(beginWord, 1));

        // convert the wordList from List ds to Set for easier deletion and less TC
        Set<String> s = new HashSet<>();
        for(String word: wordList) {
            s.add(word);
        }

        // in order to mark the word as visited, remove it from the set
        s.remove(beginWord);

        while(!q.isEmpty()) {
            String word = q.peek().word;
            int steps = q.peek().step;
            q.remove();

            // return the steps as soon as the first occurance of endWord is found
            if(word.equals(endWord)) return steps;

            // generate all the possible combination of the word : 
            // replace each char of word with a-z and then check if that particular word exist in the wordList
            for(int i = 0; i < word.length(); i++) {
                for(char ch = 'a'; ch <= 'z'; ch++) {
                    char[] replacedCharArray = word.toCharArray();
                    replacedCharArray[i] = ch;
                    String newWord = new String(replacedCharArray);

                    // check if the new word exist in the set/wordList
                    if(s.contains(newWord)) {
                        q.add(new Pair(newWord, steps+1));
                        s.remove(newWord);
                    }
                }
            }
        }
        // if there is no transformation popssible
        return 0;
    }
}