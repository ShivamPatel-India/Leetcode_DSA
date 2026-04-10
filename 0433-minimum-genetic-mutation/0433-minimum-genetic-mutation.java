class Solution {
    class Pair {
        String word;
        int step;
        Pair(String _word, int _step) {
            this.word = _word;
            this.step = _step;
        }
    }
    public int minMutation(String startGene, String endGene, String[] bank) {
        Set<String> set = new HashSet<>();
        for(String s: bank) set.add(s);
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(startGene, 0));
        char[] c = {'A','C','G','T'};
        while(!q.isEmpty()) {
            Pair p = q.poll();
            String word = p.word;
            int step = p.step;

            if(word.equals(endGene)) return step;
            int n = startGene.length();
            for(int i = 0; i < n; i++) {
                for(char ch: c) {
                    char[] charArray = word.toCharArray();
                    charArray[i] = ch;
                    String newWord = new String(charArray);
                    if(set.contains(newWord)) {
                        set.remove(newWord);
                        q.add(new Pair(newWord, 1 + step));
                    }
                }
            }
        }
        return -1;
    }
}