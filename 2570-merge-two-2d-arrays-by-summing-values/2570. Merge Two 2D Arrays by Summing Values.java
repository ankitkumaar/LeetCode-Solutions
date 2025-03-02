class Solution {
    public int[][] mergeArrays(int[][] nums1, int[][] nums2) {
        
        /* Create an array to store the sum of values for indices (0 to 1000) */
        int[] arr = new int[1001];
        for (var x : nums1)  {
            arr[x[0]] += x[1];
        }
        for (var x : nums2)  {
            arr[x[0]] += x[1];
        }

        /* Count the number of non-zero elements in arr */
        int n = 0;
        for (int i = 0; i < 1001; i++)  {
            if (arr[i] > 0) {
                n++;
            }
        }

        /* Create the result array with the appropriate size
        Populate the result array with index-value pairs */
        int[][] ans = new int[n][2];
        for (int i = 0, j = 0; i < 1001; i++)  {
            if (arr[i] > 0) {
                ans[j++] = new int[] {i, arr[i]};
            }
        }
        return ans;
    }
}