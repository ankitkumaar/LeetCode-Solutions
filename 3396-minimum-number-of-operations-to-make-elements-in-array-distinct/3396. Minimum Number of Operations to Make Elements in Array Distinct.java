class Solution {
    public int minimumOperations(int[] nums) {

        /* Create a HashSet to store unique elements from the array */
        Set<Integer> set = new HashSet<>();

        /* Iterate over array in reverse order */
        for(int i=nums.length-1; i>=0; i--)   {
            if(!set.add(nums[i]))
                return (i/3) + 1;
        }
        return 0;
    }
}