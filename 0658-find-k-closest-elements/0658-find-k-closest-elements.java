class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> list = Arrays.stream(arr).boxed().collect(Collectors.toList());
        list.sort((a, b) -> {
            int diff = Math.abs(a-x) - Math.abs(b-x);
            return diff == 0 ? Integer.compare(a,b) : diff;
        });

        List<Integer> result = list.subList(0, k);
        Collections.sort(result);
        return result;
    }
}