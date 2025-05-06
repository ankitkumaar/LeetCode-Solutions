class Solution {
    public int[] buildArray(int[] nums) {
        
        int n = nums.length;
        
        /* Declare an array 'ans' of same size as of 'nums' 
        Traverse array 'nums' and compute 'ans' */
        int[] ans = new int[n];
        for(int i = 0; i < n; i++)   {
            ans[i] = nums[nums[i]];
        }
        return ans;
    }
}