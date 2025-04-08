class Solution {
    public int minimumOperations(int[] nums) {
        int ans = 0;

        /* Loop through the array, increasing the index by 3 in each iteration
        and incrementing the operation count */
        for (int i = 0; i < nums.length; i += 3, ans++) {
        
            /* Check if the subarray starting from index i 
            contains all unique elements */
            if (checkUnique(nums, i))
                return ans;
        }
        return ans;
    }

    /* Helper method to check if all elements from 'start' to end are unique */
    private boolean checkUnique(int[] nums, int start) {
        HashSet<Integer> cnt = new HashSet<>();

        /* Iterate from 'start' to the end of the array */
        for (int i = start; i < nums.length; i++) {
            
            /* If a duplicate is found, return false */
            if (cnt.contains(nums[i]))  {
                return false;
            }
            cnt.add(nums[i]);
        }
        return true;
    }
}