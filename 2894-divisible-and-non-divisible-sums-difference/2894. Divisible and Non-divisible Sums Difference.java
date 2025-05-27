class Solution {
    public int differenceOfSums(int n, int m) {
        
        /* Initialize two variables to store the sums */
        int sumOfDivisible = 0, sumOfNotDivisible = 0;

        /* Loop through all numbers from 1 to n */
        for (int i = 1; i <= n; i++) {

            /* If the number is divisible by m, add it to sumOfDivisible
            Otherwise, add it to sumOfNotDivisible */
            if (i % m == 0)
                sumOfDivisible += i;
            else
                sumOfNotDivisible += i;
        }

        /* Return the difference between the two sums */
        return sumOfNotDivisible - sumOfDivisible;
    }
}