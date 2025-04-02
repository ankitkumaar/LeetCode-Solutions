class Solution {
    public long mostPoints(int[][] questions) {
        
        int n = questions.length;

        /* Create a DP array to store max points at each index */
        long[] dp = new long[n + 1];
        
        /* Iterate through the questions array in reverse order */
        for (int i = n-1; i >= 0; i--) {

            /* Points earned for solving this question
            Brainpower required (i.e., cooldown period)
            Next question that can be solved after this one
            Get points from valid next question */
            int points = questions[i][0];   
            int brainpower = questions[i][1];  
            int nextIndex = i + brainpower + 1;
            long nextPoints = (nextIndex < n) ? dp[nextIndex] : 0;

            /* Take the maximum of solving this question or skipping it */
            dp[i] = Math.max(points + nextPoints, dp[i + 1]);  
        }
        return dp[0];
    }
}