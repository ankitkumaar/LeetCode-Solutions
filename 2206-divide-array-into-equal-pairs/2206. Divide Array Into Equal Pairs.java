class Solution {
    public boolean divideArray(int[] nums) {
        
        /* Create a HashMap to store the frequency of each number */
        HashMap<Integer, Integer> hmap = new HashMap<>();

        /* Iterate through the array and count occurrences of each number */
        for(int i=0; i<nums.length; i++)   {
            hmap.put(nums[i], hmap.getOrDefault(nums[i], 0) + 1);
        }
        
        /* Variable flag to check if all elements appear even number of times */
        boolean flag = true;

        /* Iterate through the HashMap to verify frequency conditions */
        for(Map.Entry<Integer, Integer> hm : hmap.entrySet())  {

            /* If any number appears an odd number of times, return false */
            if(hm.getValue() % 2 != 0)  {
                flag = false;
                break;
            }
        }
        return flag;
    }
}