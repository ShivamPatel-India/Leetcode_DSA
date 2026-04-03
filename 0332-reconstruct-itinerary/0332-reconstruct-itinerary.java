class Solution {
    private void DFS(String airport, Map<String, List<String>> map, List<String> ans) {
        List<String> destinations = map.get(airport);
        while(destinations != null && !destinations.isEmpty()) {
            String next = destinations.remove(0);
            DFS(next, map, ans);
        }
        ans.addFirst(airport);
    }
    public List<String> findItinerary(List<List<String>> tickets) {
        // create a map to store the list of destinations for each departure airport
        Map<String, List<String>> map = new HashMap<>();
        for(List<String> ticket: tickets) {
            String to = ticket.get(1);
            String from = ticket.get(0);
            map.computeIfAbsent(from, k -> new ArrayList<>()).add(to);
        }

        // sort all values of every key in lexical order
        for(List<String> destinations: map.values()) {
            Collections.sort(destinations);
        }

        List<String> itinerary = new ArrayList<>();
        DFS("JFK", map, itinerary);
        return itinerary;
    }
}