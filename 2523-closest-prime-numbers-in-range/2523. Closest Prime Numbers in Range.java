class Solution {
    public int[] closestPrimes(int left, int right) {
        
        /* Generate a sieve array where sieve[i] == 1 means 'i' is prime */
        int[] sieveArray = sieve(right);
        List<Integer> primeNumbers = new ArrayList<>();

        /* Collect all prime numbers in the given range [left, right] */
        for(int num = left; num <= right; num++)  {
            if(sieveArray[num] == 1)
                primeNumbers.add(num);
        }

        /* If there are fewer than two prime numbers, return [-1, -1] */
        if (primeNumbers.size() < 2) 
            return new int[] { -1, -1 };

        int minDiff = Integer.MAX_VALUE;
        int[] closestPair = new int[2];
        Arrays.fill(closestPair, -1);

        /* Iterate through the prime numbers to find the closest pair */
        for (int index = 1; index < primeNumbers.size(); index++) {
            int diff = primeNumbers.get(index) - primeNumbers.get(index - 1);

            /* Update closestPair if a smaller difference is found */
            if (diff < minDiff) {
                minDiff = diff;
                closestPair[0] = primeNumbers.get(index - 1);
                closestPair[1] = primeNumbers.get(index);
            }
        }
        return closestPair;
    }

    /* Function to generate the Sieve of Eratosthenes up to 'upperLimit' */
    private int[] sieve(int upperLimit) {
        
        /* Initialize sieve array where 1 represents prime, 0 represents non-prime */
        int[] sieve = new int[upperLimit + 1];
        Arrays.fill(sieve, 1);
        sieve[0] = 0;
        sieve[1] = 0;

        /* Mark multiples of each prime as non-prime */
        for (int num = 2; num * num <= upperLimit; num++) {
            if (sieve[num] == 1) {
                for (int multi = num * num; multi <= upperLimit; multi += num) {
                    sieve[multi] = 0;
                }
            }
        }
        return sieve;
    }
}