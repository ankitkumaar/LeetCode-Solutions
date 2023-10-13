class Solution 
{
    public int climbStairs(int n) 
    {
        // If n is equal to 1
        if (n == 1)
            return 1;

        // If n is equal to 2
        if (n == 2)
            return 2;

        // Create an array DP to store minimum costs at each step
        // Initialize the first two elements of DP
        int[] dp = new int[n+1];
        dp[1] = 1;
        dp[2] = 2;

        // Calculate the minimum cost for each step
        // Starting from the third step
        for(int i=3; i<n+1; i++)
            dp[i] = dp[i-1] + dp[i-2];

        // Return the minimum jumps
        return dp[n];
    }
}