class Solution {
    public int maximumCount(int[] nums) {

        /* variables to count frequency of positive and negative integers */
        int countNeg = 0, countPos = 0;

        /* Iteration nums[] to count frequency */
        for(int i=0; i<nums.length; i++) {
            if(nums[i] < 0)
                countNeg++;
            if(nums[i] > 0)
                countPos++;
        }
        return Math.max(countNeg, countPos);
    }
}