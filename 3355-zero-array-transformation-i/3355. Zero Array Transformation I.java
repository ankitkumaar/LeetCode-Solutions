class Solution {
    public boolean isZeroArray(int[] nums, int[][] queries) {

        /* Create a difference array to apply range updates */
        int[] diffArray = new int[nums.length + 1];

        /* Apply each query as range increment using difference array */
        for (int i = 0; i < queries.length; i++) {
            diffArray[queries[i][0]]++;
            diffArray[queries[i][1] + 1]--;
        }

        /* Compute the prefix sum of difference array 
        to get the actual increments */
        for (int i = 1; i < diffArray.length; i++) {
            diffArray[i] = diffArray[i] + diffArray[i-1];
        }

        /* Check if each element in nums can be reduced to zero or less */
        for (int i = 0; i < nums.length; i++) {
            if (diffArray[i] < nums[i])
                return false;
        }

        /* All elements can be reduced to zero */
        return true;
    }
}
