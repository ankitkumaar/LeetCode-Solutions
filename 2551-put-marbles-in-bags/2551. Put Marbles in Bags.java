class Solution {
    public long putMarbles(int[] weights, int k) {
        
        int n = weights.length;

        /* Initialize variables to store the minimum and maximum sum */
        long mn = 0, mx = 0;

        /* Create an array to store pairwise sums of adjacent elements */
        int[] arr = new int[n - 1];

        /* Compute the sum of adjacent elements and store them in the array */
        for (int i=0; i<arr.length; i++)   {
            arr[i] = weights[i] + weights[i + 1];
        }

        /* Sort the array to easily access the smallest and largest sums */
        Arrays.sort(arr);

        /* Calculate the sum of the k-1 smallest and k-1 largest values 
        from the sorted array */
        for (int i=0; i<(k-1); i++) {

            /* Sum of the smallest k-1 pairwise sums
            Sum of the largest k-1 pairwise sums */
            mn += arr[i];
            mx += arr[arr.length - (i + 1)];
        }
        return mx - mn;
    }
}