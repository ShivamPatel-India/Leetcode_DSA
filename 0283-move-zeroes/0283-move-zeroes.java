class Solution {
    public void moveZeroes(int[] nums) {
        int n = nums.length;
        int j = -1;

        // setting the j pointer to the first '0' element
        for(int i = 0; i<n; i++) {
            if(nums[i] == 0) {
                j = i;
                break;
            }
        }

        // if there is no '0' element then return back from the function
        if(j == -1) return;

        for(int i = j+1; i<n; i++) {
            if(nums[i] != 0) {
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
                j++;
            }
        }


    }
}