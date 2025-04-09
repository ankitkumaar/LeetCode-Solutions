class Solution {
    public int minOperations(int[] nums, int k) {
        
        /* Create a HashSet to store unique elements from the array */
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            set.add(nums[i]);
        }

        /* Check if any number in the set is less than k, 
        If so return -1 */
        for (Integer s : set) {
            if (s < k) return -1;
        }

        /* Count how many unique numbers are greater than k */
        int count = 0;
        for (Integer s : set) {
            if (s > k) count++;
        }

        /* Return the number of operations needed */
        return count;
    }
}