class Solution 
{
    public int integerBreak(int n) 
    {
        // If Integer is equal to 2
        if(n == 2)
            return 1;

        // If Integer is equal to 3
        if(n == 3)
            return 2;

        // If Integer is greater than 4
        int product = 1;
        // Iterate loop
        while(n>4)
        {
            // Compute product = product * 3
            // Substract 3 by n 
            product = product * 3;
            n -= 3;
        }
        // Compute product = product * n
        // Return product
        product = product * n;
        return product;
    }
}