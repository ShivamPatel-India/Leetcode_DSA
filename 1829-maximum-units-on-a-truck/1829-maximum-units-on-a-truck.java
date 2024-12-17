class Solution {
    class Item {
        int nb;
        int ub;
        Item(int nb, int ub) {
            this.nb = nb;
            this.ub = ub;
        } 
    }
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        int n = boxTypes.length;
        List<Item> items = new ArrayList<>();

        for(int i = 0; i<n; i++) {
            items.add(new Item(boxTypes[i][0], boxTypes[i][1]));
        }
        Collections.sort(items, new Comparator<Item>(){
            @Override
            public int compare(Item a, Item b) {
                int f1 = a.ub;
                int f2 = b.ub;
                if(f1<=f2) return 1;
                return -1;
            }
        });
        int totalUnits = 0;
        for(Item i: items) {
            if(i.nb <= truckSize) {
                totalUnits += i.nb*i.ub;
                truckSize -= i.nb;
            } else {
                totalUnits += truckSize*i.ub;
                break;
            }
        }
        return totalUnits;
    }
}