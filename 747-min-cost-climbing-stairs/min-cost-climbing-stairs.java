class Solution 
{
    public int minCostClimbingStairs(int[] cost) 
    {
        // Store the length of the given cost array
        int n = cost.length;
        // Create an array DP to store minimum costs at each step
        // Initialize the first two elements of DP
        int[] dp = new int[n+1];
        dp[0] = cost[0];
        dp[1] = cost[1];

        // Calculate the minimum cost for each step
        // Starting from the third step
        for(int i=2; i<n; i++)
            dp[i] = Math.min(dp[i-1], dp[i-2]) + cost[i];

        // Return the minimum cost, 
        // Which is either the last or second-to-last element in the DP array
        return Math.min(dp[n-1], dp[n-2]);
    }
}