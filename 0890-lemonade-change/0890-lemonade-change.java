// Greedy approach that iterate over the given bills array and add or remove the past bills in order to give a change on the basis of current given bill.

// Time Complexity: O(N) where N is the number of people in queue/ bills we will deal with. We iterate through each customer’s bills exactly once. The loop runs for N iterations and at each iteration the operations performed are constant time.

// Space Complexity: O(1) as the algorithm uses only a constant amount of extra space regardless of the size of the input array. It does not require any additional data structures that scale with the input size.


class Solution {
    public boolean lemonadeChange(int[] bills) {
        int five = 0;
        int ten = 0;

        for(int i = 0; i< bills.length; i++) {
            if(bills[i] == 5) ++five;
            else if(bills[i] == 10) {
                if(five > 0) {
                    --five;
                    ++ten;
                } else return false;
            } else if(bills[i] == 20) {
                if(ten>0 && five>0) {
                    --ten;
                    --five;
                } else if(five>=3) {
                    five -= 3;
                } else return false;
            }
        }
        return true;
    }
}