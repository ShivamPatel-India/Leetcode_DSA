// Time complexity: O(g log g + c log c + c)
// g log g to sort the greed array 
// c log c to sort the cookies array
// c because we are traversing the cookies array and at most all the cookies can be given to satisfy the greed
class Solution {
    public int findContentChildren(int[] greed, int[] cookies) {
        // length of the greed array
        int greedLength = greed.length;
        // pointer for greed array
        int gp = 0;
        // length of the cookies array
        int cookiesLength = cookies.length;
        // pointer for cookies array
        int cp = 0;
        
        // sort the greed and cookies array in ascending order
        Arrays.sort(greed);
        Arrays.sort(cookies);

        // traversing the array 
        while(gp < greedLength && cp < cookiesLength) {
            // if the greed can be satisfied than increase the greed pointer
            if(greed[gp] <= cookies[cp]) {
                gp++;
            }
            // increase the cookies pointer in either of the cases
            cp++;
        }
        // returning the greed pointer reffering to the total greed satisfied
        return gp;
    }
}