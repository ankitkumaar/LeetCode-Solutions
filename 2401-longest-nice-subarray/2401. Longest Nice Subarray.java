class Solution {
    public int longestNiceSubarray(int[] nums) {

        int left = 0, mask = 0, count = 0;
        for(int right = 0; right<nums.length; right++)  {
            
            /* Remove elements from the left until the conflict is resolved */
            while((mask & nums[right]) != 0)   {
                mask ^= nums[left];
                left++;
            }

            /* Add the new number to the mask */
            mask |= nums[right];
            count = Math.max(count, right - left + 1);
        }
        return count;
    }
}