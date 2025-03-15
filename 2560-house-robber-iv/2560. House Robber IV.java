class Solution {
    public int minCapability(int[] nums, int k) {
        
        /* Start with the least possible capability and Set an upper limit 
        for the search space, assuming the max value according to problem constraints */
        int left = 0, right = (int) 1e9;

        /* Perform a Binary Search to find the minimum capability */
        while (left < right) {
            int mid = (left + right) >> 1;

            /* Check if the current capability can achieve the required partition */
            if (calculatePartitionCount(nums, mid) >= k)
                right = mid;
            else
                left = mid + 1;
        }
        return left;
    }
    
    /* Helper method to calculate the number of partitions formed by capability x */
    private int calculatePartitionCount(int[] nums, int x) {
        
        /* Initialize the partition count and
        Initialize the index of the last partition start */
        int count = 0;
        int lastPartitionIndex = -2;

        /* Iterate over the array */
        for (int i = 0; i < nums.length; i++) {
            /* Skip if the current number exceeds the capability or 
            is the next immediate number after the last partition */
            if (nums[i] > x || i == lastPartitionIndex + 1) {
                continue;
            }
            /* Increment the partition count and update lastPartitionIndex */
            count++;
            lastPartitionIndex = i;
        }
        return count;
    }
}