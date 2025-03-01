class Solution {
    public int[] applyOperations(int[] nums) {

        /* Merge adjacent equal elements and set the next element to zero */
        for(int i=0; i<nums.length-1; i++)  {
            if(nums[i] == nums[i+1])    {
                nums[i] *= 2; nums[i+1] = 0;
            }
        }

        /* Shift all non-zero elements to the left while maintaining order */
        int pos=0;
        for(int i=0; i<nums.length; i++)  {
            if(nums[i] != 0)  {
                if(i != pos)   {
                int temp = nums[pos];
                nums[pos] = nums[i]; nums[i] = temp;
                }
                pos++;
            }
        }
        return nums;
    }
}