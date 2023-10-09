class Solution 
{
    public int[] searchRange(int[] nums, int target) 
    {
        // Initialize the result array 
        // To store the starting and ending positions
        int[] result = new int[2];

        // Initialize the position variable
        // Binary search for the left boundary of the target element
        int pos = -1, low = 0, high = nums.length - 1;
        while(low <= high)
        {
            // Compute middle position
            int mid = low + (high - low)/2;
            // Adjust the search range 
            // Based on the comparison with the target
            if (nums[mid] < target)
                low = mid + 1;
            else if (nums[mid] > target)
                high = mid - 1;

            else
            {
                // Update position and search towards the left
                pos = mid;
                high = mid - 1;
            }
        }
        // Store left boundary position
        result[0] = pos;

        // Reset the position variable
        // Binary search for the right boundary of the target element
        pos = -1; low = 0; high = nums.length - 1;
        while(low <= high)
        {
            // Compute middle position
            int mid = low + (high - low)/2;
            // Adjust the search range 
            // Based on the comparison with the target
            if (nums[mid] < target)
                low = mid + 1;
            else if (nums[mid] > target)
                high = mid - 1;

            else
            {
                // Update position and search towards the right
                pos = mid;
                low = mid + 1;
            }
        }
        // Store right boundary position
        result[1] = pos;
        // Return result array
        return result;
    }
}