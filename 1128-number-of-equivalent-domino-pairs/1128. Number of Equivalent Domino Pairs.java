class Solution {
    public int numEquivDominoPairs(int[][] dominoes) {
        
        /* Initialize the result to store the number of equivalent domino pairs
        Array to count occurrences of each unique domino representation */
        int[] count = new int[100];
        int result = 0;

        // Iterate through each domino in the input array
        for (int[] d : dominoes) {
            
            int a = d[0], b = d[1];
            int key = a < b ? a * 10 + b : b * 10 + a;
            
            /* Add the current count of this key to the result
            Increment the count for this key */
            result += count[key];
            count[key]++;
        }
        return result;
    }
}
