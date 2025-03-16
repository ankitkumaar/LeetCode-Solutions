class Solution {
    public long repairCars(int[] ranks, int cars) {
        
        /* Initialize search space: left (minimum time) and right (maximum time)
        The upper bound is derived from the best rank mechanic taking all cars alone. */
        long left = 0;
        long right = (long) Arrays.stream(ranks).min().getAsInt() * cars * cars;

        /* Perform Binary Search to find the minimum time required to fix all cars */
        while (left < right) {
            long mid = (left + right) / 2;
            
            /* Check if it's possible to fix 'cars' in 'mid' minutes */
            if (numCarsFixed(ranks, mid) >= cars)
                right = mid;
            else
                left = mid + 1;
        }
        return left;
    }
    
    /* Helper method to calculate the number of cars that can be fixed in given time */
    private long numCarsFixed(int[] ranks, long minutes) {
        
        long carsFixed = 0;
        for (int rank : ranks)  {
            
            /* Number of cars a mechanic with 'rank' can fix in 'minutes' time */
            carsFixed += Math.sqrt(minutes / rank);
        }
        return carsFixed;
    }
}