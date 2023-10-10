class Solution 
{
    public int minOperations(int[] nums) 
    {
        // Sort array in increasing order
        Arrays.sort(nums);
        
        // Initialize len to keep track of unique elements
        int len = 1;
        // Iterate through the sorted array
        // Remove duplicates
        for (int i=1; i<nums.length; ++i) 
        {
            // If the current element is different from the previous one, 
            // Add it to the unique elements
            if (nums[i] != nums[i - 1])
            {
                nums[len] = nums[i];
                len++;
            }
        }
        
        // Initialize the answer variable with the length of the original array
        int ans = nums.length;
        int j = 0;
        // Iterate through the unique elements and find the minimum operations needed
        for (int i=0; i<len; i++)
        {
            // Find the rightmost index j such that nums[j] - nums[i] <= nums.length - 1
            while (j < len && nums[j] < nums[i] + nums.length) 
                j++;

            // Update answer by minimum of the current answer and 
            // The difference between the array length and (j - i)
            ans = Math.min(ans, nums.length - j + i);
        }
        // Return the minimum operations needed 
        // To make the array contain only unique elements
        return ans;
    }
}