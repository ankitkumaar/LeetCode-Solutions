class Solution {
    public int maximumCandies(int[] candies, long k) {
        
        /* Initialize the search space for binary search */
        int l = 0, r = Arrays.stream(candies).max().getAsInt();

        /* Perform binary search to find the maximum number of candies per child */
        while (l < r) {

            /* Midpoint calculation (right-biased) 
            Variable to count the number of children that can receive candies */
            int mid = (l + r + 1) >> 1;
            long cnt = 0;

            /* Count how many children can receive at least 'mid' candies */
            for (int x : candies) {
                cnt += x / mid;
            }

            /* If we can distribute candies to at least k children, move to a larger mid */
            if (cnt >= k) {
                l = mid;
            } else {
                r = mid - 1;
            }
        }
        return l;
    }
}