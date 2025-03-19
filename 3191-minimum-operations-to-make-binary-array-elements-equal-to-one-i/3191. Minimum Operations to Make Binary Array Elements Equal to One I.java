class Solution {
    public int minOperations(int[] nums) {
        
        /* If the array has exactly 3 elements and their sum is 3, 
        it means all elements are 1, and no operations are needed */
        if(nums.length == 3)   {
            if((nums[0] + nums[1] + nums[2]) == 3)
            return 0;
        }

        /* 'left' is the pointer, 'count' keeps track of operations */
        int left = 0, count = 0;

        /* Iterate while ensuring at least 3 elements are left to process */
        while(left < nums.length-2)   {
            
            /* If the current element is 0, we need to flip a segment of size 3 */
            if(nums[left] == 0)   {
                count++;
                
                /* Used to flip exactly 3 elements */
                int right = 0;
                while(right < 3)  {

                    /* Flip the value (0 → 1, 1 → 0) */
                    nums[left] = (nums[left] == 0)? 1:0;
                    right++; left++;
                }
                /* Move the left pointer back by 2 to recheck the sequence */
                left -=2;
            }

            /* Move to the next element if it's already 1 */
            else
                left++;
        }

        /* Check if any 0s remain in the entire array */
        for(int i=0; i<nums.length; i++) {
            if(nums[i] == 0)    
                return -1;
        }
        return count;
    }
}