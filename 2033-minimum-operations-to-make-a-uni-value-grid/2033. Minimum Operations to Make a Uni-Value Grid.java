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
        boolean flag = true;

        /* Iterate through the grid again to calculate the operations needed */
        for(int i=0; i<grid.length; i++)   {
            for(int j=0; j<grid[0].length; j++)   {
                double ans = 0.0;

                /* If the current element is smaller than the median */
                if(grid[i][j] < midNum)   {
                    ans = (double)(midNum - grid[i][j]) / x;
                }

                /* If the current element is greater than the median */
                else if(grid[i][j] > midNum)   {
                    ans = (double)(grid[i][j] - midNum) / x;
                }

                /* If the element is already equal to the median */
                else
                     continue;
                
                double ansFloor = Math.floor(ans);
                double ansCeil = Math.ceil(ans);
                
                /* Check if the number of operations is an integer */
                if(((int)ans == (int)ansCeil) && ((int)ans == (int)ansFloor))   {
                    count += (int)ans;
                }
                else
                    flag = false;
            }
        }

        /* If transformation is possible, return the total count of operations
        Otherwise, return -1 indicating it's not possible */
        if(flag) return count;
        return -1;
    }
}