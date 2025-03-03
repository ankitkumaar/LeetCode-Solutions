class Solution {
    public int[] pivotArray(int[] nums, int pivot) {
        
        int index = 0;
        int[] ans = new int[nums.length];
      
        /* Place all elements less than 'pivot' into the 'ans' array */
        for (int num : nums) {
            if (num < pivot)
                ans[index++] = num;
        }
      
        /* Place all elements equal to 'pivot' into the 'ans' array */
        for (int num : nums) {
            if (num == pivot)
                ans[index++] = num;
        }
      
        /* Place all elements greater than 'pivot' into the 'ans' array */
        for (int num : nums) {
            if (num > pivot) {
                ans[index++] = num;
            }
        }
        return ans;
    }
}