class Solution {
    public long countSubarrays(int[] nums, int minK, int maxK) {

        /* Replace elements out of the [minK, maxK] range with 0 */
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < minK || nums[i] > maxK)
                nums[i] = 0;
        }
        
        long totalCount = 0;
        int pos1 = 0, pos2 = 0;

        /* Iterate through the array to find segments separated by  */
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                pos2 = i;
                totalCount += findSubsetsCount(nums, pos1, pos2, minK, maxK);
                pos1 = pos2 + 1;
            }
        }

        /* Handle the last segment */
        totalCount += findSubsetsCount(nums, pos1, nums.length, minK, maxK);
        return totalCount;
    }

    private long findSubsetsCount(int[] nums, int start, int end, int minK, int maxK) {
        long count = 0;
        int minPos = -1, maxPos = -1;
        
        /* Iterate through the segment to find valid subarrays */
        for (int i = start; i < end; i++) {
            if (nums[i] == minK) 
                minPos = i;
            if (nums[i] == maxK) 
                maxPos = i;
            if (minPos != -1 && maxPos != -1)
                count += Math.min(minPos, maxPos) - start + 1;
        }
        return count;
    }
}