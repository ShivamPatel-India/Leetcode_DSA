class Solution {
    class Pair {
        String gene;
        int mutation;
        Pair(String _gene, int _mutation) {
            this.gene = _gene;
            this.mutation = _mutation;
        }
    }
    public int minMutation(String startGene, String endGene, String[] bank) {
        Set<String> set = new HashSet<>();
        for(String b: bank) set.add(b);
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(startGene, 0));
        char[] characters = {'A', 'C', 'G', 'T'};

        while(!q.isEmpty()) {
            Pair p = q.poll();
            String gene = p.gene;
            int m = p.mutation;

            if(gene.equals(endGene)) return m;

            int n = gene.length();
            for(int i = 0 ; i < n; i++) {
                for(char ch: characters) {
                    char[] geneCharArray = gene.toCharArray();
                    geneCharArray[i] = ch;
                    String newGene = new String(geneCharArray);
                    if(set.contains(newGene)) {
                        set.remove(newGene);
                        q.add(new Pair(newGene, 1 + m));
                    }
                }
            }
        }
        return -1;
    }
}