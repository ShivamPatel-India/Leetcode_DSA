class Solution {
    public List<List<Integer>> threeSum(int[] arr) {
        int n = arr.length;
        Set<List<Integer>> ans = new HashSet<>();

        for(int i = 0; i < n; i++) {
            Set<Integer> set = new HashSet<>();
            for(int j = i+1; j < n; j++) {
                int k = -(arr[i]+arr[j]);
                // if third element k present in set, we found a triplet
                if(set.contains(k)) {
                    List<Integer> temp = Arrays.asList(arr[i], k, arr[j]);
                    Collections.sort(temp);
                    ans.add(temp);
                }
                set.add(arr[j]);
            }
        }
        return new ArrayList<>(ans);
    }
}