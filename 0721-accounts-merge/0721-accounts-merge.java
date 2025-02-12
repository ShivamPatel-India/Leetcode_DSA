class DisjointSet {
    List<Integer> rank = new ArrayList<>();
    List<Integer> parent  = new ArrayList<>();

    DisjointSet(int n) {
        for(int i = 0; i <= n; i++) {
            rank.add(0);
            parent.add(i);
        }
    }

    public int findUPar(int node) {
        if(node == parent.get(node)) return node;
        else {
            int ulp = findUPar(parent.get(node));
            parent.set(node, ulp);
            return parent.get(node);
        }
    }

    public void unionByRank(int u, int v) {
        int ulp_u = findUPar(u);
        int ulp_v = findUPar(v);

        if(ulp_u == ulp_v) return;

        if(rank.get(ulp_u) > rank.get(ulp_v)) parent.set(ulp_v, ulp_u);
        else if(rank.get(ulp_v) > rank.get(ulp_u)) parent.set(ulp_u, ulp_v);
        else {
            parent.set(ulp_v, ulp_u);
            int rankU = rank.get(ulp_u);
            rank.set(ulp_u, rankU + 1);
        }
    }
}
class Solution {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        int n = accounts.size();
        DisjointSet ds = new DisjointSet(n);
        HashMap<String, Integer> mapMailNode = new HashMap<>();

        for(int i = 0 ; i < n; i++) {
            for(int j = 1; j < accounts.get(i).size(); j++) {
                String mail = accounts.get(i).get(j);
                if(mapMailNode.containsKey(mail) == false) {
                    mapMailNode.put(mail, i);
                } else {
                    ds.unionByRank(mapMailNode.get(mail), i);
                }
            }
        } 

        List<List<String>> mergedMail = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            mergedMail.add(new ArrayList<>());
        }      
        for(Map.Entry<String, Integer> it : mapMailNode.entrySet()) {
            String mail = it.getKey();
            int node = ds.findUPar(it.getValue());
            mergedMail.get(node).add(mail);
        }

        List<List<String>> ans = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            if(mergedMail.get(i).size() == 0) continue;
            Collections.sort(mergedMail.get(i));
            List<String> temp = new ArrayList<>();
            temp.add(accounts.get(i).get(0));
            for(String mail: mergedMail.get(i)) temp.add(mail);
            ans.add(temp);
        }
        return ans;
    }
}