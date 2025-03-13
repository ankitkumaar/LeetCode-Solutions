class Solution {
    public int maximumCount(int[] nums) {

        /* Compute number of Negative Integers and
        Number of Positive Integers in nums[] */
        int numberOfNegativeIntegers = lastNegativeInteger(nums) + 1;
        int numberOfPositiveIntegers = nums.length - firstPositiveInteger(nums);
        
        return Math.max(numberOfNegativeIntegers, numberOfPositiveIntegers);
    }

    /* Method to find index of last Negative Integer using Binary Search */
    private int lastNegativeInteger(int[] nums)   {
        int low = 0, high = nums.length - 1;
        while(low <= high)  {
            int mid = low + (high - low)/2;
            if(nums[mid] >= 0)
                high = mid - 1;
            else
                low = mid + 1;
        }
        return high;
    }

    /* Method to find index of first Positive Integer using Binary Search */
    private int firstPositiveInteger(int[] nums)   {
        int low = 0, high = nums.length - 1;
        while(low <= high)  {
            int mid = low + (high - low)/2;
            if(nums[mid] <= 0)
                low = mid + 1;
            else
                high = mid - 1;
        }
        return low;
    }
}