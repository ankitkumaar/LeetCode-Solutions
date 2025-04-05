class Solution {
    public int subsetXORSum(int[] nums) {

        int ans = 0;
        int totalSubsets = 1 << nums.length;

        /* Iterate through all possible subsets */
        for (int i = 0; i < totalSubsets; i++) {

            int sum = 0;

            /* Check each bit to decide whether to include nums[j] 
            in the current subset */
            for (int j = 0; j < nums.length; j++) {
                
                /* If j-th bit in i is set, 
                include nums[j] in current subset XOR */
                if ((i & (1 << j)) != 0)
                    sum ^= nums[j];
            }

            /* Add the XOR of current subset to the final answer */
            ans += sum;
        }
        return ans;
    }
}