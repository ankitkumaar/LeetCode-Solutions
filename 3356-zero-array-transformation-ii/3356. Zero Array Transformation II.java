class Solution {
    public int minZeroArray(int[] nums, int[][] queries) {
        
        /* Variables to store lengths of array and
        for Binary Search boundries */
        int n = nums.length, q = queries.length;
        int left = 0, right = q + 1;

        /* Perform Binary Search to find the minimum number of operations */
        while (left < right) {
            int mid = (left + right) >> 1;

            if (check(n, mid, nums, queries))
                right = mid;
            else
                left = mid + 1;
        }
        return (left > q)? -1 : left;
    }

    /* Method to find the minimum number of queries needed 
    to make all elements in nums non-positive */
    private boolean check(int n, int q, int[] nums, int[][] queries) {
        int[] prefixSum = new int[n + 1];

        /* Iterate and Apply the first 'q' queries to the prefixSum */
        for(int i = 0; i < q; i++)  {
            int low = queries[i][0], high = queries[i][1], value = queries[i][2];
            prefixSum[low] += value;
            prefixSum[high + 1] -= value;
        }
        
        int sum = 0;
        
        /* Calculate the prefix sum and check if nums[i] can be made non-positive */
        for (int i = 0; i < n; i++) {
            sum += prefixSum[i];
            if (nums[i] > sum)
                return false;
        }
        return true;
    }
}