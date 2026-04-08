class Solution {
    class Node {
        String target;
        double val;
        Node(String _target, double _val) {
            this.target = _target;
            this.val = _val;
        }
    }
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        Map<String, List<Node>> map = new HashMap<>();
        int n = equations.size();
        for(int i = 0; i < n; i++) {
            String u = equations.get(i).get(0);
            String v = equations.get(i).get(1);
            double val = values[i];    
            map.computeIfAbsent(u, k -> new ArrayList<>()).add(new Node(v, val));
            map.computeIfAbsent(v, k -> new ArrayList<>()).add(new Node(u, 1.0/val));
        }

        int m = queries.size();
        double[] result = new double[m];
        int i = 0;
        for(List<String> q: queries) {
            String src = q.get(0);
            String dest = q.get(1);

            double[] ans = {-1.0};
            double[] product = {1.0};

            if(map.containsKey(src) && map.containsKey(dest)) {
                Set<String> visited = new HashSet<>();
                dfs(src, dest, ans, product, map, visited);
            }
            result[i++] = ans[0];
        }
        return result;
    }
    private void dfs(String src, String dest, double[] ans, double[] product, Map<String, List<Node>> map, Set<String> visited) {
        if(visited.contains(src)) return;
        visited.add(src);

        if(src.equals(dest)) {
            ans[0] = product[0];
            return;
        }

        for(Node adj: map.get(src)) {
            String adjSrc = adj.target;
            double val = adj.val;
            product[0] *= val;
            dfs(adjSrc, dest, ans, product, map, visited);
            product[0] /= val;
        }
    }
}