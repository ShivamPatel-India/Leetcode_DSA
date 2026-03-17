class Solution {
    public String findOrder(String[] words) {
        int n = words.length;
        // figure out which characters are present in the dictionary words
        boolean[] present = new boolean[26];
        for(int i = 0; i < n; i++) {
            for(char ch: words[i].toCharArray()) {
                present[ch-'a'] = true;
            }
        }
        
        // build the graph out of dictionary
        // we'll compare two adjacent words and based on that figure out which character appear first (figuring out the direction of the edge)
        
        // adjList will containt ASCII values
        List<List<Integer>> adj = new ArrayList<>();
        for(int i = 0; i < 26; i++) adj.add(new ArrayList<>());
        
        for(int i = 0; i < n-1; i++) {
            String str1 = words[i];
            String str2 = words[i+1];
            
            int len = Math.min(str1.length(), str2.length());
            
            boolean found = false;
            for(int ptr = 0; ptr < len; ptr++) {
                int str1Char = str1.charAt(ptr) - 'a';
                int str2Char = str2.charAt(ptr) - 'a';
                
                if(str1Char != str2Char) {
                    adj.get(str1Char).add(str2Char);
                    found = true;
                    break;
                }
            }
            if(!found && str1.length() > str2.length()) return "";
        }
        
        List<Integer> topo = new ArrayList<>();
        Queue<Integer> q = new LinkedList<>();
        int[] indegree = new int[26];
        
        for(int i = 0; i < 26; i++) {
            for(int adjNode: adj.get(i)) {
                indegree[adjNode]++;
            }
        }
        
        for(int i = 0; i < 26; i++) {
            if(indegree[i] == 0) q.add(i);
        }
        
        while(!q.isEmpty()) {
            int node = q.poll();
            topo.add(node);
            
            for(int adjNode: adj.get(node)) {
                indegree[adjNode]--;
                if(indegree[adjNode] == 0) q.add(adjNode);
            }
        }
        
        StringBuilder sb = new StringBuilder();
        for(int ch: topo) {
            if(present[ch]) sb.append((char)(ch+'a')); 
        }
        
        return topo.size() == 26 ? sb.toString() : "";
        
        
        
    }
}