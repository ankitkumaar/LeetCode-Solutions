class Solution {
    public long minSum(int[] nums1, int[] nums2) {

        /* Initialize variables 'count1' and 'sum1' for array nums1[] */
        long count1 = 0, sum1 = 0;
        for(int i = 0; i < nums1.length; i++)  {
            sum1 += nums1[i];
            if(nums1[i] == 0)
                count1++;
        }

        /* Initialize variables 'count2' and 'sum2' for array nums2[] */
        long count2 = 0, sum2 = 0;
        for(int i = 0; i < nums2.length; i++)  {
            sum2 += nums2[i];
            if(nums2[i] == 0)
                count2++;
        }

        /* Check if array nums1[] has no zeros and the sums are not equal */
        if(count1 == 0 && sum1 + count1 < sum2 + count2)
            return -1;

        /* Check if array nums2[] has no zeros and the sums are not equal */
        if(count2 == 0 && sum1 + count1 > sum2 + count2)
            return -1;

        /* Return the maximum of the two sums plus their respective counts */
        return Math.max(sum1 + count1, sum2 + count2);
    }
}