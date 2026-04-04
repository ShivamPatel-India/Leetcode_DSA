class Solution {
    public List<String> findItinerary(List<List<String>> tickets) {
        Map<String, PriorityQueue<String>> graph = new HashMap<>();
        for(List<String> t: tickets) {
            graph.computeIfAbsent(t.get(0), k -> new PriorityQueue<>()).add(t.get(1));
        }
        
        List<String> ans = new ArrayList<>();
        DFS("JFK", graph, ans);
        return ans;
    }

    private void DFS(String airport, Map<String, PriorityQueue<String>> graph, List<String> ans) {
        PriorityQueue<String> pq = graph.get(airport);
        while(pq != null && !pq.isEmpty()) {
            DFS(pq.poll(), graph, ans);
        }
        ans.addFirst(airport);
    }
}