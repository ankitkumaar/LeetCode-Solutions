class Solution 
{
    public int maxDotProduct(int[] nums1, int[] nums2) 
    {
        int n = nums1.length;
        int m = nums2.length;
        int[][] dp = new int[n+1][m+1];

        for(int d[]: dp)
            Arrays.fill(d, -1);

        return dotProduct(nums1, nums2, n, m, dp);
    }

    public int dotProduct(int[] nums1, int[] nums2, int n, int m, int[][] dp)
    {
        if (m == 0 || n == 0)
            return Integer.MIN_VALUE;

        if (dp[n][m] != -1)
            return dp[n][m];

        int op1= nums1[n-1] * nums2[m-1] + Math.max(0, dotProduct(nums1, nums2, n-1, m-1, dp));
        int op2= Math.max(dotProduct(nums1, nums2, n, m-1, dp), dotProduct(nums1, nums2, n-1, m, dp));
        return dp[n][m]=Math.max(op1, op2);
    }
}