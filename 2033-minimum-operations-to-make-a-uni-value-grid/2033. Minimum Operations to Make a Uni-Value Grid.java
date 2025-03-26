class Solution {
    public int minOperations(int[][] grid, int x) {
        
        int m = grid.length;
        int n = grid[0].length;

        int k = 0;
        int[] nums = new int[m * n];

        /* Flatten the 2D grid into a 1D array */
        for(int i=0; i<grid.length; i++)   {
            for(int j=0; j<grid[0].length; j++)   {
                nums[k++] = grid[i][j];
            }
        }

        Arrays.sort(nums);
        int midNum = nums[nums.length / 2];
        int count = 0;

        /* Iterate through the grid again to calculate the operations needed */
        for(int i=0; i<grid.length; i++)   {
            for(int j=0; j<grid[0].length; j++)   {

                /* If difference is not a multiple of x, 
                transformation is impossible */
                int diff = Math.abs(midNum - grid[i][j]);

                if(diff % x != 0)   
                    return -1;

                /* Number of operations required for this element */
                count += diff/x;
            }
        }
        return count;
    }
}