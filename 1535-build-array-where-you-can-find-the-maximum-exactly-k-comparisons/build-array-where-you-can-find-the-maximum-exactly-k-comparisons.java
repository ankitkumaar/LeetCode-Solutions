class Solution 
{
    public int numOfArrays(int n, int m, int k) 
    {
        int MOD = 1000000007;
        // Create a 3D array to store the dynamic programming values
        // dp[len][maxVal][cost] represents the number of ways to form
        // an array of length 'len' with maximum value 'maxVal' and 'cost' cost
        long[][][] dp = new long[n + 1][m + 1][k + 1];

        // Initialize the base case for arrays of length 1
        for (int i=1; i<=m; i++) 
            dp[1][i][1] = 1;

        // Calculate the number of arrays for lengths from 2 to 'n'
        for (int len=2; len<=n; len++) 
        {
            for (int maxVal=1; maxVal<=m; maxVal++) 
            {
                for (int cost=1; cost<=k; cost++) 
                {
                    long sum = 0;
                    // Calculate the sum of possibilities from previous lengths
                    for (int i = 1; i<maxVal; i++) 
                        sum = (sum + dp[len - 1][i][cost - 1]) % MOD;

                    // Update the current dp value based on the sum and maxVal
                    dp[len][maxVal][cost] = (dp[len - 1][maxVal][cost] * maxVal + sum) % MOD;
                }
            }
        }

        long ans = 0;
        // Calculate the total number of arrays for length 'n' and cost 'k'
        for (int i=1; i<=m; i++) 
            ans = (ans + dp[n][i][k]) % MOD;

        // Return the final answer as an integer
        return (int)ans;
    }
}