class Solution {
    public int findNumbers(int[] nums) {
        
        /* Initialize variable 'count' to count no. of even number of digits 
        variable 'size' to store length of an array 'nums' */
        int count = 0;
        int size = nums.length;

        /* Iterate loop till size of 'nums' */
        for(int i = 0; i < size; i++)    {

            /* Declare variable 'str' to store convertion of Integer to String 
            variable 'len' to compute length of eact array integer */
            String str = Integer.toString(nums[i]);
            int len = str.length();

            /* Condition to check even no. of digits and Increment count*/
            if(len % 2 == 0)
                count++;
        }
        return count;
    }
}